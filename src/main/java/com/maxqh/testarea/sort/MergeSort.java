package com.maxqh.testarea.sort;

/**
 * MergeSort
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-12-23 16:41
 */
public class MergeSort {
    public static Integer[] MergeSort(Integer[] param) {
        if (param == null || param.length <= 1) {
            return param;
        }

        helper(0, param.length - 1, param);

        return param;
    }

    private static void helper(int start, int end, Integer[] param) {
        if (end <= start) {
            return;
        }

        if (end - start == 1 && param[start] > param[end]) {
            int temp = param[start];
            param[start] = param[end];
            param[end] = temp;
            return;
        }

        int middle = (end + start + 1) / 2;
        helper(start, middle - 1, param);
        helper(middle, end, param);

        int temp;
        while (start < middle && middle < end) {
            if (param[start] > param[middle]) {
                temp = param[start];
                param[start] = param[middle];
                param[middle] = temp;
            }

            start++;
        }
    }
}