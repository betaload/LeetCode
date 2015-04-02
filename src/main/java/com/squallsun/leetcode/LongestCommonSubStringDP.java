package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubStringDP {


    public static void main(String[] args) {

        String s1 = "abcdef5ghijklmssk1234567aasdfghjkl";
        String s2 = "xbcaddycad2423def5gkdi2ehijklmsk1234567xasdfghjkl";

        int[][] matrix = new int[s1.length()][s2.length()];

        int index = 0;
        int max = 0;

        int length = s1.length() > s2.length() ? s1.length() : s2.length();

        List<Integer> indecis = new ArrayList<>();



        for(int i = 0; i< s1.length(); i++) {
            for (int j = 0; j< s2.length(); j++) {
                if(s1.substring(i, i+1).equals(s2.substring(j,j+1))) {
                    if((i - 1 > 0) && (j - 1 > 0)) {
                        matrix[i][j]=matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }

                    if (matrix[i][j] == max) {
                        index = i;
                        indecis.add(new Integer(index));
                    } else if (matrix[i][j] > max) {
                        max = matrix[i][j];
                        index = i;
                        indecis.clear();
                        indecis.add(new Integer(index));
                    }
                }
            }
        }

        System.out.println("max length: " + max);
        System.out.println("max length start index: " + index);
        indecis.stream().forEach(i -> System.out.println(i));
        final int finalMax = max;
        indecis.stream().forEach(i ->System.out.println(s1.substring(i - finalMax + 1, i + 1)));
//        System.out.println("LCS: " + s1.substring(index - max +1, index+1));
    }

}