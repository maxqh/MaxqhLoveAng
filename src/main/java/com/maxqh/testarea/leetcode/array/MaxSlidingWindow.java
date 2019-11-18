package com.maxqh.testarea.leetcode.array;


import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-13 16:29
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k <= 0){
            return new int[]{};
        }

        LinkedList<Integer> window = new LinkedList<Integer>();
        int[] result = new int[(nums.length - k + 1)];

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                maxqh(nums[i], window);

                if (i + 1 == k) {
                    result[k - i - 1] = window.getFirst();
                }
            } else {

                if (window.size() >= k) {
                    window.removeFirst();

                    while (window.size() > 1){
                        Boolean isRevert = Boolean.FALSE;
                        Integer tempBigest = window.getFirst();
                        for (Integer item: window) {
                            if (tempBigest < item){
                                isRevert = Boolean.TRUE;
                                tempBigest = item;
                            }
                        }

                        if (isRevert == Boolean.TRUE){
                            while (window.getFirst() < tempBigest){
                                window.removeFirst();
                            }
                        } else {
                            break;
                        }
                    }
                }

                maxqh(nums[i], window);
                result[i - k + 1] = window.getFirst();
            }
        }

        return result;
    }

    private static void maxqh(int num, LinkedList<Integer> window) {
        if (window.isEmpty()) {
            window.addFirst(num);
        } else if (window.getFirst() <= num) {
            window.clear();
            window.addFirst(num);
        } else {
            window.addLast(num);
        }
    }

    public static void main(String[] args) {
        int[] aa = maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
        for (int item : aa) {
            System.out.println(item);
        }
    }
}
