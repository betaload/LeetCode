package com.squallsun.leetcode;

public class SearchForARange {
    public static int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        int[] result2 = {0, 0};
        if(A == null || A.length == 0) {
            return result;
        }

        int len = A.length;

        if(len == 1) {
            return A[0] == target ? result2: result;
        }

        int i = 0;
        int j = len-1;

        int indexL = -1;
        int indexR = -1;
        while(i <= j) {
            int m = (i+j)/2;
            if(A[m] < target) {
                j = m;
            } else if (A[m] > target) {
                i = m;
            } else {
                indexL = m;
                indexR = m;
                break;
            }
        }

        i = 0; j = indexL;
        while (i <= j) {
            int m = (i+j)/2;
            if(A[m] < target) {
                j = m;
            } else if (A[m] > target) {
                i = m;
            } else {
                indexL = m;
                break;
            }
        }


        i = indexR; j = len-1;
        while (i <= j) {
            int m = (i+j)/2;
            if(A[m] < target) {
                j = m;
            } else if (A[m] > target) {
                i = m;
            } else {
                indexR = m;
                break;
            }
        }

        result[0] = indexL - 1;
        result[1] = indexR + 1;

        return result;

    }

    public static void main(String[] args) {
        int[] a = {1};
        int target = 0;
        searchRange(a, target);
    }
}