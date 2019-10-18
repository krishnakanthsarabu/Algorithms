package code.leetcode.easy;


import java.util.*;

public class PlusOne201 {
    public PlusOne201() {
        super();
    }

    public static void main(String[] args) {
        System.out.println("this is first");
        int[] input = new int[] { 9, 8, 9 };
        int[] result = addPlusOne(input);
        System.out.println("this is result" + Arrays.toString(result));

    }

    public static int[] addPlusOne(int[] input) {
        //List<Integer> result= new ArrayList<Integer>();\
        int[] result = new int[input.length];
        int[] result1 = new int[input.length + 1];
        int carry = 1;
        for (int i = input.length - 1; i >= 0; i--) {
            if (carry == 1) {
                if (input[i] == 9) {
                    carry = 1;
                    result[i] = 0;
                    result1[i + 1] = 0;
                } else {
                    result[i] = input[i] + 1;
                    result1[i + 1] = input[i] + 1;
                    carry = 0;
                }
            } else {
                result[i] = input[i];
                result1[i + 1] = input[i];
            }

        }

        //(int[]) result.toArray(new int[]{});
        if (result[0] == 0) {

            result1[0] = 1;
            return result1;
        }

        return result;

    }
}
