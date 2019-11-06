package com.maxqh.testarea.leetcode.danamic;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/23
 * @Version:1.0
 */
public class MinPathSum {
    /*
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 
     * 说明：每次只能向下或者向右移动一步。
     * 
     * 示例:
     * 
     * 输入: [ [1,3,1], [1,5,1], [4,2,1] ] 输出: 7 解释: 因为路径 1→3→1→1→1 的总和最小。
     */

    /*
     * 成功 显示详情 执行用时: 13 ms, 在Minimum Path Sum的Java提交中击败了28.86% 的用户
     */

    public static int minPathSum(int[][] grid) {
        int length = grid.length;
        int colomn = grid[0].length;

        int total = length + colomn;

        for (int i = 1; i < total - 1; i++) {
            for (int j = 0; (j < length) && (j <= i); j++) {
                if (j >= length) {
                    continue;
                }
                if ((i - j) >= colomn) {
                    continue;
                }

                if (j == 0) {
                    grid[j][i - j] = grid[j][i - j - 1] + grid[j][i - j];
                } else if ((i - j) == 0) {
                    grid[j][i - j] = grid[j - 1][i - j] + grid[j][i - j];
                } else {
                    grid[j][i - j] = Math.min((grid[j][i - j - 1] + grid[j][i - j]),
                            (grid[j - 1][i - j] + grid[j][i - j]));
                }
            }
        }

        return grid[length - 1][colomn - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        minPathSum(grid);
    }

}
