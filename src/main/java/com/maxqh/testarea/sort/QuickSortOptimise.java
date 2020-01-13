package com.maxqh.testarea.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * QuickSort
 *
 * @program: 快速排序
 * @description:
 * @author: qianhao
 * @create: 2019-12-23 10:43
 */
public class QuickSortOptimise {

    public List<Integer> quickSort(int[] param) {
        if (param == null) {
            return null;
        }

        if (param.length == 1) {
            return Arrays.stream(param).boxed().collect(Collectors.toList());
        }

        helper(0, param.length - 1, param);
        return Arrays.stream(param).boxed().collect(Collectors.toList());
    }



    private static void helper(Integer start, Integer end, int[] param) {
        int pivot = param[end];
        Integer middle = start;
        int temp;
        for (int i = start; i <= end; i++) {
            if (param[i] < pivot) {
                temp = param[i];
                param[i] = param[middle];
                param[middle] = temp;

                middle++;
            }
        }

        temp = param[middle];
        param[middle] = param[end];
        param[end] = temp;

        if (middle - 1 > start) {
            helper(start, middle - 1, param);
        }

        if (end > middle + 1) {
            helper(middle + 1, end, param);
        }
    }

    public static void main(String[] args) {
//        Integer[] result = quickSort(new Integer[] { 12, 3, 41, 5, 6, 2, 1, 132, 0, 132, 131,1232 });
//        for (Integer i = 0; i < result.length; i++) {
//            System.out.println(String.join(",", i.toString(), result[i].toString()));
//        }
    }
}