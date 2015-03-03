package com.squallsun.leetcode;

public class LowestCommonAncestorOfBSTRecursive {


    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode findLCAofBST(TreeNode root, TreeNode t1, TreeNode t2) {
        if (root == null) {
            return null;
        }

        if (t1.value < root.value && t2.value < root.value) {
            findLCAofBST(root.left, t1, t2);
        } else if (t1.value > root.value && t2.value > root.value) {
            findLCAofBST(root.right, t1, t2);
        }
        return  root;

    }

}
