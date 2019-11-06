package com.maxqh.testarea.leetcode.tree;

import java.util.Objects;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/2/12
 * @Version:1.0
 */
public class MaxDepth {
    /**
     * 给定一个二叉树，找出其最大深度。
     * 
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 
     * 说明: 叶子节点是指没有子节点的节点。
     */

    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        return Math.max(left + 1, right + 1);
    }
}
