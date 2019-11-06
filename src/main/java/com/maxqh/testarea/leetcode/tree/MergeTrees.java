package com.maxqh.testarea.leetcode.tree;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/2/11
 * @Version:1.0
 */

import java.util.Objects;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL
 * 的节点将直接作为新二叉树的节点。
 **/

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode result = maxqh(t1, t2);

        return result;
    }

    public TreeNode maxqh(TreeNode t1, TreeNode t2) {
        if (Objects.isNull(t2) || Objects.isNull(t1)) {
            return (Objects.isNull(t1) ? t2 : t1);
        } else {
            t1.val = t1.val + t2.val;
        }

        t1.left = maxqh(t1.left, t2.left);

        t1.right = maxqh(t1.right, t2.right);

        return t1;
    }
}
