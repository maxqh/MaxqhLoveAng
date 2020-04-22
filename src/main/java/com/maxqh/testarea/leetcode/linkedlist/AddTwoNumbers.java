package com.maxqh.testarea.leetcode.linkedlist;

/**
 * 两数相加
 * 
 * 
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-21 18:51
 */
public class AddTwoNumbers {
    /**
     * 通过 击败了36.4%的用户
     *
     * 执行用时：3 ms 内存消耗：39.6 MB
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersViolence(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Boolean isJump = Boolean.FALSE;
        ListNode result = new ListNode(l1.val + l2.val);
        isJump = helper(isJump, result);

        ListNode temp = result;
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;

        while (l1Temp.next != null || l2Temp.next != null) {
            if (l1Temp.next == null) {
                temp.next = new ListNode(l2Temp.next.val);
                isJump = helper(isJump, temp.next);

                temp = temp.next;
                l2Temp = l2Temp.next;
                continue;
            }

            if (l2Temp.next == null) {
                temp.next = new ListNode(l1Temp.next.val);
                isJump = helper(isJump, temp.next);

                temp = temp.next;
                l1Temp = l1Temp.next;
                continue;
            }

            temp.next = new ListNode(l1Temp.next.val + l2Temp.next.val);
            isJump = helper(isJump, temp.next);

            temp = temp.next;
            l1Temp = l1Temp.next;
            l2Temp = l2Temp.next;
        }

        if (isJump) {
            temp.next = new ListNode(1);
        }

        return result;
    }

    private static Boolean helper(Boolean isJump, ListNode next) {
        if (isJump) {
            next.val += 1;
            isJump = Boolean.FALSE;
        }

        if (next.val > 9) {
            next.val = next.val - 10;
            isJump = Boolean.TRUE;
        }

        return isJump;
    }

    /**
     * 1563 / 1563 个通过测试用例 状态：通过
     * 
     * 执行用时：3 ms
     * 
     * 内存消耗：39.3 MB
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersOptimize(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Boolean isJump = Boolean.FALSE;
        ListNode result = new ListNode(l1.val + l2.val);
        isJump = helper(isJump, result);

        ListNode temp = result;
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;

        while (l1Temp.next != null || l2Temp.next != null) {
            if (l1Temp.next == null || l2Temp.next == null) {
                temp.next = (l2Temp.next != null) ? l2Temp.next : l1Temp.next;
                isJump = helper(isJump, temp.next);
                temp = temp.next;
                while (isJump && temp.next != null) {
                    isJump = helper(isJump, temp.next);
                    temp = temp.next;
                }

                break;
            }

            temp.next = new ListNode(l1Temp.next.val + l2Temp.next.val);
            isJump = helper(isJump, temp.next);

            temp = temp.next;
            l1Temp = l1Temp.next;
            l2Temp = l2Temp.next;
        }

        if (isJump) {
            temp.next = new ListNode(1);
        }

        return result;

    }

    public static void main(String[] args) {
        // ListNode listNode = new ListNode(0);
        // listNode.next = new ListNode(8);
        // listNode.next.next = new ListNode(6);
        // listNode.next.next.next = new ListNode(5);
        // listNode.next.next.next.next = new ListNode(6);
        // listNode.next.next.next.next.next = new ListNode(8);
        // listNode.next.next.next.next.next.next = new ListNode(3);
        // listNode.next.next.next.next.next.next.next = new ListNode(5);
        // listNode.next.next.next.next.next.next.next.next = new ListNode(7);
        //
        // ListNode listNode1 = new ListNode(6);
        // listNode1.next = new ListNode(7);
        // listNode1.next.next = new ListNode(8);
        // listNode1.next.next.next = new ListNode(0);
        // listNode1.next.next.next.next = new ListNode(8);
        // listNode1.next.next.next.next.next = new ListNode(2);
        // listNode1.next.next.next.next.next.next = new ListNode(8);
        // listNode1.next.next.next.next.next.next.next = new ListNode(9);
        // listNode1.next.next.next.next.next.next.next.next = new ListNode(7);

        ListNode listNode = new ListNode(2);

        ListNode listNode1 = new ListNode(8);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);

        ListNode result = addTwoNumbersOptimize(listNode1, listNode);
        System.out.println(result);

    }
}