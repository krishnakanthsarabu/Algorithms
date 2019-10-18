package code.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;

public class CapitalComputations203 {
 /*
  * 
  * 
  * 231 - Capital Permutations
Given a string str of lowercase alphabetical characters, return the set of all permutations of those characters in upper AND lowercase.

Advanced
Solve the same problem, except now you may have number characters in your string (which don't have a lowercase or uppercase, but should still be included in your result) and capital letters, that need to be lowercased.

Input: str (String)
Output: [Str] (Array of Strings)
Example
Input: "abc"
Output: ["ABC", "ABc", "AbC", "aBC", "Abc", "aBc", "abC", "abc"]


Advanced:

Input: "A1d3"
Output: ["A1D3", "a1D3", "A1d3", "a1d3"]
Constraints
Time Complexity: O(2^N)
Space Complexity: O(2^N)
The order of the strings in the final result does not matter.

In the basic solution, all the input characters will be lowercase letters.

In the advanced solution, the input characters can be uppercase letters and numbers too.
  * 
  * **********************************************************************
  *                               ""
  *                              /   \
  *        A                    a     A
  *                            /  \  /  \
  *        1                  a1  a1 A1  A1
  * 
  * 
  * base case
  *  depth ==  length
  *  
  *  
  * *************************************************************************
  * psuedo code
  *  function(string)
  *  
  *  StringArray
  *  recurse(inStr, str,depth,stringArray)
  *        if str.length=depth
  *          add str to stringArray
  *          return;
  *        
  *        recurse(instr,str+instr.substring(depth).lowercase,depth+1,stringArray)
  *        if(instr.substring(depth).uppercase != instr.substring(depth).lowercase))
  *        recurse(instr,str+instr.substring(depth).uppercase,depth+1,stringArray)
  *   
  *   recurse("A1d3","",0,StringArray);
  *   return StringArray
  *   
  * 
  * 
  */

    public static void main(String[] args) {
        HashSet<String> results= new HashSet<String>();
        recurse("A1d3","",0,results);
        
        for(String str1: results )
         System.out.println(str1);
      
    }
    
    public static void recurse(String inStr,String str,int depth,HashSet<String> results){
        
        if (depth == inStr.length()) {
            results.add(str);
            return;
        }
       
            recurse(inStr,str+inStr.substring(depth,depth+1).toLowerCase(),depth+1,results);
            if(inStr.substring(depth,depth+1).toUpperCase()!= inStr.substring(depth,depth+1).toLowerCase())
             recurse(inStr,str+inStr.substring(depth,depth+1).toUpperCase(),depth+1,results);
        
    }
    
    
    
}






