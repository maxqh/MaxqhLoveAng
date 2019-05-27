package com.maxqh.testarea.leetcode.linkedlist;

/**
 * RemoveElements
 *
 * @Author:qianhao
 * @Description: 删除链表中等于给定值 val 的所有节点。
 * @Date:2019/5/27
 * @Version:1.0
 */
public class RemoveElements {

    /**
     * 成功 显示详情 执行用时 : 1 ms, 在Remove Linked List Elements的Java提交中击败了100.00% 的用户
     * 内存消耗 : 38.4 MB, 在Remove Linked List Elements的Java提交中击败了96.30% 的用户
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode temp = head;
        ListNode pre = head;
        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
            } else {
                pre = temp;
            }

            temp = temp.next;
        }

        return head;
    }
}