package com.squallsun.leetcode;

public class LongestPalindromicSubstringN2N2 {

    public static String longestPalSubString(String s) {
        int totalLen = s.length();
        if (totalLen == 0) {
            return "";
        }

        boolean[][] isPal = new boolean[totalLen][totalLen];
        int maxlength = 1;
        int indexBegin = 0;

        for (int i = 0; i < totalLen; i++) {
            isPal[i][i] = true;
        }

        for (int i = 0; i < totalLen - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPal[i][i + 1] = true;
                indexBegin = i;
                maxlength = 2;
            }
        }

        for (int len = 3; len <= totalLen; len++) {
            for (int i = 0; i < totalLen - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1]) {
                    isPal[i][j] = true;
                    indexBegin = i;
                    maxlength = len;
                }
            }
        }

        return s.substring(indexBegin, indexBegin + maxlength);
    }

    public static void main(String[] args) {
        String s1 = "abacdfgdcaba12321";
        String s2 = "abacdfgadfghjkllkjhdcaba12321445";
        String s3 = "abacdfgertyuiuytreaba12321445";

        System.out.println(longestPalSubString(s1));
        System.out.println(longestPalSubString(s2));
        System.out.println(longestPalSubString(s3));
    }
}
