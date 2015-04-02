package com.squallsun.leetcode;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] A) {

        if (A == null || A.length == 0) {
            return 1;
        }

        if(A.length==1) {
            if(A[0] <1 || A[0] > 1) {
                return 1;
            }
            return 2;
        }
        int min = 1;
        int secMin = 2;
        for(int i = 0; i< A.length; i++) {

            if(A[i]<min) {
                secMin = min;
                min = A[i];
            } else if(A[i] < secMin && A[i] > min) {
                secMin = A[i];
            }
        }

        if(secMin < 0) {
            return 1;
        }

        if(min>1) {
            return 1;
        }

        if(secMin == min+1) {
            return secMin+1;
        }

        return min+1;
    }

    public static void main(String[] args) {
        int[] a = {1,1};
        System.out.println(firstMissingPositive(a));
    }
}
