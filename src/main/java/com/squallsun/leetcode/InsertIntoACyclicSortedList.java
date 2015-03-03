package com.squallsun.leetcode;

public class InsertIntoACyclicSortedList {


    public class Node {
        int content;
        Node next;

    }

    private Node header;

    public void insert(int value) {
        Node n = new Node();
        n.content = value;


        if(this.header == null) {
            this.header = n;
            this.header.next = this.header;
            return;
        }

        Node current = this.header;
        Node next = this.header.next;

        while(next != header) {

            if (n.content >= current.content && n.content <= next.content) {
                current.next = n;
                n.next = next;
                return;
            }
            current = next;
            next = next.next;

        }

        current.next = n;
        n.next = next;
        if (current.content > n.content) {
            this.header = n;
        }
    }

    public String print() {

        String result = "";

        if (this.header == null) {
            return "empty";
        }
        Node current = this.header;


        while (current.next != header) {
            result = result + current.content + " ";
            current = current.next;
        }
        result = result + current.content + " to header " + current.next.content;
        return  result;
    }

    public static void main(String[] args) {
        InsertIntoACyclicSortedList list = new InsertIntoACyclicSortedList();
        list.insert(2);
        list.insert(4);
        list.insert(3);
        list.insert(6);

        list.insert(1);
        list.insert(5);
        list.insert(10);

        System.out.println(list.print());

    }
}


