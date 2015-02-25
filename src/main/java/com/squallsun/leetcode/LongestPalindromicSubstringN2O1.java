package com.squallsun.leetcode;


public class LongestPalindromicSubstringN2O1 {

    public static String getPaladinFromIndex (String s, int index1, int index2) {
        int totalLength = s.length();
        for(; index1 >=0 && index2 <=totalLength-1; index1--, index2++){
            if(s.charAt(index1) != s.charAt(index2)) {
                break;
            }
        }

        return s.substring(index1+1, index2-1+1);
    }

    public static String longestPalSubString(String s) {

        int length = s.length();
        if(length == 0) {
            return "";
        }
        String longestPalSubString = s.substring(0,1);

        for(int i = 0; i<length; i++) {

            String res = getPaladinFromIndex(s, i, i);
            if (res.length() > longestPalSubString.length()) {
                longestPalSubString = res;
            }
        }

        for(int i = 0; i<length-1; i++) {
            String res = getPaladinFromIndex(s, i, i+1);
            if (res.length() > longestPalSubString.length()) {
                longestPalSubString = res;
            }
        }

        return longestPalSubString;
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


