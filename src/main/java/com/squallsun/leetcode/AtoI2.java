package com.squallsun.leetcode;

public class AtoI2 {
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        int len = str.length();
        int neg = 1;
        int startIndex = 0;
        if(str.charAt(0) == '-') {
            neg = -1;
            startIndex = 1;
        } else if (str.charAt(0) == '+') {
            startIndex = 1;
        }
        int value = 0;
        for(int i = startIndex; i < len; i++) {
            char ch = str.charAt(i);
            if(ch > '9' || ch < '0') {
                return value*neg;
            }
            int tmp = value * 10 + (int) (ch - '0');
            if (tmp * neg > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (neg * tmp < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            value = tmp;

        }
        return value*neg;
    }



}
