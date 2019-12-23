package com.maxqh.testarea.sort;

/**
 * MergeSort
 *
 * @program: 归并排序
 * @description:
 * @author: qianhao
 * @create: 2019-12-23 10:43
 */
public class MergeSort {

    public static Integer[] mergeSort(Integer[] param) {
        if (param == null || param.length <= 1) {
            return param;
        }

        helper(0, param.length - 1, param);
        return param;
    }

    private static void helper(Integer start, Integer end, Integer[] param) {
        if (end <= start) {
            return;
        }

        int k = param[start];
        Integer middle = start;
        for (int i = middle + 1; i <= end; i++) {
            if (param[i] < k) {
                int temp = param[i];
                param[i] = param[middle];
                param[middle] = temp;

                middle++;
                temp = param[i];
                param[i] = param[middle];
                param[middle] = temp;
            }
        }

        if (middle - 1 > start) {
            helper(start, middle - 1, param);
        }

        if (end > middle + 1) {
            helper(middle + 1, end, param);
        }
    }

    public static void main(String[] args) {
        Integer[] result = mergeSort(new Integer[] { 1, 3, 4, 5, 6, 32, 1, 132, 0, 132, 131,132 });
        for (Integer i = 0; i < result.length; i++) {
            System.out.println(String.join(",", i.toString(), result[i].toString()));
        }
    }
}