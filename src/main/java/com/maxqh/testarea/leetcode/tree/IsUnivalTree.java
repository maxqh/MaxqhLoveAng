package com.maxqh.testarea.leetcode.tree;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/3/15
 * @Version:1.0
 */

/*
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */

/*
 * 执行用时 : 4 ms, 在Univalued Binary Tree的Java提交中击败了93.69% 的用户 内存消耗 : 34.3 MB,
 * 在Univalued Binary Tree的Java提交中击败了100.00% 的用户
 */
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return Boolean.TRUE;
        }

        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int val) {
        if (root == null) {
            return Boolean.TRUE;
        }

        if (root.left != null && root.left.val != val) {
            return Boolean.FALSE;
        }

        if (root.right != null && root.right.val != val) {
            return Boolean.FALSE;
        }

        return helper(root.right, val) && helper(root.left, val);
    }
}
