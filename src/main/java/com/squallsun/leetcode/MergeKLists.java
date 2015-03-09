package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeKLists {

    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        List<List<ListNode>> res = buildList(lists);
        if (res == null) {
            return null;
        }
        List<ListNode> l = res.stream().flatMap(list -> list.stream())
            .sorted((e1, e2) -> Integer.compare(e1.val, e2.val))
            .collect(Collectors.toList());
        return l.get(0);
    }

    private List<List<ListNode>> buildList(List<ListNode> list) {
        List<List<ListNode>> res = new ArrayList<>();
        for(int i = 0; i<list.size(); i++) {
            List<ListNode> a = new ArrayList<>();
            ListNode start = list.get(i);
            if(start == null) {
                return null;
            }
            a.add(start);
            while (start.next != null) {
                a.add(start.next);
                start = start.next;
            }
            res.add(a);
        }
        return  res;
    }
}
