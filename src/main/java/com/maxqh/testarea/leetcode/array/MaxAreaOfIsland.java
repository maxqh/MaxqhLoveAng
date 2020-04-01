package com.maxqh.testarea.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被
 * 0（代表水）包围着。
 * 
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-03-24 21:10
 */
public class MaxAreaOfIsland {
    /**
     * 通过 执行用时：25 ms 内存消耗：41.9 MB
     *
     * 击败了no-one
     * 
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int result = 0;

        int row = grid.length;
        int column = grid[0].length;

        Map<String, Boolean> map = new HashMap<>(row * column);

        for (int i = 0; i < row; i++) {
            int[] item = grid[i];
            for (int j = 0; j < column; j++) {
                if (item[j] == 0) {
                    continue;
                }

                if (map.containsKey(i + "," + j)) {
                    continue;
                }

                int temp = resolver(grid, i, j, map);
                result = Math.max(result, temp);

            }
        }

        return result;
    }

    private static int resolver(int[][] grid, int i, int j, Map<String, Boolean> map) {
        if (grid[i][j] < 1) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;

        if (map.containsKey(i + "," + j)) {
            return 0;
        } else {
            map.put((i + "," + j), Boolean.TRUE);
        }

        int result = 1;

        if (i < row - 1) {
            result = result + resolver(grid, i + 1, j, map);
        }

        if (i > 0) {
            result = result + resolver(grid, i - 1, j, map);
        }

        if (j < column - 1) {
            result = result + resolver(grid, i, j + 1, map);
        }

        if (j > 0) {
            result = result + resolver(grid, i, j - 1, map);
        }

        return result;
    }

    public static void main(String[] args) {
        // int[][] param = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, {
        // 0, 0, 0, 1, 1 } };
        int[][] param = { { 1 } };
        int result = maxAreaOfIslandOptimize(param);
        System.out.println(result);
    }

    /**
     * 通过 执行用时：3 ms 内存消耗：40.2 MB
     * 
     * 击败了70.46%的用户
     * 
     * @param grid
     * @return
     */
    public static int maxAreaOfIslandOptimize(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                result = Math.max(helper(grid, i, j), result);
            }
        }

        return result;
    }

    private static int helper(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0) {
            return 0;
        }

        if (grid[i][j] < 1) {
            return 0;
        }

        grid[i][j] = 0;

        return 1 + helper(grid, i - 1, j) + helper(grid, i + 1, j) + helper(grid, i, j - 1) + helper(grid, i, j + 1);
    }
}