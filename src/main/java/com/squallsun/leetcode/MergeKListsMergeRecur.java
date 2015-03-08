package com.squallsun.leetcode;

import java.util.List;

public class MergeKListsMergeRecur {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        if (lists.size() ==1 ) {
            return lists.get(0);
        } else {
            return mergeKlists(lists, 0, lists.size() -1);
        }
    }

    public ListNode mergeKlists(List<ListNode> lists, int l, int r) {
        if (l <r) {
            int m = (l+r)/2;
            ListNode llist = mergeKlists(lists, l, m);
            ListNode rlist = mergeKlists(lists, m+1, r);
            return mergeTwoLists(llist,rlist);
        }
        return lists.get(l);
    }

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
