package com.maxqh.testarea.leetcode.array;

import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-13 16:29
 */
public class MaxSlidingWindowOptimize {

    /**
     * 执行结果： 通过 显示详情 执行用时 : 13 ms , 在所有 java 提交中击败了 80.78% 的用户 内存消耗 : 41 MB , 在所有
     * java 提交中击败了 95.61% 的用户
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k <= 0) {
            return new int[] {};
        }

        LinkedList<Integer> window = new LinkedList<Integer>();
        int[] result = new int[(nums.length - k + 1)];

        for (int i = 0; i < nums.length; i++) {
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.removeLast();
            }

            window.add(i);

            if (window.peek() <= i - k) {
                // 移除过期元素
                window.removeFirst();
            }

            if (i + 1 >= k) {
                result[i - k + 1] = nums[window.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] aa = maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
        for (int item : aa) {
            System.out.println(item);
        }
    }
}
