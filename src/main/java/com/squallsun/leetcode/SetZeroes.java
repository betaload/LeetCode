package com.squallsun.leetcode;

public class SetZeroes {

    public static void setZeroes(int[][] matrix) {

        int[] x = new int[matrix[0].length];
        int[] y = new int[matrix.length];

        for(int i = 0; i< x.length; i++) {
            x[i] = -1;
        }

        for(int i = 0; i< y.length; i++) {
            y[i] = -1;
        }


        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    x[j] = 0;
                    y[i] = 0;
                }
            }
        }

        for(int i = 0; i<x.length; i++) {
            if(x[i] == 0) {
                for(int k = 0; k<matrix.length; k++) {
                    matrix[k][i] = 0;
                }
            }
        }

        for(int i = 0; i<y.length; i++) {
            if(y[i] == 0) {
                for(int k = 0; k<matrix[i].length; k++) {
                    matrix[i][k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setZeroes(a);
    }
}
