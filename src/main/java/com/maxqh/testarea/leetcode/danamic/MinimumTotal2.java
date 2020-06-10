package com.maxqh.testarea.leetcode.danamic;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * 
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ] 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-06-05 10:10
 */
public class MinimumTotal2 {
    /**
     * 击败了75.44%的用户
     *
     * 43 / 43 个通过测试用例
     *
     * 状态：通过 执行用时：3 ms 内存消耗：39.9 MB
     *
     * @param triangle
     * @return
     */
    public int minimumTotalOptimise(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[][] dpArray = new int[triangle.size()][triangle.size()];
        dpArray[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> subList = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dpArray[i][j] = subList.get(j) + dpArray[i - 1][0];
                } else if (j < i) {
                    dpArray[i][j] = subList.get(j) + Math.min(dpArray[i - 1][j], dpArray[i - 1][j - 1]);
                } else {
                    dpArray[i][j] = subList.get(j) + dpArray[i - 1][i - 1];
                }
            }
        }

        int min = dpArray[triangle.size() - 1][0];
        for (int item : dpArray[triangle.size() - 1]) {
            min = Math.min(min, item);
        }
        return min;
    }

    /**
     * 通过 击败了23.07%的用户
     *
     * 执行用时：6 ms 内存消耗：40.1 MB
     *
     * @param triangle
     * @return
     */
    public int minimumTotalVoilence(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[] result = new int[triangle.get(triangle.size() - 1).size()];
        result[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> subList = triangle.get(i);

            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    subList.set(j, result[j] + subList.get(j));
                } else if (j + 1 < subList.size()) {
                    subList.set(j, Math.min(result[j], result[j - 1]) + subList.get(j));
                } else {
                    subList.set(j, result[j - 1] + subList.get(j));
                }
            }

            for (int k = 0; k < subList.size(); k++) {
                result[k] = subList.get(k);
            }
        }

        int min = result[0];
        for (int item : result) {
            min = Math.min(min, item);
        }

        return min;
    }
}