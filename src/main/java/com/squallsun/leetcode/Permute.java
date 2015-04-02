package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permute {
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        List<Integer> list = IntStream.of(num).boxed().collect(Collectors.toList());
        dfs(list, result, current);
        return result;
    }

    private static void dfs(List<Integer> num, List<List<Integer>> result, List<Integer> current) {
        if(num.size() <2) {
            result.add(num);
            return;
        }

        if(num.size() == 2) {
            List<Integer> l1 = new ArrayList<Integer>();
            l1.addAll(current);
            l1.add(num.get(0));
            l1.add(num.get(1));

            List<Integer> l2 = new ArrayList<Integer>();
            l2.addAll(current);
            l2.add(num.get(1));
            l2.add(num.get(0));

            result.add(l1);
            result.add(l2);
            return;
        }


        for(int i = 0; i<num.size(); i++) {
            List<Integer> l = new ArrayList<>(num);
            List<Integer> c = new ArrayList<>(current);
            c.add(l.get(i));
            l.remove(i);
            dfs(l, result, c);
        }

    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        permute(a);
    }
}
