package com.maxqh.testarea.leetcode.bst;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/16
 * @Version:1.0
 */
public class TreeNode implements Cloneable{
    int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
