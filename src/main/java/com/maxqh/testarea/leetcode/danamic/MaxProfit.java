package com.maxqh.testarea.leetcode.danamic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/17
 * @Version:1.0
 */
public class MaxProfit {
    /*
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 
     * 注意你不能在买入股票前卖出股票。
     * 
     * 示例 1:
     * 
     * 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 =
     * 6）的时候卖出，最大利润 = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。 示例 2:
     * 
     * 输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */


    /*
     * 
     * 成功 显示详情 执行用时: 362 ms, 在Best Time to Buy and Sell Stock的Java提交中击败了11.53%
     * 的用户
     */

    class Solution {
        public int maxProfit(int[] prices) {
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] < prices[j]) {
                        nums.add(prices[j] - prices[i]);
                    }
                }
            }

            if (nums == null || nums.size() < 1) {
                return 0;
            }

            nums.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            return nums.get(0);
        }
    }
}
