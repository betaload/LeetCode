package com.squallsun.leetcode;

public class RegularExpressionMatch {

    public static boolean isMatch(String string, String pattern) {
        if (string == null) {
            return pattern == null;
        }
        if (pattern == null) {
            return string == null;
        }
        if (string.length() == 0) {
            return pattern.length() == 0;
        }

        if (pattern.length() == 0) {
            return string.length() == 0;
        }

        if (pattern.length() == 1) {
            return string.equals(pattern) || (string.length() ==1 && pattern.equals("."));
        }

        if (pattern.charAt(1) != '*') {
            if ((pattern.charAt(0) == string.charAt(0) || pattern.charAt(0) == '.')) {
                return  isMatch(string.substring(1), pattern.substring(1));
            }
            return false;
        } else {
            while (string.length() > 0
                    && (pattern.charAt(0) == string.charAt(0) || pattern.charAt(0) == '.')) {
                if (isMatch(string, pattern.substring(2))) {
                    return true;
                }
                string = string.substring(1);
            }
            return isMatch(string, pattern.substring(2));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaaa", "a*ca*"));
    }
}
