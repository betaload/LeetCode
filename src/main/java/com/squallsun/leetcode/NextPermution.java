package com.squallsun.leetcode;

import java.util.Arrays;

public class NextPermution {
    public static void nextPermutation(int[] num) {

        if(num.length <= 1) {
            return;
        }

        int i =  num.length-1;
        boolean change = false;
        boolean des = false;
        for(; i>0; i--) {
            if(num[i-1] < num[i]) {
                break;
            }
        }

        if (i == 0) {
            Arrays.sort(num);
            return;
        }

        int j = num.length-1;
        for(; j>i-1; j--){
            if( num[ j ] > num[ i - 1 ] )
                break;
        }

        int tmp = num[j];
        num[j] = num[i-1];
        num[i-1] = tmp;
        Arrays.sort(num, i, num.length);

    }

    public static void main(String[] args) {
        int[] a = {1,3,2};
        nextPermutation(a);
    }
}