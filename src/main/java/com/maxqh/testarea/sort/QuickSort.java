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
public class QuickSort {

    public static int[] quickSort(int[] param) {
        if (param == null || param.length <= 1) {
            return param;
        }

        helper(0, param.length - 1, param);
        return param;
    }

    public static void fastSort(int[] nums, int start, int end) {
        if (end <= start){
            return;
        }


        int index = start;
        if (nums[index] < nums[end]) {
            index++;
        }

        for (int i = index; i < end; i++) {
            if (nums[i] < nums[end]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;

                index++;
            }
        }

        if (index < end) {
            int temp = nums[end];
            nums[end] = nums[index];
            nums[index] = temp;
        }

        fastSort(nums, start, index - 1);
        fastSort(nums, index + 1, end);
    }

    /**
     * 执行用时 : 20 ms , 在所有 Java 提交中击败了 31.87% 的用户 内存消耗 : 44.3 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     * 
     * @param param
     * @return
     */
    public static List<Integer> maxqh(int[] param) {
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
        int[] result = quickSort(new int[] { 12, 3, 41, 5, 6, 2, 1, 132, 0, 132, 131, 1232 });
        for (Integer i = 0; i < result.length; i++) {
            System.out.println(String.join(",", i.toString(), String.valueOf(result[i])));
        }
    }
}