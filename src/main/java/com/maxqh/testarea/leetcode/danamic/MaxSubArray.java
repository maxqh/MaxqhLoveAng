package com.maxqh.testarea.leetcode.danamic;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/18
 * @Version:1.0
 */
public class MaxSubArray {
    /*
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 
     * 示例:
     * 
     * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
     * 
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */

    /**
     * 通过 击败了8.7%的用户
     *
     * 执行用时：3 ms 内存消耗：39.6 MB
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Integer sum = 0;
        Integer max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }

            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 通过 击败了95.01%的用户
     *
     * 执行用时：1 ms 内存消耗：39.8 MB
     *
     * @param nums
     * @return
     */
    public int maxSubArrayOptimise(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int sum = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }

            max = Math.max(max, sum);
        }
        return max;
    }
}
