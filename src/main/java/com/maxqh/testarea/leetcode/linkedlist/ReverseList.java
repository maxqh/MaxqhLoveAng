package com.maxqh.testarea.leetcode.linkedlist;

/**
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @Author:qianhao
 * @Description:
 * @Date:2019/5/20
 * @Version:1.0
 */
public class ReverseList {

    /**
     * 成功 显示详情 执行用时 : 0 ms, 在Reverse Linked List的Java提交中击败了100.00% 的用户 内存消耗 :
     * 35.3 MB, 在Reverse Linked List的Java提交中击败了63.34% 的用户
     * 
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode temp = head;
        ListNode next = head.next;

        while (temp != null) {
            next = temp.next;

            temp.next = pre;
            if (next == null) {
                return temp;
            }

            pre = temp;
            temp = next;
        }

        return temp;
    }

}
