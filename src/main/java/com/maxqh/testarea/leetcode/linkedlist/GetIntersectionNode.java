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
     * 执行用时 : 2 ms, 在Intersection of Two Linked Lists的Java提交中击败了39.55% 的用户
     * 
     * 内存消耗 :48.4 MB, 在Intersection of Two Linked Lists的Java提交中击败了5.05% 的用户
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode endA = null;
        ListNode endB = null;

        int aLength = getLinkedListSize(headA, endA);
        int bLength = getLinkedListSize(headB, endB);

        if (endA != endB) {
            return null;
        }

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

    protected int getLinkedListSize(ListNode head, ListNode end) {
        if (head == null) {
            return 0;
        }

        int i = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            i++;
        }

        end = temp;
        return i;
    }

    /**
     * 45 / 45 个通过测试用例
     *
     * 状态：通过 击败了99.97%的用户
     *
     * 执行用时：1 ms
     *
     * 内存消耗：42.3 MB
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeOptimise(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = ((tempA == null) ? headB : tempA.next);
            tempB = ((tempB == null) ? headA : tempB.next);
        }

        return tempA;
    }
}
