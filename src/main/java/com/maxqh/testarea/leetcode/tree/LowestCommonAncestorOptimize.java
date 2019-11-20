package com.maxqh.testarea.leetcode.tree;

/**
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-20 14:08
 */
public class LowestCommonAncestorOptimize {
    /**
     * 执行用时 : 8 ms , 在所有 java 提交中击败了 66.37% 的用户 内存消耗 : 36.2 MB , 在所有 java 提交中击败了
     * 82.30% 的用户
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (p == q) {
            return p;
        }

        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        return left == null ? right : (right == null ? left : root);
    }
}