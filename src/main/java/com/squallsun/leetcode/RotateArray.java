package com.squallsun.leetcode;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {

        int len = nums.length;

        if(k>=len) {
            return;
        }
        k = k-1;
        int[] newnums = new int[len];

        for(int i = 0; i<k+1; i++) {
            newnums[len-k+i-1] = nums[i];
        }

        for(int i = k+1; i<len; i++) {
            newnums[i-k-1] = nums[i];
        }

//        nums = newnums;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(newnums));
        System.out.println(Arrays.toString(Arrays.copyOf(newnums, len)));
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        rotate(a, 1);
    }
}
