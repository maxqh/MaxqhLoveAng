package com.maxqh.testarea.leetcode.danamic;

/**
 * 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意：你不能在买入股票前卖出股票。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润
 * = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。 示例 2:
 * 
 * 输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-05-27 15:48
 */
public class MaxProfitOptimise {
    /**
     * 通过 击败了7.75%的用户
     *
     * 状态：通过 执行用时：380 ms 内存消耗：39.8 MB
     *
     * @param prices
     * @return
     */
    public int maxProfitVoilence(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int sum = prices[j] - prices[i];
                if (sum > result[i]) {
                    result[i] = sum;
                }
            }
        }

        int max = 0;
        for (int item : result) {
            max = Math.max(max, item);
        }

        return max;
    }

    /**
     * 通过 击败了98.8%的用户
     *
     * 执行用时：1 ms 内存消耗：39.7 MB
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] dp = new int[prices.length];
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                dp[i] = dp[i - 1];
                min = prices[i];
            } else {
                dp[i] = Math.max((prices[i] - min), dp[i - 1]);
            }
        }

        return dp[prices.length - 1];
    }
}