package com.maxqh.testarea.leetcode.linkedlist;

/**
 * 排序链表
 * 
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3 输出: 1->2->3->4 示例 2:
 * 
 * 输入: -1->5->3->4->0 输出: -1->0->3->4->5
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-22 17:08
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return null;
    }

    /**
     * 状态：通过 击败了0%的用户
     *
     * 执行用时：1736 ms
     *
     * 内存消耗：42.6 MB
     *
     * @param head
     * @return
     */
    public static ListNode sortListVoilence(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode front = head;

        while (front.next != null) {
            ListNode sentinel = front.next;

            if (head.val > sentinel.val) {
                if (head == front) {
                    head.next = sentinel.next;
                    sentinel.next = head;

                    head = sentinel;
                    front = head;
                } else {
                    ListNode temp = sentinel.next;

                    sentinel.next = head.next;
                    head.next = temp;
                    front.next = head;

                    head = sentinel;
                }
            }

            front = front.next;
        }

        front = head;
        while (front.next != null) {

            ListNode sentinel = front.next;
            ListNode pre = sentinel;
            ListNode next = sentinel.next;

            while (next != null) {
                if (sentinel.val > next.val) {
                    if (sentinel.next == next) {
                        front.next = next;
                        sentinel.next = next.next;
                        next.next = sentinel;
                    } else {
                        front.next = next;
                        pre.next = sentinel;

                        ListNode temp = next.next;
                        next.next = sentinel.next;
                        sentinel.next = temp;
                    }

                    // 恢复数据位置
                    ListNode temp = sentinel;
                    sentinel = next;
                    next = temp;
                }

                pre = next;
                next = next.next;
            }

            front = front.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);

        ListNode item1 = new ListNode(2);

        ListNode item2 = new ListNode(1);
        ListNode item3 = new ListNode(3);

        head.next = item1;
        item1.next = item2;
        item2.next = item3;

        ListNode result = sortListVoilence(head);
        System.out.println(result);
    }
}