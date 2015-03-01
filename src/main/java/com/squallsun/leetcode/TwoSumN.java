package com.squallsun.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumN {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i =0 ;i < numbers.length; i++) {
            int calcValue = numbers[i];
            int needValue = target - calcValue;
            Integer needValueIndex = result.get(needValue);
            if(needValueIndex != null) {
                if(i <= needValueIndex) {
                    return new int[] {i+1, needValueIndex+1};
                } else {
                    return new int[] {needValueIndex+1, i+1};
                }
            } else {
                result.put(calcValue, i);
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int [] a ={0,4,3,0};
        System.out.println(Arrays.toString(twoSum(a, 0)));
    }
}
