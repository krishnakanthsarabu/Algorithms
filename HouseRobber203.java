package code.leetcode.easy;

public class HouseRobber203 {
  /*
   * 
   * 
   * # 208 - House Robber

A house robber has a map of houses and the amount of gold in each home.  The robber knows that if two adjacent homes are robbed, then the neighborhood security system will sound.  Determine the total amount of gold the robber can get without setting off the alarm.

```
Input: 	 Array of Nonnegative Integers
Output: 	Integer
```

# Example
```
Input: [1, 2, 3]				 =>	Output: 4
Input: [1, 2, 4, 1, 5, 12, 5]	=>	Output: 17

Explanation:
Knowing you can't rob from two adjacent houses
The maximum gold you can steal in each case:

Example 1
1 + 3 = 4

Example 2
1 + 4 + 12 = 17

```


# Constraints

```
Time Complexity: O(N)
Auxiliary Space Complexity: Intermediate O(N), Advanced O(1)
```

# Notes

Think about how you might be able to do this with just two variables instead of an additional array.

# Solution
This can be solved using tabulation (iteratively).

* 1) Instantiate a new ‘max’ array to hold the max gold that can be accumulated up to each house.
* 2) Loop through the input array with, i.
* 3) For each house, the max gold (max[i]) will be the greater of:
  * The previous house’s max
  * The max two houses back + the current house value
* 4) After the loop, return the last value in the max array

```Javascript
let test1 = [1, 2, 3];
let test2 = [1, 2, 4, 1, 5, 12, 5];
   * 
   * 
   * ***************************************************************
   * diagram
   * 1, 2, 4, 1, 5, 12, 5
   *           i
   * 4 max=2<(max(1)+4) 5
   * 1 max=5<(max(2)+1)=3  5
   * 5 max=5<(max(5)+5)=10  10
   *12 max=10<(max(5)+12)=17  17
   * 5 max=17<max(10)+5=15   17 
   * *******************************************************************
   * base case
   * ******************************************************************
   * function robHouse(arrayInt){
   * arrayInt max[arrayInt.length];
   * for(int i=0;i<array.length;i++){
   *  if(i=0)
   *    max[i]=arrayInt[i];
   *  else if(i=1)
   *    max[i]=Math.max(max[i-1],arrayInt[i]);
   *    else
   *    max[i]=Math.max(max[i-1],max[i-2]+arrayInt[i]);
   * 
   * }
   * 
   * return max[arrayInt.length()-1];
   * }
   * 
   * 
   * 
   */

    public static void main(String[] args) {
        
        System.out.println(robHouse(new int[]{1, 2, 3}));
    }
    public static int robHouse(int[] input){
        int[] max=new int[input.length];
        
        for(int i=0;i<input.length;i++){
            if(i==0)
             max[i]=input[i];
            else if(i==1)
             max[i]= Math.max(max[i-1], input[i]);
            else
                max[i]=Math.max(max[i-1],max[i-2]+input[i]);
                
            
        }
        
        return max[input.length-1];
    }
    
    
}
