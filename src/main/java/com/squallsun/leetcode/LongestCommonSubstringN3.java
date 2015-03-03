package com.squallsun.leetcode;

public class LongestCommonSubstringN3 {

    public static void main(String[] args) {
        String s1 = "abcdefghijk";
        String s2 = "bbdefgabcdhghijklabc";

        int len1 = s1.length();
        int len2 = s2.length();

        String min = len1 < len2 ? s1 : s2;
        String max = len1 < len2 ? s2 : s1;

        for (int j = min.length(); j > 0; j--) {
            for (int i = 0; i < min.length() - j + 1; i++) {
                String tmp = min.substring(i, i+j);
                for (int k = 0; k< max.length() - j; k++) {
                    if(max.substring(k, k+j).equals(tmp)) {
                        System.out.println(tmp);
                        return;
                    }
                }
            }
        }
    }
}
