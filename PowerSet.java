import java.util.*;
import java.util.ArrayList;


class Powerset {

  public static List<String> compute(String str) {
    // YOUR WORK HERE
 
 
    /*
     *  Target Practice 01 - Recursion
     *
     *  Problem 1:  Powerset - Helper Method Recursion
     *
     *  Prompt:   Given a set S, return the powerset P(S), which is
     *            a set of all subsets of S.
     *
     *  Input:    {String}
     *  Output:   {Array}
     *
     *  Example:  S = "abc", P(S) = ['', 'a', 'b','c','ab','ac','bc','abc']
     *
     *  Notes:     The input string will not contain duplicate characters
     *            The letters in the subset string must be in the same order
     *            as the original input.
                                  ''                          
                             /           \ 
       *             a      ''            a
       *                   /  \          /  \
       *             B    ''   b        a     ab
       *                 /  \ /  \     / \   /   \
       *            C   ''  c b   bc  a   ac ab   abc 
       * ************************************************************************************
       * pseudo code
       * function("abc")
       *    recurse(0,'abc',stringArray)
       *    return stringArray
       * 
       * recurse(depth,inStr,string,stringArray)
       *  
       *  stringArray.add(string);
       *  
       *  recurse(depth+1,inStr,string+inStr.substr(depth),stringArray); 
       *  recurse(depth+1,inStr,string,stringArray);
       * 
       *  if(depth+1 == inStr.length+1)
       *   return;
       *  
       * 
       * 
       * 
       * 
       * 
       * 
       */
      
   ArrayList<String> results= new ArrayList<String>();
    //recurse(0,"abc","",results);
      
    for(String str1: results)
        System.out.println(str1);
    return new ArrayList<String>();
  }
  
  public static void main(String[] args){
      ArrayList<String> results= new ArrayList<String>();
      String str=new String("");
      
       recurse(0,"abc","",str,results);
         
      System.out.println(str);
      // for(String str1: results)
        //   System.out.println(str1);
  }
  
  
  
  public static void recurse(int depth, String inStr, String str, String str1,ArrayList<String> results ){
      results.add(str);
      str1 =str1+str;
      if(depth == inStr.length() ){
          //System.out.println(depth);
          return;
      }
      
     
      
      recurse(depth+1,inStr,str+inStr.substring(depth,depth+1),str1,results); 
      recurse(depth+1,inStr,str,str1,results); 
      
  }

}