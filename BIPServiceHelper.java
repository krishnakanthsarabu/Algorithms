//import java.io.*;
//import java.sql.Array;
//import java.net.*;
//import java.util.*;
//import java.util.LinkedHashMap;
//import java.util.Iterator;
//import java.util.Map.Entry;
//import javax.xml.namespace.*;
//import com.oracle.xmlns.oxp.service.v2.*;
//import com.oracle.xmlns.oxp.service.v2.ReportResponse;
//import oracle.xdo.common.pdf.util.PDFDocMerger;
//import org.apache.pdfbox.multipdf.PDFMergerUtility;
//
//public class BIPServiceHelper
//{
//  /**
//   * This method is called when we have to generate multiple BIP Reports and Merge them into one PDF output
//
//   * TODO : Need to add HashMap paramters for each individual BIP Report
//   * TODO : Put All the Files that have to be merged in a new Folder with new name
//   * TODO : Get Web Service Session Once Rather than for each call
//   *
//   * @param java.sql.Array commonParams   // The List of Parameters this method needs to execute any BIP Reports - Environment Specific
//   * @param java.sql.Array reportsList  // The List of BIP Report Catalog Paths to be called and merged
//
//   * @commonParams Array - Sequence is important - Always query these values from WF_DBO.CONFiGURATIONS Table before passing to this method
//            0 String secServiceTargetNS
//            1 String secServiceWSDL
//            2 String secServiceName
//            3 String targetNameSpace
//            4 String wsdlURL
//            5 String serviceName
//            6 String bipadminuser
//            7 String bipadminupwd
//            8 String impersonatingUser
//            9 String outputFormat   -- TODO - Think about other Formats if needed
//            10 String finalOutputFileName
//
//   * @reportsList Array - Sequence is important
//
//   * @return
//   */
//  public static String runReportsAndMerge(java.sql.Array commonParams,java.sql.Array reportsList, java.sql.Array reportsParamNames, java.sql.Array reportsParamValues)
//  {
//System.out.println("In BIPServiceHelper.runReportsAndMerge() Function ..");
//    try
//    {
//      Object bipParams = commonParams.getArray();
//      Object repListParams = reportsList.getArray();
//      Object reportParamNames = reportsParamNames.getArray();
//      Object reportParamValues = reportsParamValues.getArray();
//
//      String finalOutputFilePath = "";
//      String secServiceTargetNS = "";
//      String secServiceWSDL = "";
//      String secServiceName = "";
//      String targetNameSpace = "";
//      String wsdlURL = "";
//      String serviceName = "";
//      String bipadminuser = "";
//      String bipadminupwd = "";
//      String impersonatingUser = "";
//      String outputFormat = "";
//      String finalOutputFileName = "";
//      String sessionId = "";
//      String reportParamNamesCSV = "";
//      String reportParamValuesStr = "";
//      String reportsOutputFolderPath = "";
//
//      int bipParamsLength = java.lang.reflect.Array.getLength( bipParams );
//      int reportsListLength = java.lang.reflect.Array.getLength( repListParams );
//      int reportParamNamesLength = java.lang.reflect.Array.getLength( reportParamNames );
//      int reportParamValuesLength = java.lang.reflect.Array.getLength( reportParamValues );
////System.out.println("bipParamsLength : " + bipParamsLength);
////System.out.println("reportsListLength : " + reportsListLength);
////System.out.println("reportParamNamesLength : " + reportParamNamesLength);
////System.out.println("reportParamValuesLength : " + reportParamValuesLength);
//
//      String[] bipParamsArray = new String[bipParamsLength];
//      String[] reportsListParamsArray = new String[reportsListLength];
//      String[] outputFilePaths = new String[reportsListLength];
//      String[] reportParamNamesListArray = new String[reportsListLength];
//      String[] reportParamValuesListArray = new String[reportsListLength];
//      String[] reportParamNamesArray = null;
//      String[] reportParamValuesArray = null;
//      File[] inputFilesToMerge = new File[reportsListLength];
//      PDFMergerUtility pdfMerger = new PDFMergerUtility();
//
////System.out.println("bipParamsArray .. " + bipParamsLength);
//      for (int i=0; i < bipParamsLength; i++)
//      {
//        bipParamsArray[i] = String.valueOf( java.lang.reflect.Array.get(bipParams, i) );
//        //System.out.println("\t" + bipParamsArray[i]);
//      }
//      //  Get Common Report Parameters
//      secServiceTargetNS      = bipParamsArray[0];
//      secServiceWSDL          = bipParamsArray[1];
//      secServiceName          = bipParamsArray[2];
//      targetNameSpace         = bipParamsArray[3];
//      wsdlURL                 = bipParamsArray[4];
//      serviceName             = bipParamsArray[5];
//      bipadminuser            = bipParamsArray[6];
//      bipadminupwd            = bipParamsArray[7];
//      impersonatingUser       = bipParamsArray[8];
//      reportsOutputFolderPath = bipParamsArray[9];
//      outputFormat            = bipParamsArray[10];
//      finalOutputFileName     = bipParamsArray[11];
//      finalOutputFilePath     = reportsOutputFolderPath + finalOutputFileName;
//
//      SecurityService_Service securityService_Service = new SecurityService_Service(new URL(secServiceWSDL), new QName(secServiceTargetNS, secServiceName));
//      SecurityService securityService = securityService_Service.getSecurityService();
//
//      ReportService_Service reportService_Service = new ReportService_Service(new URL(wsdlURL), new QName(targetNameSpace, serviceName));
//      ReportService reportService = reportService_Service.getReportService();
//
//      sessionId = securityService.impersonate(bipadminuser, bipadminupwd, impersonatingUser);
////System.out.println("Session Id got from BIP Server : " + sessionId);
//
////System.out.println("reportsListParamsArray .. " + reportsListLength);
//      for (int i=0; i < reportsListLength; i++)
//      {
//        reportsListParamsArray[i] = String.valueOf( java.lang.reflect.Array.get(repListParams, i) );
//        reportParamNamesListArray[i] = String.valueOf( java.lang.reflect.Array.get(reportParamNames, i) );
//        reportParamValuesListArray[i] = String.valueOf( java.lang.reflect.Array.get(reportParamValues, i) );
//
////System.out.println("\t" + reportsListParamsArray[i]);
//
//        //  TODO : Prepare Parameters HashMap
//        HashMap<String,String> reportParams = new HashMap<String,String>();
//
//        reportParamNamesCSV = reportParamNamesListArray[i];
//        reportParamValuesStr = reportParamValuesListArray[i];
//
////System.out.println("reportParamNamesCSV : " + reportParamNamesCSV + ", reportParamValuesStr : " + reportParamValuesStr);
//        if(reportParamNamesCSV != null && !"".equals(reportParamNamesCSV) && !"".equals(reportParamValuesStr))
//        {
////System.out.println("parameters are not null.");
//          reportParamNamesArray = (String[])reportParamNamesCSV.split(",");
//          reportParamValuesArray = (String[])reportParamValuesStr.split(",");
//
////System.out.println("creating parameters for report call .. ");
//          for(int p = 0; p < reportParamNamesArray.length; p++)
//          {
////System.out.println("p : " + p + ", param_name : " + reportParamNamesArray[p] + ", value : " + reportParamValuesArray[p]);
//            reportParams.put(reportParamNamesArray[p], reportParamValuesArray[p]);
//          }
//        }
//        else
//        {
//          //System.out.println("no parameters provided");
//        }
//
//        outputFilePaths[i] = BIPServiceHelper.generateBIPReport(
//                                                                reportService,
//                                                                sessionId,
//                                                                reportsListParamsArray[i],  //  Report Path
//                                                                outputFormat,
//                                                                finalOutputFilePath + "_" + i +"."+outputFormat,
////                                                                finalOutputFilePath,
//                                                                reportParams
//                                                               );
//        File outputFile =  new File(outputFilePaths[i]);
//        outputFile.getParentFile().mkdirs();
////        inputFilesToMerge[i] = outputFile;
//        pdfMerger.addSource(outputFile);
//      }
//
//      if(reportsListLength > 1)
//      {
//System.out.println("Three are more than one Reports, so Merging ... : " + finalOutputFilePath);
//        File finalMergedOutputFile = new File(finalOutputFilePath);
//        finalMergedOutputFile.getParentFile().mkdirs();
///*
//        PDFDocMerger docMerger = new PDFDocMerger(inputFilesToMerge, finalMergedOutputFile);
//        Properties prop = new Properties();
//        docMerger.setConfig(prop);
//        docMerger.process();
//*/
//        pdfMerger.setDestinationFileName(finalOutputFilePath);
//        pdfMerger.mergeDocuments(null);
//
//        Thread.sleep(1000);
//System.out.println("Merged File Size : " + finalMergedOutputFile.length());
//
//        finalOutputFilePath = finalMergedOutputFile.getAbsolutePath();
// 	//Deleting individual files
//        for (int i = 0; i < reportsListLength; i++) {
//            File file =  new File(outputFilePaths[i]);
//            boolean delResult = file.delete();
//            if (!delResult) {
//                System.out.println("Failed to delete " + outputFilePaths[i]);
//            }
//        }
//      }
//      else
//      {
//System.out.println("Three os only one Report, so NOT Merging ...");
//        finalOutputFilePath = outputFilePaths[0];
//      }
//System.out.println("Returning finalMergedOutputFile : " + finalOutputFilePath);
//       return finalOutputFilePath;
//    }
//    catch(Exception e)
//    {
//      e.printStackTrace();
//      return "Exception Occured in BIPServiceHelper.runReportsAndMerge() : " + e.getMessage();
//    }
//  }
//
//  /**
//    Method to just merge already generated Reports using the runReportsAndMerge() API
//  */
//  public static String mergeReports(java.sql.Array reportsList, String finalOutputFilePath)
//  {
//    try
//    {
//      File finalMergedOutputFile = new File(finalOutputFilePath);
//      finalMergedOutputFile.getParentFile().mkdirs();
//      Object repListParams = reportsList.getArray();
//      int reportsListLength = java.lang.reflect.Array.getLength( repListParams );
////System.out.println("reportsListLength : " + reportsListLength);
//
//      String[] inputFilePaths = new String[reportsListLength];
//      File[] inputFilesToMerge = new File[reportsListLength];
//      PDFMergerUtility pdfMerger = new PDFMergerUtility();
//
//
//        for (int i=0; i < reportsListLength; i++)
//        {
////          inputFilesToMerge[i] = new File(String.valueOf( java.lang.reflect.Array.get(repListParams, i) ));
//          pdfMerger.addSource(new File(String.valueOf( java.lang.reflect.Array.get(repListParams, i) )));
////System.out.println("\t" + inputFilesToMerge[i]);
//        }
///*
//        PDFDocMerger docMerger = new PDFDocMerger(inputFilesToMerge, finalMergedOutputFile);
//        Properties prop = new Properties();
//        docMerger.setConfig(prop);
//        docMerger.process();
//*/
//        pdfMerger.setDestinationFileName(finalOutputFilePath);
//        pdfMerger.mergeDocuments(null);
//        Thread.sleep(1000);
////System.out.println("Merged File Size : " + finalMergedOutputFile.length());
//
//        finalOutputFilePath = finalMergedOutputFile.getAbsolutePath();
//
//System.out.println("Returning Absolute Path Name for Merged File : " + finalOutputFilePath);
//      return finalOutputFilePath;
//    }
//    catch(Exception e)
//    {
//      e.printStackTrace();
//      return "ERRORS: " + e.getMessage();
//    }
//  }
//
//  /**
//   * Method to call the BI Publisher Service to generate one Report Output
//   *
//   * @param ReportService reportService
//   * @param String sessionId
//   * @param String reportPath
//   * @param String outputFormat
//   * @param String outputFilePath
//   * @param HashMap reportParams
//   * @return String Saved Report Path Name
//   */
//  public static String generateBIPReport(ReportService reportService, String sessionId, String reportPath, String outputFormat, String outputFilePath, HashMap reportParams)
//  {
//    String rpName = "";
//    Object rpVal = "";
//    List<byte[]> reportList = new ArrayList<byte[]>(1);
//
//    try
//    {
//      if (outputFormat == null || "".equals(outputFormat))
//        outputFormat = "pdf";
//
//      ReportRequest repReq = new ReportRequest();
//
//      repReq.setByPassCache(true);
//      repReq.setFlattenXML(false);
//      repReq.setSizeOfDataChunkDownload(-1);
//      repReq.setReportAbsolutePath(reportPath);
//      repReq.setAttributeFormat(outputFormat);
//
//      ParamNameValues paramNameValues = new ParamNameValues();
//      ArrayOfParamNameValue arrayOfParamNameValue = new ArrayOfParamNameValue();
//      ParamNameValue paramNameValue = null;
//      ArrayOfString arrayOfString = null;
//      int index = 0;
//
//      Iterator iter = reportParams.entrySet().iterator();
//      while (iter.hasNext())
//      {
//        Map.Entry pair = (Map.Entry) iter.next();
//        rpName = (String) pair.getKey();
//        rpVal = pair.getValue(); //  Object
//
//        paramNameValue = new ParamNameValue();
//        arrayOfString = new ArrayOfString();
//        if (rpName != null && !"".equals(rpName))
//        {
//          paramNameValue.setName(rpName);
//          if (rpVal != null && !"".equals(rpVal))
//                arrayOfString.getItem().add(rpVal.toString());
//        }
//        paramNameValue.setValues(arrayOfString);
//        arrayOfParamNameValue.getItem().add(index, paramNameValue);
//        index = index + 1;
//      }
//
//      paramNameValues.setListOfParamNameValues(arrayOfParamNameValue);
//
//      if (paramNameValues != null)
//        repReq.setParameterNameValues(paramNameValues);
//
////System.out.println("Calling Report Web Service ...");
//      ReportResponse repRes = reportService.runReportInSession(repReq, sessionId);
////System.out.println("Report Generated Successfully ...");
//
//      byte[] bytes = repRes.getReportBytes();
////System.out.println("Bytes Size : " + bytes.length);
//
//      reportList.add(bytes);
//System.out.println("Returning bytes... to " + outputFilePath);
//
//      if(bytes != null)
//      {
//System.out.println("runReportInSession Returned 123: " + bytes.length);
//
//        if(bytes.length > 0)
//        {
//        System.out.println("outputFilePath  : " + outputFilePath);
//          if(outputFilePath != null && !"".equals(outputFilePath))
//          {
//            /*  
//              create directory
//             */ 
//            System.out.println("outputFilePath  : " + outputFilePath);
//            String filePath = outputFilePath.substring(0,outputFilePath.lastIndexOf("/") );
//              System.out.println("filePath  : " + filePath);
//              System.out.println("outputFilePath.lastIndexOf(\"/\")  : " + outputFilePath.lastIndexOf("/"));
//            File outFilePath = new File(filePath);
//              System.out.println("344  : " );
//              outFilePath.mkdirs();
//              System.out.println("346  : " );
//            File outputFile = new File(outputFilePath);
//              System.out.println("348  : " );
//            FileOutputStream fos = new FileOutputStream(outputFile);
//              System.out.println("350  : " );
//            fos.write(bytes);
//              System.out.println("352  : " );
//            fos.flush();
//              System.out.println("354  : " );
//            fos.close();
//              System.out.println("356  : " );
//          }
//        }
//      }
//    }
//    catch (FileNotFoundException fnfe)
//    {
//System.out.println("Exception thrown: FileNotFoundException!");
//          fnfe.printStackTrace();
//    }
//    catch (IOException ioe)
//    {
//System.out.println("Exception thrown: IOException!");
//          ioe.printStackTrace();
//    }
//    catch (InvalidParametersException_Exception e)
//    {
//System.out.println("Exception thrown: InvalidParameters!");
//          e.printStackTrace();
//    }
//    catch (AccessDeniedException_Exception e)
//    {
//System.out.println("Exception thrown: AccessDenied!");
//          e.printStackTrace();
//    }
//    catch (OperationFailedException_Exception e)
//    {
//System.out.println("Exception thrown: OperationFailed!");
//          e.printStackTrace();
//    }
//    catch(Exception e)
//    {
//      e.printStackTrace();
//      return "Exception In BIPServiceHelper.generateBIPReport() : " + e.getMessage();
//    }
//    return outputFilePath;
//  }
//
//};
