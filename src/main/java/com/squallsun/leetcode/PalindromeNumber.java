package com.squallsun.leetcode;

/**
 * Created by sunj6 on 2015/2/13.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        int count = 1, num = x;
        if (x < 0) {
            return false;
        }
        while (num / 10 != 0) {
            num = num / 10;
            count++;
        }
        for (int i = 0; i < count / 2; i++) {
            int a = i;
            int b = count - 1 - i;
            if (getnum(x, a) != getnum(x, b)) {
                return false;
            }
        }
        return true;
    }

    public static int getnum(int x, int i) {
        return (x / (int) Math.pow(10, i)) % 10;
    }

    public static void main(String[] args) {
        System.out.println("123454321 is " + (isPalindrome(123454321) ? "a palindrome." : "not a palindrome"));
        System.out.println("12344321 is " + (isPalindrome(12344321) ? "a palindrome." : "not a palindrome"));
        System.out.println("9023423 is " + (isPalindrome(9023423) ? "a palindrome." : "not a palindrome"));
    }
}
