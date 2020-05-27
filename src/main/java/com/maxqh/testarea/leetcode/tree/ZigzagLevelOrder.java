package com.maxqh.testarea.leetcode.tree;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 *
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如： 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 3 / \ 9 20 / \ 15 7 返回锯齿形层次遍历如下：
 * 
 * [ [3], [20,9], [15,7] ]
 * 
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-05-19 17:17
 */
public class ZigzagLevelOrder {

    /**
     * 通过 击败了24.89%的用户
     *
     * 执行用时：2 ms 内存消耗：39.8 MB
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        result.add(rootList);

        Boolean isLeftFirst = Boolean.FALSE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> subList = new ArrayList<>();
        List<TreeNode> treeNodeList = new ArrayList<>(1);
        while (!stack.isEmpty()) {
            TreeNode item = stack.pop();

            if (isLeftFirst) {
                if (item.left != null) {
                    treeNodeList.add(item.left);
                }

                if (item.right != null) {
                    treeNodeList.add(item.right);
                }
            } else {
                if (item.right != null) {
                    treeNodeList.add(item.right);
                }

                if (item.left != null) {
                    treeNodeList.add(item.left);
                }
            }

            if (stack.isEmpty()) {
                if (treeNodeList == null || treeNodeList.size() < 1) {
                    return result;
                }

                for (TreeNode treeNode : treeNodeList) {
                    subList.add(treeNode.val);
                    stack.push(treeNode);
                }

                isLeftFirst = !isLeftFirst;
                result.add(subList);

                subList = new ArrayList<>();
                treeNodeList = new ArrayList<>();
            }
        }

        return result;
    }

    /**
     * 优化
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderOptimise(TreeNode root) {
        // todo
        return null;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        result.add(list);
        list.clear();

        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);

        result.add(list);

        System.out.println(result);
    }
}