package com.maxqh.testarea.leetcode.danamic;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/29
 * @Version:1.0
 */
public class UniquePaths {
    /*
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 
     * 问总共有多少条不同的路径？
     * 
     * 
     * 
     * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
     * 
     * 说明：m 和 n 的值均不超过 100。
     * 
     * 示例 1:
     * 
     * 输入: m = 3, n = 2 输出: 3 解释: 从左上角开始，总共有 3 条路径可以到达右下角。 1. 向右 -> 向右 -> 向下 2.
     * 向右 -> 向下 -> 向右 3. 向下 -> 向右 -> 向右 示例 2:
     * 
     * 输入: m = 7, n = 3 输出: 28
     */

    /*
     * 成功 显示详情 执行用时: 1 ms, 在Unique Paths的Java提交中击败了67.87% 的用户
     */
    public int uniquePaths(int m, int n) {
        int[][] resultArray = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    resultArray[i][j] = 1;
                } else {
                    resultArray[i][j] = resultArray[i - 1][j] + resultArray[i][j - 1];
                }
            }
        }

        return resultArray[m - 1][n - 1];
    }
}
