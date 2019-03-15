package com.maxqh.testarea.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author:qianhao
 * @Description: 给定一个 N 叉树，返回其节点值的前序遍历。
 * @Date:2019/2/13
 * @Version:1.0
 */

/*
 * 执行用时 : 4 ms, 在N-ary Tree Preorder Traversal的Java提交中击败了92.50% 的用户 内存消耗 : 52.6
 * MB, 在N-ary Tree Preorder Traversal的Java提交中击败了0.58% 的用户
 */
public class Preorder {
    public List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(MultiTreeNode root) {
        maxqh(root);
        return result;
    }

    private void maxqh(MultiTreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        result.add(root.val);

        if (root.children.size() < 1) {
            return;
        }

        for (MultiTreeNode child : root.children) {
            result.addAll(preorder(child));
        }

        return;
    }
}
