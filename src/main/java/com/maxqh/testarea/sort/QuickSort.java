package com.maxqh.testarea.sort;

/**
 * QuickSort
 *
 * @program: 快速排序
 * @description:
 * @author: qianhao
 * @create: 2019-12-23 10:43
 */
public class QuickSort {

    public static Integer[] quickSort(Integer[] param) {
        if (param == null || param.length <= 1) {
            return param;
        }

        helper(0, param.length - 1, param);
        return param;
    }

    private static void helper(Integer start, Integer end, Integer[] param) {
        int k = param[start];
        Integer middle = start;
        int temp;
        for (int i = middle + 1; i <= end; i++) {
            if (param[i] < k) {
                temp = param[i];
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
        Integer[] result = quickSort(new Integer[] { 12, 3, 41, 5, 6, 2, 1, 132, 0, 132, 131,1232 });
        for (Integer i = 0; i < result.length; i++) {
            System.out.println(String.join(",", i.toString(), result[i].toString()));
        }
    }
}