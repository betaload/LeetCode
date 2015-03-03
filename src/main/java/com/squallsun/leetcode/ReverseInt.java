package com.squallsun.leetcode;

public class ReverseInt {
    public static void reverse(int x) {

        int result=0;
        while(x!=0) {
            result = result * 10;
            int tmp = x % 10;
            result = result + tmp;
            x = x/10;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        reverse(12345);

    }
}
