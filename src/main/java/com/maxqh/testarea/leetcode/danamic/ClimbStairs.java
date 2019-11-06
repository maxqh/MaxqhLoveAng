package com.maxqh.testarea.leetcode.danamic;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/17
 * @Version:1.0
 */
public class ClimbStairs {
    /*
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 
     * 注意：给定 n 是一个正整数。
     * 
     * 示例 1：
     * 
     * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶 示例 2：
     * 
     * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
     */

    public int climbStairs(int n) {
        int[] result = new int[n];
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        result[0] = 1;
        result[1] = 2;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }
}
