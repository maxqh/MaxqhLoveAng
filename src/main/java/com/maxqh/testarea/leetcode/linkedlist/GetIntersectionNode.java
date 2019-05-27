package com.maxqh.testarea.leetcode.linkedlist;

/**
 * GetIntersectionNode
 *
 * @Author:qianhao
 * @Description: 找到两个单链表相交的起始节点。
 * @Date:2019/5/24
 * @Version:1.0
 */
public class GetIntersectionNode {
    /**
     * TODO 效率有待提高
     *
     * 执行用时 : 3 ms, 在Intersection of Two Linked Lists的Java提交中击败了31.43% 的用户 内存消耗
     * : 48.4 MB, 在Intersection of Two Linked Lists的Java提交中击败了5.05% 的用户
     * 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int aLength = getLinkedListSize(headA);
        int bLength = getLinkedListSize(headB);

        if (aLength > bLength) {
            return helper(aLength - bLength, headA, headB);
        } else {
            return helper(bLength - aLength, headB, headA);
        }
    }

    private ListNode helper(int i, ListNode headLong, ListNode headShort) {
        ListNode tempLong = headLong;
        ListNode tempShort = headShort;

        while (i > 0) {
            tempLong = tempLong.next;
            i--;
        }

        while (tempLong != null && tempShort != null) {
            if (tempLong == tempShort) {
                return tempLong;
            }

            tempLong = tempLong.next;
            tempShort = tempShort.next;
        }

        return null;
    }

    protected int getLinkedListSize(ListNode head) {
        if (head == null) {
            return 0;
        }

        int i = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            i++;
        }
        return i;
    }
}
