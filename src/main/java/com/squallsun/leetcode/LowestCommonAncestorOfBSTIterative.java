package com.squallsun.leetcode;


public class LowestCommonAncestorOfBSTIterative {

    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode findLCAofBST(TreeNode root, TreeNode r1, TreeNode r2) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;

        while(cur != null) {
            if (r1.value < cur.value && r2.value > cur.value) {
                break;
            } else {
                if(r1.value < cur.value && r2.value < cur.value) {
                    cur = cur.left;
                } else if(r1.value > cur.value && r2.value > cur.value) {
                    cur = cur.right;
                }
            }
        }
        return cur;
    }
}
