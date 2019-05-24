package com.maxqh.testarea.leetcode.linkedlist;

/**
 * DeleteDuplicates 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * @Author:qianhao
 * @Description: 删除排序链表中的重复元素
 * @Date:2019/5/24
 * @Version:1.0
 */
public class DeleteDuplicates {
    /**
     * 显示详情 执行用时 : 2 ms, 在Remove Duplicates from Sorted List的Java提交中击败了74.98%
     * 的用户 内存消耗 : 36.6 MB, 在Remove Duplicates from Sorted List的Java提交中击败了64.98%
     * 的用户
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        while (head != null && head.next != null && head.val == head.next.val) {
            head = head.next;
        }

        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
