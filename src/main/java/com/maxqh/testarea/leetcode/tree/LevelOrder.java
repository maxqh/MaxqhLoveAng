package com.maxqh.testarea.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/3/14
 * @Version:1.0
 */

/*
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 */

/*
 * 执行用时 : 7 ms, 在N-ary Tree Level Order Traversal的Java提交中击败了82.75% 的用户 内存消耗 :
 * 52.6 MB, 在N-ary Tree Level Order Traversal的Java提交中击败了3.85% 的用户
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(MultiTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rootVal = new ArrayList<>();
        rootVal.add(root.val);

        result.add(rootVal);
        List<List<Integer>> subList = levelOrderHelper(root.children);
        if (subList != null && subList.size() > 0) {
            result.addAll(subList);
        }

        return result;
    }

    private List<List<Integer>> levelOrderHelper(List<MultiTreeNode> children) {
        if (children == null || children.size() < 1) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        List<MultiTreeNode> childList = new ArrayList<>();
        for (MultiTreeNode child : children) {
            if (child == null) {
                continue;
            }

            subList.add(child.val);
            if (child.children == null || child.children.size() < 1) {
                continue;
            }

            childList.addAll(child.children);
        }

        result.add(subList);

        if (childList.size() > 0) {
            result.addAll(levelOrderHelper(childList));
        }

        return result;
    }

}
