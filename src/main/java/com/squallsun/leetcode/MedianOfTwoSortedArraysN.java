package com.squallsun.leetcode;

public class MedianOfTwoSortedArraysN {

    private static double solution(int[] A, int[] B) {
        if((A == null || A.length == 0) && (B!=null && B.length > 0)) {
            int len2 = B.length;
            int mid = len2/2;
            if(len2 % 2 != 0) {
                return (double)B[mid];
            } else {
                return ((double)B[mid-1] + (double)B[mid])/2;
            }
        }

        if((B == null || B.length == 0)  && (A!=null && A.length > 0)) {
            int len1 = A.length;
            int mid = len1/2;
            if(len1 % 2 != 0) {
                return (double)A[mid];
            } else {
                return ((double)A[mid-1] + (double)A[mid])/2;
            }
        }



        int len1 = A.length;
        int len2 = B.length;

        if(len1 == 1 && len2 == 1) {
            return ((double)A[0] + (double)B[0])/2;
        }

        int mid = (len1 + len2)/2;

        int[] result = new int[len1 + len2];

        int index = 0;
        if ((len1 + len2)%2 != 0) {
            for (int i = 0, j = 0; i + j <= mid; ) {
                if(i == len1) {
                    if(j < len2) {
                        result[index] = B[j];
                        j++;
                    }
                } else if (j == len2) {
                    if(i < len1) {
                        result[index] = A[i];
                        i++;
                    }
                } else {
                    if (A[i] <= B[j]) {
                        result[index] = A[i];
                        i++;
                    } else {
                        result[index] = B[j];
                        j++;
                    }
                }
                index++;

            }
            return (double)result[index-1];
        } else {
            for (int i = 0, j = 0; i + j <= mid; ) {
                if(i == len1) {
                    if(j < len2) {
                        result[index] = B[j];
                        j++;
                    }
                } else if (j == len2) {
                    if(i < len1) {
                        result[index] = A[i];
                        i++;
                    }
                } else {
                    if (A[i] <= B[j]) {
                        result[index] = A[i];
                        i++;
                    } else {
                        result[index] = B[j];
                        j++;
                    }
                }
                index++;


            }
            return ((double)result[index-1] + (double)result[index-2]) / 2;
        }



    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2,3,4,5};
        System.out.println(solution(a,b));
    }
}
