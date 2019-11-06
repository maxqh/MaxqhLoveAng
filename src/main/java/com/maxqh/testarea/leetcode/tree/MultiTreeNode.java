package com.maxqh.testarea.leetcode.tree;

import java.util.List;

/**
 * @Author:qianhao
 * @Description: 多叉树
 * @Date:2019/3/14
 * @Version:1.0
 */
public class MultiTreeNode {
    public int val;
    public List<MultiTreeNode> children;

    public MultiTreeNode() {}

    public MultiTreeNode(int _val,List<MultiTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
