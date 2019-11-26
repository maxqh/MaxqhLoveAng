package com.maxqh.testarea.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-22 15:28
 */
public class LevelOrder2 {

    /**
     * 执行结果： 通过 显示详情 执行用时 : 1 ms , 在所有 java 提交中击败了 99.42% 的用户 内存消耗 : 36.4 MB , 在所有
     * java 提交中击败了 46.74% 的用户
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        result.add(rootList);

        helper(temp, result);

        return result;
    }

    private void helper(List<TreeNode> temp, List<List<Integer>> result) {
        if (temp == null || temp.size() < 1) {
            return;
        }

        List<Integer> subList = new ArrayList<>(temp.size());
        List<TreeNode> subNodeList = new ArrayList<>(temp.size());
        for (TreeNode item : temp) {
            if (item.left != null) {
                subList.add(item.left.val);
                subNodeList.add(item.left);
            }

            if (item.right != null) {
                subList.add(item.right.val);
                subNodeList.add(item.right);
            }
        }

        if (!subList.isEmpty()) {
            result.add(subList);
        }

        helper(subNodeList, result);
    }
}