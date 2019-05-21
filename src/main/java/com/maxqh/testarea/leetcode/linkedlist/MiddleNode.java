package com.maxqh.testarea.leetcode.linkedlist;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 
 * 如果有两个中间结点，则返回第二个中间结点。
 * 
 * @Author:qianhao
 * @Description: 链表的中间结点
 * @Date:2019/5/21
 * @Version:1.0
 */
public class MiddleNode {
    /**
     * 成功 显示详情 执行用时 : 0 ms, 在Middle of the Linked List的Java提交中击败了100.00% 的用户
     * 内存消耗 : 33.4 MB, 在Middle of the Linked List的Java提交中击败了92.88% 的用户
     * 
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
