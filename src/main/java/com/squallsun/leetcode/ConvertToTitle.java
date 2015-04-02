package com.squallsun.leetcode;

public class ConvertToTitle {

    public static String convertToTitle(int n) {
        if(n<1) return "";
        int k = (n-1);
        StringBuffer res = new StringBuffer();

        while(k/26 > 0) {
            res.insert(0, (char)('A' + (n-1)%26));
            k = k / 26;
        }

        res.insert(0, (char)('A' + k%26));
        return res.toString();
    }

    public static void main(String[] args) {
        convertToTitle(27);
    }
}
