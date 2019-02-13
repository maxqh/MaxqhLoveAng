package com.maxqh.testarea.leetcode.tree;

import java.util.Objects;

/**
 * @Author:qianhao
 * @Description: 翻转一棵二叉树。
 * @Date:2019/2/12
 * @Version:1.0
 */
public class InvertTree {

    /* 执行用时: 0 ms, 在Invert Binary Tree的Java提交中击败了100.00% 的用户 */
    public static TreeNode invertTree(TreeNode root) throws CloneNotSupportedException {
        if (Objects.isNull(root) || (Objects.isNull(root.left) && Objects.isNull(root.right))) {
            return root;
        }

        if (Objects.isNull(root.left)) {
            root.left = invertTree(root.right);
            root.right = null;
            return root;
        }

        if (Objects.isNull(root.right)) {
            root.right = invertTree(root.left);
            root.left = null;
            return root;
        }

        TreeNode temp = (TreeNode) root.left.clone();
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TreeNode root = new TreeNode(1);

        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = root4;
        root.left.right = root5;

        root.right.left = root6;
        root.right.right = root7;

        invertTree(root);
    }
}
