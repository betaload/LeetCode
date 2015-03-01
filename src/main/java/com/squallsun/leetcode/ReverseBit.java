package com.squallsun.leetcode;

/**
 * Created by SJQ on 2015/3/1.
 */
public class ReverseBit {

    public static void reverse(int x) {

        int size = Integer.highestOneBit(x) * 2 - 1;
        for (int i = 0; i< size/2; i++) {
            int j = size - i - 1;

            int low = (x>>i) & 1;
            int high = (x>>j) & 1;

            if((low ^ high) == 1) {
                x = x ^ ((1<<i) | (1 <<j));
            }

        }

        System.out.println(x);

    }

    public static void main(String[] args) {

        reverse(1);

        System.out.println(Integer.reverseBytes(1));

    }
}
