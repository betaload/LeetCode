package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunj6 on 2015/2/15.
 */
public class SameSubStringN3 {

    public static void main(String[] args) {

        String a = "abcdefgh";

        String b = "edfghabc";

        List<String> result = new ArrayList<>();

        for (int i = 0; i<a.length(); i++) {
            for (int j = i+1; j <= a.length(); j++) {
                for (int x = 0; x < b.length(); x ++) {
                    for (int y = x+1; y <= b.length(); y++) {
                        if(a.substring(i,j).equals(b.substring(x,y))) {
                            result.add(a.substring(i,j));
                        }
                    }
                }
            }
        }

        System.out.println(result.size());
        System.out.println(Arrays.toString(result.toArray()));
    }
}
