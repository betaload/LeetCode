package com.squallsun.leetcode;

public class LengthOfLongestSubStringNoRepartCharON {

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int max = 0;
        int total = 0;
        char[] a = new char[len];
        int start = 0;
        int end = 0;
        while (start < len && end < len) {
            for (end = start; end < len; end++) {
                int already = String.valueOf(a).indexOf(s.charAt(end));
                if (already < 0) {
                    total++;
                    a[end] = s.charAt(end);
                    if (max < total) {
                        max = total;
                    }
                } else {
                    a = new char[len];
                    start = end;
                    total = 1 ;
                }

            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("mnb)ba123dfghx3"));
        System.out.println(lengthOfLongestSubstring("cabix1b"));
    }

}
