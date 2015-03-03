package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraphBFS {

    private static void copy(HashMap<Character, ArrayList<Character>> graph,char start, HashMap<Character, ArrayList<Character>> copygraph)
    {
        HashSet<Character> copied = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        if (copygraph == null) {
            copygraph = new HashMap<>();
        }
        q.add(start);//将s作为起始顶点加入队列
        while(!q.isEmpty()) {
            char top=q.poll();//取出队首元素
            copied.add(top);
            char copiedTop = top;
            ArrayList<Character> l = new ArrayList<>();
            for (Character c : graph.get(top)) {
                l.add(c);
                if (!copied.contains(c)) {
                    q.add(c);
                }
            }
            copygraph.put(copiedTop, l);
        }
    }

    public static void main(String[] args) {
        HashMap<Character, ArrayList<Character>> original = new HashMap<>();

        original.put('1', new ArrayList<>(Arrays.asList('2', '5')));
        original.put('2', new ArrayList<>(Arrays.asList('1', '5', '3', '4')));
        original.put('3', new ArrayList<>(Arrays.asList('2', '4')));
        original.put('4', new ArrayList<>(Arrays.asList('2', '5', '3')));
        original.put('5', new ArrayList<>(Arrays.asList('4', '1', '2')));

        HashMap<Character, ArrayList<Character>> result = new HashMap<>();

        original.forEach((key, value) -> {
            System.out.print(key + "->");
            for (Character character : value) {
                System.out.print(" " + character + " ");
            }
            System.out.println();
        });
        copy(original, '1', result);
        System.out.println("==============");
        result.forEach((key, value) -> {
            System.out.print(key + "->");
            for (Character character : value) {
                System.out.print(" " + character + " ");
            }
            System.out.println();
        });
    }
}
