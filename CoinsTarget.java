package code.leetcode.easy;

    import java.io.*;
    import java.util.*;

public class CoinsTarget {
    /*
    *  Target Practice 02 - Dynamic Programming - Tabulation/Memoization
    *
    *          Given an array of coins and a target total, return how many
    *          unique ways there are to use the coins to make up that total.
    *
    *  Input:  coins {Integer Array}, total {Integer}
    *  Output: {Integer}
    *
    *
    * Example:
    *  Input:  [1,2,3], 4
    *  Output: 4
    *
    *          1+1+1+1
    *          1+3
    *          1+1+2
    *          2+2
    *
    *
    *  Input:  [2,5,3,6], 10
    *  Output: 5
    *
    *          2+3+5
    *          5+5
    *          2+3+2+3
    *          2+2+6
    *          2+2+2+2+2
    *
    *    Note: You have an unlimited number of each coin type. All coins in the
    *          coin array will be unique
    *          Order does not matter. Ex: One penny and one nickel to create six
    *          cents is equivalent to one nickel and one penny
    ******************************************************************
    *                             recursive
    *                                      4
    *                                   /  |   \
    *                                  3   2    1
    *                                / | \ 
    *                               2  1  0
    ********************************************************
    *base case:negative values return 0
    * 0 return 1;
    * ******************************************
    * psuedo code
    * ******************************************
    * function recurCoinTarget(arrayInt, target){
    *  results=0;
    *  function recursiveCoinTarget(depth, target,arrayInt,sum){
    *  if(sum<0){
    *  return 0;
    *  }else if(sum==0){
    *  return 1;
    *  }
    *  for(int j: arrayInt)
    *  recursive(depth+1,target,arrayInt, sum-arrayInt[depth]);
    *  
    *  }
    * results = recursive(0,4,[1,2,3], 4);
    * 
    * return results;
    * }
    *
    *
    *
    *
    *
    *
    *
    *
    */

  



       // Time Complexity:
       // Auxiliary Space Complexity:

       public static int coinSum(int[] coins, int total) {
         //YOUR WORK HERE
        


         return recurse(coins,total);
       }
       
    public static void main(String[] args) {
      //YOUR WORK HERE
     


        System.out.println(recurse(new int[]{1,2,3},4));
    }
       
       public static int recurse( int[] coins, int sum){
           
           if(sum==0){
               System.out.println("a");
               return 1;
           }
           if(sum<0){
               return 0;
           }
           for(int i: coins)
           return +recurse(coins, sum-i);
           
           return 0;
           
       }

}
