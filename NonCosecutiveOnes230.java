package code.leetcode.easy;

import java.util.ArrayList;

public class NonCosecutiveOnes230 {
/*
 * Input: n (Integer)
 * Output: [Str] (Array of Strings)
 * 
 * Input: 2
Output: ["00", "01", "10"]

Input: 3
Output: ["000", "001", "010", "100", "101"]
 * 
 * Time Complexity: O(2^N)
 * Auxiliary Space Complexity: O(2^N)
 * 
 *  
 ***************************************************
 *                  0     ""
 *                       /  \
 *                 1    0     1
 *                    /  \  /  \
 *                 2 00  01 10  11X
 *                   
 *Base case
 * depth=input
 * avoid consequitive 1
 * *************************************************************
 * pseudo code
 * 
 * function(input)
 *    stringArray
 *    recurse(input,depth,str,stringArray){
 *       if(input=depth)
 *       stringArray.add(str);
 *       return;
 *     recurse(input,depth+1,str+"0",stringArray);
 *     if(str.substring(depth-1,depth) !=='1')
 *     recurse(input,depth+1,str+"1",stringArray);
 *       }
 *  recurse(input,0,"",stringArray);
 * 
 * ***********************************************************
 *                    
 *                    
 */


    public static void main(String[] args){
        ArrayList<String> results=new ArrayList<String>();
        recurse(3,0,"",results);
        
        for(String str: results)
         System.out.println(str);
    }
    public static void recurse(int input,int depth,String str, ArrayList<String> results){
        if(input == depth){
            results.add(str);
            return;
        }
        
        recurse(input,depth+1,str+"0",results);
        
        //if(str.length()>0){
           // if(!str.substring(depth-1).equals("1")){
              if(!str.endsWith("1"))  
                 recurse(input,depth+1,str+"1",results);
            //}
            //}else
             //   recurse(input,depth+1,str+"1",results);
        
        
    }
        

}
