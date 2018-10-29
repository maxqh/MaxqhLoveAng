package com.maxqh.testarea.leetcode.danamic;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/29
 * @Version:1.0
 */
public class MinimumTotal {
    /*
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * 
     * 例如，给定三角形：
     * 
     * [ [2], [3,4], [6,5,7], [4,1,8,3] ] 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 
     * 说明：
     * 
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     */

    /*
     * 成功 显示详情 执行用时: 7 ms, 在Triangle的Java提交中击败了86.06% 的用户
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] resultArray = new int[triangle.size()];
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        } else {
            resultArray[0] = triangle.get(0).get(0);
        }

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                int old = list.get(j);
                if (j == 0) {
                    list.set(0, resultArray[0] + old);
                } else if (j == i) {
                    list.set(j, resultArray[j - 1] + old);
                } else {
                    list.set(j, Math.min(resultArray[j - 1], resultArray[j]) + old);
                }
            }

            for (int x = 0; x < list.size(); x++) {
                resultArray[x] = list.get(x);
            }
        }

        int min = resultArray[0];
        for (int x = 0; x < resultArray.length; x++) {
            min = Math.min(min, resultArray[x]);
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        list1.add(2);
        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new LinkedList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new LinkedList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        minimumTotal(triangle);
    }
}
