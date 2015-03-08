package com.squallsun.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) {
            return 0;
        }
        if(num.length == 3) {
            return num[0]+num[1]+num[2];
        }
        Arrays.sort(num);
        int len = num.length;
        int closest = num[0]+num[1]+num[2];
        for(int i = 0; i< len; i++) {

            if(i> 0 &&num[i] == num[i-1]) {
                continue;
            }
            int needValue4Target = target - num[i];
            int tmp = twoSum(closest, num, needValue4Target, i, len);
            if(Math.abs(tmp - target) < Math.abs(closest - target)) {
                closest = tmp ;
            }
        }

        return closest;
    }


    private static int twoSum(int closest, int[] numbers, int target, int start, int end) {
        int value = closest;
        int i = start+1;
        while (i < end-1 ) {

            if (i > start && numbers[i] == numbers[i-1]) {
                i++;
                continue;
            }


            int tmp = numbers[i] + numbers[i+1];
            if (Math.abs(tmp+ numbers[start] - target) < Math.abs(value - target)) {
                value = tmp +  numbers[start];
            }

            i++;


        }
        return value;
    }


    public static void main(String[] args) {
        int[] a = {1,1,1,0};

        System.out.println(threeSumClosest(a, -100));
    }
}
