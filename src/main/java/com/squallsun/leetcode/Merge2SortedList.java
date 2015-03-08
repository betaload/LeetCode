package com.squallsun.leetcode;

public class Merge2SortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        } else {

            ListNode h = new ListNode(0);
            ListNode cur = h;
            ListNode l1cur = l1;
            ListNode l2cur = l2;

            while (l1cur !=null && l2cur !=null) {
                if (l1cur.val < l2cur.val) {
                    cur.next = l1cur;
                    l1cur = l1cur.next;
                    cur = cur.next;
                    continue;
                } else {
                    cur.next = l2cur;
                    l2cur = l2cur.next;
                    cur = cur.next;
                    continue;
                }

            }

            if(l1cur == null && l2cur!=null) {
                cur.next = l2cur;
            }
            if(l1cur != null && l2cur ==null) {
                cur.next = l1cur;
            }


            return h.next;

        }

    }
}
