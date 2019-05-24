package com.maxqh.testarea.leetcode.linkedlist;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @Author:qianhao
 * @Description: 合并两个有序链表
 * @Date:2019/5/22
 * @Version:1.0
 */
public class MergeTwoLists {
    /**
     * 成功 显示详情 执行用时 : 2 ms, 在Merge Two Sorted Lists的Java提交中击败了97.20% 的用户 内存消耗 :
     * 34.9 MB, 在Merge Two Sorted Lists的Java提交中击败了94.17% 的用户
     * 
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = null;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }

        head = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }

            result = result.next;
        }

        if (l1 == null) {
            result.next = l2;
        } else {
            result.next = l1;
        }

        return head;
    }
}
