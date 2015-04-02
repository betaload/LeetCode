package com.squallsun.leetcode;

public class TitleToNumber {
    public int titleToNumber(String s) {

        char[] chars = s.toCharArray();
        int result = 0;
        for(int i = 0; i<chars.length; i++) {
            result = (int) (result + Math.pow(26, chars.length-1-i) * (chars[i] - 'A' + 1));
        }

        return result;

    }
}
