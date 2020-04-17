package com.maxqh.testarea.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-16 17:36
 */
public class LongestConsecutive {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 
     * 要求算法的时间复杂度为 O(n)。
     * 
     * 示例:
     * 
     * 输入: [100, 4, 200, 1, 3, 2] 输出: 4 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * 通过 击败了5.11%
     *
     * 执行用时：695 ms 内存消耗：40.2 MB
     *
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>(nums.length);
        int max = 1;

        for (int item : nums) {
            set.add(item);
        }

        for (Integer item : set) {
            int k = item;
            int temp = 1;
            while (set.contains(++k)) {
                temp += 1;
            }

            max = Math.max(max, temp);
        }

        return max;
    }

    /**
     * 通过 击败了83.11%
     *
     * 执行用时：5 ms 内存消耗：40.2 MB
     *
     * @param nums
     * @return
     */
    public static int longestConsecutiveOptimize(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>(nums.length);
        int max = 1;

        for (int item : nums) {
            set.add(item);
        }

        for (Integer item : set) {
            if (!set.contains(item - 1)) {
                int k = item;
                int temp = 1;
                while (set.contains(++k)) {
                    temp += 1;
                }

                max = Math.max(max, temp);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] param = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(param));
    }
}