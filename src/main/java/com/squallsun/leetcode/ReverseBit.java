package com.squallsun.leetcode;

public class ReverseBit {

    public static void reverse(int x) {

//        int size = Integer.highestOneBit(x) * 2 - 1;
        int size = Integer.toBinaryString(x).length();
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


    public static int sizeOf (int value) {
        value |= (value >> 1);
        value |= (value >> 2);
        value |= (value >> 4);
        value |= (value >> 8);
        value |= (value >> 16);
        return value;
    }

    public static void main(String[] args) {

        reverse(12345);

    }
}
