package com.squallsun.leetcode;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        String reverseWord = "";
        String[] stringArray = s.split(" ");
        for (String s1 : stringArray) {
            reverseWord = reverseWord + new StringBuffer(s1).reverse().toString() + " ";
        }

        String result = new StringBuffer(reverseWord).reverse().toString().trim();
        return result;
    }
}
