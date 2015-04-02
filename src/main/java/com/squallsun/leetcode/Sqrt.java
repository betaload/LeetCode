package com.squallsun.leetcode;

public class Sqrt {
    public static int sqrt(int x) {
        if(x < 0) {
            return -1;
        }

        if(x == 0) {
            return 0;
        }

        if(x == 1) {
            return 1;
        }

        int i = 1; int j = x/2 + 1;

        while(i < j) {
            int m = (i+j)/2;
            if(m*m <= x && (m+1) * (m+1) > x) {
                return m;
            }

            if(m*m > x) {
                j = m-1;
                continue;

            }

            else {
                i = m+1;
                continue;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        sqrt(8);
    }
}
