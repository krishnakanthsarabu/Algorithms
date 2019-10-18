package code.leetcode.easy;

public class ConsecutiveSubarraySum222 {
   
/*
 * 
 * 
 * # 222 - Consecutive Subarray Sum

Given an array of positive integers and a target value, return true if there is a subarray of consecutive elements that sum up to this target value.

```
Input: Array of integers, target value
Output: Boolean
```

# Example
```
Input: [6,12,1,7,5,2,3], 14      	=>	Output: true (7+5+2)
Input: [8,3,7,9,10,1,13], 50		=>	Output: false
```

# Constraints
```
Time Complexity: O(N)
Auxiliary Space Complexity: O(1)
```

All elements are positive

 * ***********************************************************************
 * 6,12,1,7,5,2,3
 * 
 * r=3
 * l=1
 * sum=14=14
 * target=14
 * *************************************************************************
 * base case
 * sum=target
 * *************************************************************************
 * function conseqArrSum(arrayInt,target){
 * boolean result=false;
 * int sum=0
 * for(r=0;r<arrayInt.length;r++){
 * sum += arrayInt[r];
 * if(sum= target)
 *      return true;
 * else if(sum>target){
 *     while(sum>target){
 *       sum -=arrayInt[left];
 *       left++;
 *     }
 *     
 *     }
 * }
 * 
 * return result;
 * }
 * 
 */
    public static void main(String[] args) {
        
        System.out.println(ConsqSubSum(new int[]{6,12,1,7,5,2,3},14));
    }
    
    public static boolean ConsqSubSum(int[] input,int target){
        int sum=0,left=0;
        for(int r=0;r<input.length;r++){
           
            sum = sum+input[r];
            if(sum==target)
              return true;
            else if(sum>target){
                while(sum>target){
                    sum -= input[left];
                    left++;
                }
                if(sum== target)
                 return true;
                
            }
            
        }
        
        
        return false;
    }
    
}
