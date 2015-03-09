package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] num) {
        return threeSum(num, 0);
    }

    public static List<List<Integer>> twoSum(int[] numbers, int target, int addedValue, int start, int end) {

        List<List<Integer>> resOf2 = new ArrayList<>();
        for (int i = start, j = end-1;i < j; ) {

            if (i > start && numbers[i] == numbers[i-1]) {
                i++;
                continue;
            }

            if (j < end-1 && numbers[j] == numbers[j+1]) {
                j--;
                continue;
            }

            if(numbers[i] + numbers[j] == target) {
                List<Integer> node = new ArrayList<>();
                node.add(addedValue);
                node.add(numbers[i]);
                node.add(numbers[j]);
                resOf2.add(node);
                i++; j--;
            } else if(numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }


        }
        return resOf2;
    }

    public static List<List<Integer>> threeSum(int[] numbers, int target1) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        int len = numbers.length;
        for(int i = 0; i< len; i++) {

            if(i> 0 &&numbers[i] == numbers[i-1]) {
                continue;
            }
            int needValue4Target = target1 - numbers[i];
            List<List<Integer>> tmp = twoSum(numbers, needValue4Target, numbers[i], i+1, len);
            if (tmp.size()> 0) {
                result.addAll(tmp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ab = threeSum(a);
        for (List<Integer> i : ab) {
            for (Integer i2 : i) {
                System.out.print(i2 + " ");
            }
            System.out.println();
        }
    }
}
