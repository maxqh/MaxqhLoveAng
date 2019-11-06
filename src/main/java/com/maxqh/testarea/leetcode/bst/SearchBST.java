package com.maxqh.testarea.leetcode.bst;


/**
 *
 *
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/16
 * @Version:1.0
 */
public class SearchBST {
    /*
    给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

    例如，

    给定二叉搜索树:

            4
            / \
            2   7
            / \
            1   3

    和值: 2
    你应该返回如下子树:

            2
            / \
            1   3
    在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
    */


    public TreeNode searchBST(TreeNode root, int val) {
        /*
        成功
                显示详情
        执行用时: 2 ms, 在Search in a Binary Search Tree的Java提交中击败了100.00% 的用户
        */
        while (true){
            if(root == null || root.val == val){
                return root;
            } else if(root.val > val){
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
}
