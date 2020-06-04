package com.maxqh.testarea.leetcode.danamic;

/**
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-06-04 15:16
 */
public class MaxSubArray2 {
    /**
     * 通过，击败了：no one
     *
     * 执行用时：156 ms 内存消耗：39.8 MB
     *
     * @param nums
     * @return
     */
    public int maxSubArrayViolence(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(sum, result);
            }
        }

        return result;
    }

    public int maxSubArrayOptimise(int[] nums) {
        return 0;
    }
}