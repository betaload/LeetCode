package com.squallsun.leetcode;

import java.util.Arrays;

public class LengthOfLongestSubStringNoRepartCharFasterON {

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int [] chars = new int[500];
        Arrays.fill(chars, -1);
        int start = 0;
        int end = 1;
        int max = 1;

        chars[s.charAt(0)] = 0;

        while(end < length) {
            int indexFound = chars[s.charAt(end)];
            if(indexFound >= start) {
                start = indexFound + 1;
            }


            int total = end - start + 1;
            if(max < total) {
                max = total;
            }

            chars[s.charAt(end)] = end;
            end++;
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("mnb)ba123dfghx3"));
        System.out.println(lengthOfLongestSubstring("cabix1b"));
    }
}
