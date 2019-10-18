import java.util.HashMap;


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
*
*/


class Problems1 {

   // Time Complexity:
   // Auxiliary Space Complexity:

   public static int coinSum(int[] coins, int total) {
     //YOUR WORK HERE
   int result=0;
   if(total == 0)
       return 1;
   if(total <0)
    return 0;
   
   for(int coin:coins){
       result += coinSum(coins,total-coin) ;
       
       System.out.println(result);
   }
      
      
       
     return result;
   }
   
   
   
}

class Problems {

   // Time Complexity:
   // Auxiliary Space Complexity:

   public static int coinSum(int[] coins, int total) {
     //YOUR WORK HERE
     HashMap<String,Integer> ways= new HashMap<String,Integer>();
     return coinSumHelperMemo( coins, total,  0,ways);
   }
   
   public static int coinSumHelper(int[] coins, int total, int counter){
       int result=0;
       if(total == 0)
           return 1;
       if(total <0)
        return 0;
       
       for(int i=counter;i<coins.length;i++){
           int coin=coins[i];
           result += coinSumHelper(coins,total-coin,i) ;
           
           //System.out.println(result);
       }
          
          
        return result;   
   }
   
   
    public static int coinSumHelperMemo(int[] coins, int total, int counter,HashMap<String,Integer> ways){
        String key= total+"_"+counter;
        if(ways.containsKey(key)){
            return ways.get(key);
        }
        
        if(total == 0)
            return 1;
        if(total <0)
         return 0;
        
        int result=0;
        
        for(int i=counter;i<coins.length;i++){
            int coin=coins[i];
            result += coinSumHelper(coins,total-coin,i) ;
           
            //System.out.println(result);
        }
           ways.put(key, result);
           
         return result;   
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
     System.out.println("Coin Sum Tests");

     // tests are in the form as shown
     assertTest(testCount, "should work for first example case", new Test() {
       public boolean execute() {
         int output = Problems.coinSum(new int[]{1,2,3}, 4);
         return output == 4;
       }
     });

     assertTest(testCount, "should work for second example case", new Test() {
       public boolean execute() {
         int output = Problems.coinSum(new int[]{2,5,3,6}, 10);
         return output == 5;
       }
     });

     assertTest(testCount, "should work for a single coin", new Test() {
       public boolean execute() {
         int output = Problems.coinSum(new int[]{2}, 10);
         return output == 1;
       }
     });

     assertTest(testCount, "should work for a single coin", new Test() {
       public boolean execute() {
         int output = Problems.coinSum(new int[]{2}, 10);
         return output == 1;
       }
     });

     // print the result of tests passed for a module
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

