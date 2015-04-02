package com.squallsun.leetcode;

public class AddBinary {
    public static String addBinary(String a, String b) {
        if(a == null || b == null || a.length() ==0 || b.length() == 0) {
            return null;
        }
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int alen = ca.length;
        int blen = cb.length;


        char[] res ;
        if(alen>blen) {
            int gap = alen - blen;
            int needAdd = 0;
            res = new char[alen+1];
            for(int i = alen -1; i>=0; i--) {
                int ia = ca[i] - '0';
                int ib = -1;
                if (i-gap >= 0) {
                    ib = cb[i-gap] - '0';
                } else {
                    ib = 0;
                }
                int tmp = ia+ib+needAdd;
                if(tmp ==2) {
                    needAdd = 1;
                    res[i+1] = '0';
                }else if(tmp ==3) {
                    needAdd = 1;
                    res[i+1] = '1';
                } else {
                    needAdd = 0;
                    res[i+1] =  (char) ('0' + tmp);
                }
            }

            if(needAdd == 1) {
                res[0] = '1';
            } else {
                res[0] = '0';
            }
        } else {
            int gap = blen - alen;
            int needAdd = 0;
            res = new char[blen+1];
            for(int i = blen -1; i>=0; i--) {
                int ib = cb[i] - '0';
                int ia = -1;
                if (i-gap >= 0) {
                    ia = ca[i-gap] - '0';
                } else {
                    ia = 0;
                }
                int tmp = ia+ib+needAdd;
                if(tmp ==2) {
                    needAdd = 1;
                    res[i+1] = '0';
                }else if(tmp ==3) {
                    needAdd = 1;
                    res[i+1] = '1';
                }else {
                    needAdd = 0;
                    res[i+1] =  (char) ('0' + tmp);
                }
            }

            if(needAdd == 1) {
                res[0] = '1';
            } else {
                res[0] = '0';
            }
        }
        if(res[0] == '1') {
            return new String(res);
        } else {
            return new String(res, 1, res.length-1);
        }
    }

    public static void main(String[] args) {
        addBinary("110111", "101");
    }
}
