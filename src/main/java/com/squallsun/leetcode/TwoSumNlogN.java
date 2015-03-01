package com.squallsun.leetcode;

import java.util.Arrays;

/**
 * Created by SJQ on 2015/3/1.
 */
public class TwoSumNlogN {

    public int[] twoSum(int[] numbers, int target) {

        int[] orig = numbers.clone();
        Arrays.sort(numbers);

        int index1 = 0;
        int index2 = 0;

        int va = 0;
        int vb = 0;
        for(int i = 0, j=numbers.length -1; i < j; ) {
            if(numbers[i] + numbers[j] == target) {
                va = numbers[i];
                vb = numbers[j];
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }



        for(int i = 0; i < orig.length; i++) {
            if (orig[i] == va) {
                index1 = i + 1;
            }
        }
        for(int i = index1+1; i < orig.length; i++) {
            if (orig[i] == vb) {
                index2 = i+1;
            }
        }

        return new int[]{index1, index2};
    }
}
