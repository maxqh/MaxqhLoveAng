package com.maxqh.testarea.leetcode.linkedlist;

/**
 * SortedListToBST
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * @Author:qianhao
 * @Description: 有序链表转换二叉搜索树
 * @Date:2019/5/31
 * @Version:1.0
 */
public class SortedListToBST {
    /**
     * 最近提交结果： 通过 显示详情 执行用时 : 3 ms , 在所有Java提交中击败了 72.95% 的用户 内存消耗 : 41.1 MB ,
     * 在所有Java提交中击败了 43.74% 的用户
     * 
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            TreeNode root = new TreeNode(head.val);
            return root;
        }

        ListNode fast = head;
        ListNode middle = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            middle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        middle.next = null;
        fast = slow.next;
        TreeNode root = new TreeNode(slow.val);
        if (head != slow) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(fast);

        return root;
    }

}
