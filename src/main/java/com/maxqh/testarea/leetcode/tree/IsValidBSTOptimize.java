package com.maxqh.testarea.leetcode.tree;

/**
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-20 11:06
 */
public class IsValidBSTOptimize {
    /**
     * 执行结果： 通过 显示详情 执行用时 : 1 ms , 在所有 java 提交中击败了 95.72% 的用户 内存消耗 : 36.2 MB , 在所有
     * java 提交中击败了 95.72% 的用户
     * 
     * @param root
     * @return
     */
    public Boolean isValidBST(TreeNode root) {
        if (root == null) {
            return Boolean.TRUE;
        }

        return helper(root, null, null);
    }

    private Boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return Boolean.TRUE;
        }

        if (min != null && min >= root.val) {
            return Boolean.FALSE;
        }
        if (max != null && max <= root.val) {
            return Boolean.FALSE;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}