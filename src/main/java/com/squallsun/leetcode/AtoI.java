package com.squallsun.leetcode;

public class AtoI {
    public static int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        int len = str.length();
        boolean neg = false;
        int startIndex = 0;
        if(str.charAt(0) == '-') {
            neg = true;
            startIndex = 1;
        } else if (str.charAt(0) == '+') {
            startIndex = 1;
        }
        long value = 0;
        for(int i = startIndex; i < len; i++) {
            char ch = str.charAt(i);
            if(ch > '9' || ch < '0') {
                return getValue(value, neg);
            }
            long tmp = value * 10 + (int) (ch - '0');
            if(!neg) {
                if (tmp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    value = tmp;
                }
            } else {
                if (-1 * tmp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else {
                    value = tmp;
                }
            }
        }

        return getValue(value, neg);
    }

    private static int getValue(long value, boolean neg) {
        value = neg? value * (-1) : value;
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)value;

    }

    public static void main(String[] args) {
        System.out.println(atoi("-9223372036854775809"));
    }
}
