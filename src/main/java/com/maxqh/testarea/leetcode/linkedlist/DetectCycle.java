package com.maxqh.testarea.leetcode.linkedlist;

import java.util.HashMap;

/**
 * 环形链表 II 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 
 * 说明：不允许修改给定的链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：head = [3,2,0,-4], pos = 1 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 
 * 示例 2：
 * 
 * 输入：head = [1,2], pos = 0 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 
 * 示例 3：
 * 
 * 输入：head = [1], pos = -1 输出：no cycle 解释：链表中没有环。
 * 
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-05-06 11:01
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        return null;
    }

    /**
     * 16 / 16 个通过测试用例
     * 
     * 状态：通过 执行用时：3 ms
     * 
     * 内存消耗：39.6 MB
     * 
     * @param head
     * @return
     */
    public static ListNode detectCycleVoilence(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && slow != null) {
            if (fast == slow) {
                ListNode temp = fast.next;
                HashMap<ListNode, Boolean> map = new HashMap<>();
                map.put(fast, Boolean.TRUE);
                while (temp != fast) {
                    map.put(temp, Boolean.TRUE);
                    temp = temp.next;
                }

                temp = head;
                while (!map.containsKey(temp)) {
                    temp = temp.next;
                }

                return temp;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return fast;
            } else {
                fast = fast.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        ListNode end = new ListNode(-4);
        head.next.next.next = end;
        end.next = head;

        ListNode aa = detectCycleVoilence(head);
        System.out.println(aa);
    }
}