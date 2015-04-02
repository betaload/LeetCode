package com.squallsun.leetcode;

import java.util.ArrayList;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {


            k--;
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for(int i =0; i<n;i++) {
                nums.add(i+1);
            }

            String res = "";


            int factorial = calcfactorial(n-1);

            int round = n-1;
            while(round>=0)
            {
                int index = k/factorial;

                res = res + (nums.get(index));
                nums.remove(index);

                k = k % factorial;
                if(round>0)  {
                    factorial = factorial / round;
                }
                round--;
            }
            return res;
        }

    private static int calcfactorial (int k) {
        int result = 1;
        if (k == 0 || k == 1) {
            return result;

        }
        while(k>1) {
            result = k*result;
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        getPermutation(2, 2);
    }
}
