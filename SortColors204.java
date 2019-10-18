package code.leetcode.easy;

import java.util.Arrays;

public class SortColors204 {
    public static void main(String[] args){

        System.out.println(Arrays.toString(arraySortColors(new int[]{1,2,1,0,0,2,1,0,2,1,0,1})));
        
    }
    
//    Time Complexity: O(N)
//    Auxiliary Space Complexity: O(1)
    public static int[] arraySortColors(int[] input){
        int[] counts= new int[]{0,0,0};
        for(int i :input){
            switch (i){
            case 0: counts[0]++;break;
            case 1: counts[1]++;break;
            case 2: counts[2]++;break;
            }
        }
        
        int[] result= new int[input.length];
        int index=0;
        for (int i=0;i<3;i++){
            for (int j=0;j<counts[i];j++){
                result[index]=i;
                
                index++;
            }
        }
        return result;
    }
    
}
