package com.squallsun.leetcode;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class RemoveFromNFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n ==1) {
            return null;
        }


        ListNode start=head, tail = head;
        boolean b = false;
        boolean c = false;
        int i = 0;
        while(start.next != null) {
            i = 0;
            for(; i<n; i++) {
                if(tail.next != null) {
                    tail = tail.next;
                } else {
                    b=true;
                    break;
                }
            }
            if(b || i == n) {
                c = true;
                break;
            }
            start = start.next;
            tail = start;
        }

        if(c) {
            start.next = start.next.next;
        }

        if(b && i<n) {
            head = head.next;
        }



        return  head;
    }

    public static ListNode build(int[] a) {
        ListNode header = new ListNode(a[0]);
        ListNode pre = header;
        for(int i = 1; i<a.length; i++) {
            ListNode node = new ListNode(a[i]);
            pre.next = node;
            pre = pre.next;

        }
        return header;
    }

    public static void main(String[] args) {

        int[] a = {1,2};
        ListNode header = build(a);
        removeNthFromEnd(header, 1);
    }

}
