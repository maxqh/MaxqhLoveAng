package com.maxqh.testarea.leetcode.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 使用队列实现栈的下列操作：
 * 
 * push(x) -- 元素 x 入栈 pop() -- 移除栈顶元素 top() -- 获取栈顶元素 empty() -- 返回栈是否为空
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-11 16:42
 */
public class MyStack {

    List<Integer> listPush = new ArrayList<>();

    List<Integer> listPop = new ArrayList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (listPush.isEmpty()) {
            listPush.add(x);
            return;
        }

        listPop.add(x);
        Iterator<Integer> iteratorPush = listPush.iterator();
        while (iteratorPush.hasNext()) {
            Integer item = iteratorPush.next();
            listPop.add(item);
            iteratorPush.remove();
        }

        List<Integer> temp;
        // 交换两个队列 无须重复复制
        temp = listPush;
        listPush = listPop;
        listPop = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return listPush.remove(0);
    }

    /** Get the top element. */
    public int top() {
        return listPush.get(0);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return listPush.isEmpty();
    }

    /**
     * 执行结果： 通过 显示详情 执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户 内存消耗 : 34 MB , 在所有
     * java 提交中击败了 71.62% 的用户
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}