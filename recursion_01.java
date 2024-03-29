package code.leetcode.easy;

import java.util.*;
import java.util.ArrayList;



public class recursion_01 {
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
     */

}
    class Powerset {

      public static List<String> compute(String str) {
         // System.out.println(str);
        ArrayList<String> result= new ArrayList<String>();
          helper(str,result,"",0);
          return result;
      }
      
      public static void helper(String str,ArrayList<String> result,String buffer, int counter){
          //System.out.println(counter);
          if(counter >= str.length()+1)
            return;
          else if(counter == str.length()){
           result.add(buffer);
              
              return;
          }
          
          helper(str,result,buffer,counter+1);
          helper(str,result,buffer +str.charAt(counter) ,counter+1);
          
      }
    
    
    }



    /*
    *  Problem: Lattice Paths - Pure Recursion
    *
    *  Prompt:  Count the number of unique paths to travel from the top left
    *           corder to the bottom right corner of a lattice of M x N squares.
    *
    *           When moving through the lattice, one can only travel to the adjacent
    *           corner on the right or down.
    *
    *  Input:   m {Integer} - rows of squares
    *  Input:   n {Integer} - column of squares
    *  Output:  {Integer}
    *
    *  Example: input: (2, 3)
    *
    *           (2 x 3 lattice of squares)
    *            __ __ __
    *           |__|__|__|
    *           |__|__|__|
    *
    *           output: 10 (number of unique paths from top left corner to bottom right)
    *
    *  Resource: https://projecteuler.net/problem=15
    *
    */

    // Time Complexity:
    // Auxiliary Space Complexity:
    class LatticePaths {
      public static int compute(int m, int n) {
        // YOUR WORK HERE
          
          return  helperRecursion(m, n, new int[]{0,0});
          
        //return -1;
      }
      public static int helperRecursion(int m,int n , int[] arr){
          
          //base case
          // out of bound case
          if((arr[0]>m) || (arr[1]>n))
            return 0;
          //sucess case
          if((arr[0]==m) || (arr[1]==n))
          return 1;
          
          return helperRecursion(m, n, new int[]{arr[0]+1,arr[1]}) + helperRecursion(m, n, new int[]{arr[0],arr[1]+1});
          
      }
  
    }






    ////////////////////////////////////////////////////////////
    ///////////////  DO NOT TOUCH TEST BELOW!!!  ///////////////
    ////////////////////////////////////////////////////////////

    // use the Main class to run the test cases
    class Main {

      private int[] testCount;

      // an interface to perform tests
      public interface Test {
          public boolean execute();
      }

      public static void main(String[] args) {
        // instantiate the testing of each module by resetting count and printing title of module
        int[] testCount = {0, 0};
        System.out.println("Power Set Tests");

        // tests are in the form as shown
        assertTest(testCount, "should work on example input", new Test() {
          public boolean execute() {

            Powerset powerSet = new Powerset();
            List<String> result = powerSet.compute("abc");

            List<String> answer = Arrays.asList("", "c", "b", "bc", "a", "ac", "ab", "abc");

            Collections.sort(result);
            Collections.sort(answer);

            return result.equals(answer);
          }
        });

        assertTest(testCount, "should work on empty input", new Test() {
          public boolean execute() {

            Powerset powerSet = new Powerset();
            List<String> result = powerSet.compute("");

            List<String> answer = Arrays.asList("");

            Collections.sort(result);
            Collections.sort(answer);

            return result.equals(answer);
          }
        });

        assertTest(testCount, "should work on two-letter input", new Test() {
          public boolean execute() {

            Powerset powerSet = new Powerset();
            List<String> result = powerSet.compute("ab");

            List<String> answer = Arrays.asList("","a","b","ab");

            Collections.sort(result);
            Collections.sort(answer);

            return result.equals(answer);
          }
        });

        assertTest(testCount, "should work on longer input", new Test() {
          public boolean execute() {

            Powerset powerSet = new Powerset();
            List<String> result = powerSet.compute("abcdefg");

            List<String> answer = Arrays.asList("","g","f","fg","e","eg","ef","efg","d",
                    "dg","df","dfg","de","deg","def","defg","c","cg","cf","cfg","ce","ceg",
                    "cef","cefg","cd","cdg","cdf","cdfg","cde","cdeg","cdef","cdefg","b","bg",
                    "bf","bfg","be","beg","bef","befg","bd","bdg","bdf","bdfg","bde","bdeg",
                    "bdef","bdefg","bc","bcg","bcf","bcfg","bce","bceg","bcef","bcefg","bcd",
                    "bcdg","bcdf","bcdfg","bcde","bcdeg","bcdef","bcdefg","a","ag","af","afg",
                    "ae","aeg","aef","aefg","ad","adg","adf","adfg","ade","adeg","adef",
                    "adefg","ac","acg","acf","acfg","ace","aceg","acef","acefg","acd","acdg",
                    "acdf","acdfg","acde","acdeg","acdef","acdefg","ab","abg","abf","abfg",
                    "abe","abeg","abef","abefg","abd","abdg","abdf","abdfg","abde","abdeg",
                    "abdef","abdefg","abc","abcg","abcf","abcfg","abce","abceg","abcef",
                    "abcefg","abcd","abcdg","abcdf","abcdfg","abcde","abcdeg","abcdef","abcdefg");

            Collections.sort(result);
            Collections.sort(answer);

            return result.equals(answer);
          }
        });

        // print the result of tests passed for a module
        System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


        // instantiate the testing of each module by resetting count and printing title of module
        testCount[0] = 0;
        testCount[1] = 0;

        System.out.println("Lattice Paths Tests");

        // tests are in the form as shown
        assertTest(testCount, "should work on example case", new Test() {
          public boolean execute() {
            LatticePaths example = new LatticePaths();
            return example.compute(2, 3) == 10;
          }
        });

        assertTest(testCount, "should return 1 for 0 x 0 lattice", new Test() {
          public boolean execute() {
            LatticePaths example = new LatticePaths();
            return example.compute(0, 0) == 1;
          }
        });

        assertTest(testCount, "should return 2496144 for 13 x 11 lattice", new Test() {
          public boolean execute() {
            LatticePaths example = new LatticePaths();
            return example.compute(13, 11) == 2496144;
          }
        });


        System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");
      }

      // do not edit below, this is to wrap the test and check for exceptions
      private static void assertTest(int[] count, String name, Test test) {
        String pass = "false";
        count[1]++;

        try {
          if (test.execute()) {
            pass = " true";
            count[0]++;
          }
        } catch(Exception e) {}
        String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
        System.out.println(result);
      }

}
