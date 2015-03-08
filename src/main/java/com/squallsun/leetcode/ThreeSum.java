package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static List<int[]> twoSum(int[] numbers, int target) {
        Map<Integer, Integer> result = new HashMap<>();

        List<int[]> targetList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int calcValue = numbers[i];
            int needValue = target - calcValue;
            Integer needValueIndex = result.get(needValue);

            if (needValueIndex != null) {
                int[] tmp = new int[]{i + 1, needValueIndex + 1};
                targetList.add(tmp);
            } else {
                result.put(calcValue, i);
                continue;
            }
            return targetList;
        }
        return null;
    }

    public static List<int[]> threeSum(int[] numbers, int target) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            List<int[]> tmp = twoSum(numbers, target - numbers[i]);
            if(tmp != null) {
                for(int[] a: tmp) {
                    int[] b = Arrays.copyOf(a, a.length+1);
                    b[a.length] = numbers[i];
                    Arrays.sort(b);
                    res.add(b);
                }
            }
            numbers = Arrays.copyOfRange(numbers, 1, numbers.length);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {0,0,0};
        threeSum(a, 0);
    }
}
