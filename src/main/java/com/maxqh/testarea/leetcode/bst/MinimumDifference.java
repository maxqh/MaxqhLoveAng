package com.maxqh.testarea.leetcode.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/16
 * @Version:1.0
 */
public class MinimumDifference {

    /*
     * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
     * 
     * 示例 :
     * 
     * 输入:
     * 
     * 1 \ 3 / 2
     * 
     * 输出: 1
     * 
     * 解释: 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。 注意: 树中至少有2个节点。
     */

    // 【错误原因】任意两节点、非相邻两节点
    /*
     * public int getMinimumDifference(TreeNode root) { return ang(root); }
     * 
     * public Integer maxqh(TreeNode root) { if (root == null) { return null; }
     * 
     * if (root.left == null && root.right == null) { return null; }
     * 
     * if (root.left != null && root.right != null) { if (Math.abs(root.val -
     * root.left.val) > Math.abs(root.val - root.right.val)) { return
     * Math.abs(root.val - root.right.val); } else { return Math.abs(root.val -
     * root.left.val); } }
     * 
     * if (root.left != null) { return Math.abs(root.val - root.left.val); }
     * else { return Math.abs(root.val - root.right.val); } }
     * 
     * public Integer ang(TreeNode root) { if (hasChildren(root)) { Integer left
     * = ang(root.left); Integer right = ang(root.right); Integer mini =
     * maxqh(root);
     * 
     * if (left != null && (mini >= left)) { mini = left; }
     * 
     * if (right != null && (mini >= right)) { mini = right; }
     * 
     * return mini; } return null; }
     * 
     * public boolean hasChildren(TreeNode root) { if (root == null ||
     * (root.left == null && root.right == null)) { return Boolean.FALSE; } else
     * { return Boolean.TRUE; } }
     */

    /*
    成功
            显示详情
    执行用时: 33 ms, 在Minimum Absolute Difference in BST的Java提交中击败了22.11% 的用户
    */

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = tree2List(root);
        list.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer number1, Integer number2) {
                return number1.compareTo(number2);
            }
        });

        Integer mini = null;
        for (int i = 0; i + 1 < list.size(); i++) {
            if (mini == null || (mini >= Math.abs(list.get(i) - list.get(i + 1)))) {
                mini = Math.abs(list.get(i) - list.get(i + 1));
            }
        }
        return mini;
    }

    public List<Integer> tree2List(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        maxqh(list, root);

        return list;
    }

    public void maxqh(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        maxqh(list, node.left);
        maxqh(list, node.right);
    }
}
