package com.squallsun.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i<s.length(); i++ ) {
            if(s.charAt(i) == neeChar(st.peek())) {
                st.pop();
                continue;
            }
            if(isValid(s.charAt(i))) {
                st.push(s.charAt(i));
                continue;
            }
        }

        return st.empty();
    }

    private boolean isValid(char ch) {
        return ch == '(' || ch =='[' || ch =='{';
    }

    public char neeChar(char c) {
        switch (c) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
        }
        return 'd';
    }
}
