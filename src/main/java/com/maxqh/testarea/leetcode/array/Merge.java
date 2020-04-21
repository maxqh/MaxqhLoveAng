package com.maxqh.testarea.leetcode.array;

import com.maxqh.testarea.sort.QuickSortOptimise;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和
 * [2,6] 重叠, 将它们合并为 [1,6]. 示例 2:
 * 
 * 输入: [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-20 10:57
 */

public class Merge {

    public int[][] mergeVoilence(int[][] intervals) {
        int[][] result = new int[intervals.length][2];

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        for (int i = 0; i < intervals.length; i++) {

        }

        return null;
    }

    /**
     * 执行结果： 通过
     * 
     * 显示详情
     * 
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 86.79% 的用户
     * 
     * 内存消耗 : 42.6 MB , 在所有 Java 提交中击败了 35.61% 的用户
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        QuickSortOptimise.quickSortDoubleArray(intervals);

        int indexI = 0;
        result[indexI][0] = intervals[0][0];
        result[indexI][1] = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (result[indexI][1] < intervals[i][0]) {
                indexI++;
                result[indexI][0] = intervals[i][0];
                result[indexI][1] = intervals[i][1];
                continue;
            }

            result[indexI][1] = Math.max(result[indexI][1], intervals[i][1]);
            continue;
        }

        return Arrays.copyOfRange(result, 0, indexI + 1);
    }

    public static void main(String[] args) {
        // int[][] param = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] param = { { 1, 4 }, { 0, 0 } };
        int[][] result = merge(param);
        for (int[] item : result) {
            System.out.println("x=" + item[0] + ",y=" + item[1]);
        }

    }

    /**
     * 执行用时：5 ms 内存消耗：42.5 MB
     * 
     * @param intervals
     * @return
     */
    public static int[][] mergeOptimize(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        QuickSortOptimise.quickSortDoubleArray(intervals);

        int[] array = { intervals[0][0], intervals[0][1] };
        list.addLast(array);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.getLast();
            if (last[1] < intervals[i][0]) {
                int[] temp = { intervals[i][0], intervals[i][1] };
                list.addLast(temp);
                continue;
            }

            list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            continue;
        }

        int[][] result = new int[list.size()][2];

        int index = 0;
        for (int[] item : list) {
            result[index++] = item;
        }

        return result;
    }
}