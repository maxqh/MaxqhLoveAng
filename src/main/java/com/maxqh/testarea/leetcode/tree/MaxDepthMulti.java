package com.maxqh.testarea.leetcode.tree;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/3/15
 * @Version:1.0
 */

/*
 * 显示详情 执行用时 : 5 ms, 在Maximum Depth of N-ary Tree的Java提交中击败了70.67% 的用户 内存消耗 :
 * 51.1 MB, 在Maximum Depth of N-ary Tree的Java提交中击败了0.68% 的用户
 */
public class MaxDepthMulti {
    public int maxDepth(MultiTreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, 1);
    }

    private int helper(MultiTreeNode root, int i) {
        if (root.children == null || root.children.size() < 1) {
            return i;
        }

        int temp = i;
        for (MultiTreeNode child : root.children) {
            int sub = helper(child, i + 1);
            if (sub > temp){
                temp = sub;
            }
        }

        return temp;
    }
}
