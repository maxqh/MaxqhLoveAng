package com.maxqh.testarea.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/3/15
 * @Version:1.0
 */

/*
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 */

/*
 * 成功 显示详情 执行用时 : 4 ms, 在N-ary Tree Postorder Traversal的Java提交中击败了93.73% 的用户
 * 内存消耗 : 48.4 MB, 在N-ary Tree Postorder Traversal的Java提交中击败了13.70% 的用户
 */
public class Postorder {

    public List<Integer> postorder(MultiTreeNode root) {
        List<Integer> result = new ArrayList<>();

        helper(root, result);
        return result;
    }

    public void helper(MultiTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.children == null || root.children.size() < 1) {
            res.add(root.val);
            return;
        }

        for (MultiTreeNode child : root.children) {
            if (child == null) {
                continue;
            }

            helper(child, res);
        }

        res.add(root.val);
    }
}
