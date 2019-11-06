package com.maxqh.testarea.leetcode.linkedlist;

/**
 * HasCycle
 *
 * @Author:qianhao
 * @Description: 给定一个链表，判断链表中是否有环  -->快慢指针
 * @Date:2019/5/29
 * @Version:1.0
 */
public class HasCycle {
    /**
     * 成功 显示详情 执行用时 : 1 ms, 在Linked List Cycle的Java提交中击败了92.36% 的用户 内存消耗 : 39.2
     * MB, 在Linked List Cycle的Java提交中击败了51.42% 的用户
     * 
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return Boolean.FALSE;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return Boolean.TRUE;
            }

            if (fast.next == null) {
                return Boolean.FALSE;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return Boolean.FALSE;
    }
}
