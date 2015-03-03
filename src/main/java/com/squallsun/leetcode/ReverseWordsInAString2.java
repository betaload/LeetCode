package com.squallsun.leetcode;

public class ReverseWordsInAString2 {

    public String reverseWords(String s) {
//        s = s.replaceAll("\\s+", " ").trim();
        String[] stringArray = s.trim().split("\\s+");
        String result = "";
        for (int index = stringArray.length - 1; index >= 0; index++) {
            result = result + stringArray[index] + " ";

        }

        return result.trim();
    }


}
