package com.maxqh.testarea.leetcode.tree;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-19 21:32
 */
public class IsValidBST {
    public Boolean isValidBST(TreeNode root) {
        if (root == null) {
            return Boolean.TRUE;
        }

        return maxqh(root, null, null);
    }

    private Boolean maxqh(TreeNode root, Integer max, Integer min) {
        if (root.left != null && root.right != null) {
            if (root.left.val >= root.val || root.right.val <= root.val) {
                return Boolean.FALSE;
            }

            if (min != null && root.left.val<= min){
                return Boolean.FALSE;
            }

            if (max != null && root.right.val >= max){
                return Boolean.FALSE;
            }

            return maxqh(root.left, root.val, min) && maxqh(root.right, max, root.val);
        } else if (root.left != null) {
            if (root.left.val >= root.val) {
                return Boolean.FALSE;
            }

            if (min != null && root.left.val<= min){
                return Boolean.FALSE;
            }

            return maxqh(root.left, root.val, min);
        } else if (root.right != null) {
            if (root.right.val <= root.val) {
                return Boolean.FALSE;
            }

            if (max != null && root.right.val >= max){
                return Boolean.FALSE;
            }

            return maxqh(root.right, max, root.val);
        } else {
            return Boolean.TRUE;
        }
    }
}