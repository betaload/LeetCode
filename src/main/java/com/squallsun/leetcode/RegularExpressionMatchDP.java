package com.squallsun.leetcode;


public class RegularExpressionMatchDP {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        

        if (s == null || p == null) {
            return false;
        }

        boolean[][] result = new boolean[m+1][n+1];
        result[0][0] = true;

        for (int i = 1; i <= m; i++) {
            result[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            result[0][j] = (p.charAt(j-1) == '*') && (j-2 >= 0) && result[0][j-2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = ((result[i-1][j-1]) &&  ((s.charAt(i-1) == p.charAt(j-1)) || '.' == p.charAt(j-1)))
                        ||  ((result[i-1][j] || result[i][j-1]) && (p.charAt(j-1) == '*') && ((s.charAt(i-1) == p.charAt(j-2)) || '.' == p.charAt(j-2)))
                        ||  ((p.charAt(j-1) == '*') && (j-2 >= 0) && result[i][j-2]);
            }
        }

        return result[m][n];
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aaaa", "a*ca*"));
    }
}
