package com.maxqh.testarea.leetcode.tree;

import java.util.LinkedList;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-19 10:56
 */

public class LowestCommonAncestor {
    /**
     * 执行结果： 通过 显示详情 执行用时 : 10 ms , 在所有 java 提交中击败了 55.10% 的用户 内存消耗 : 36.3 MB , 在所有
     * java 提交中击败了 82.30% 的用户
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (p == q) {
            return p;
        }

        LinkedList<TreeNode> pList = new LinkedList<>();
        LinkedList<TreeNode> qList = new LinkedList<>();

        TreeNode temp = root;
        helper(temp, pList, p);
        temp = root;
        helper(temp, qList, q);

        return maxqh(pList, qList);
    }

    private TreeNode maxqh(LinkedList<TreeNode> pList, LinkedList<TreeNode> qList) {
        if (pList == null || qList == null || pList.size() < 1 || qList.size() < 1) {
            return null;
        }

        TreeNode p = pList.removeLast();
        TreeNode q = qList.removeLast();

        while (!pList.isEmpty() || !qList.isEmpty()) {
            if (pList.size() == qList.size()) {
                if (p == q) {
                    return p;
                }

                p = pList.removeLast();
                q = qList.removeLast();
            } else if (pList.size() > qList.size()) {
                p = pList.removeLast();

            } else if (pList.size() < qList.size()) {
                q = qList.removeLast();
            }
        }

        if (p == q) {
            return p;
        }

        return null;
    }

    public void helper(TreeNode root, LinkedList<TreeNode> list, TreeNode target) {
        while (root != null) {
            list.addLast(root);

            if (root.val == target.val) {
                break;
            } else if (root.val > target.val) {
                root = root.left;
            } else if (root.val < target.val) {
                root = root.right;
            }
        }
    }
}