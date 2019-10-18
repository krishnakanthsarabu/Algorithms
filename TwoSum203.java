package code.leetcode.easy;

import java.util.Arrays;
import java.util.*;
import java.util.Set;

public class TwoSum203 {
   
    public static void main(String[] args){

        System.out.println(Arrays.toString(arrayTwoSum(new int[]{1,2,3,-4,5},-3)));
        
    }
    
    public static int[] arrayTwoSum(int[] input,int target){
        Hashtable<Integer,Integer> diference = new Hashtable<Integer,Integer>();
        
        for (int i =0;i<input.length; i++){
            if(diference.containsKey(input[i]))
                return new int[]{diference.get(input[i]),i};
            else
                diference.put(target-input[i],i);
        }
        return new int[]{-1,-1};
    }
    
    public static int[] arrayTwoSumGenaral(int[] input,int target){
        
        for (int i =0;i<input.length; i++){
            for (int j=0;j<input.length;j++){
                if(i != j){
                    if(input[i] + input[j] == target ){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return new int[]{-1,-1};
    }
   
}
