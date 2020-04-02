package com.maxqh.testarea.leetcode.array;

/**
 * 
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,4,7] 输出: 3 解释: 最长连续递增序列是 [1,3,5], 长度为3。 尽管 [1,3,5,7] 也是升序的子序列,
 * 但它不是连续的，因为5和7在原数组里被4隔开。 示例 2:
 * 
 * 输入: [2,2,2,2,2] 输出: 1 解释: 最长连续递增序列是 [2], 长度为1。 注意：数组长度不会超过10000。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-02 10:36
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        return 0;
    }

    public static int findLengthOfLCISVoilence(int[] nums) {
        if (nums == null || nums.length <= 1){
            return 0;
        }

        int result = 0;

        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                temp ++;
            } else {
                result = Math.max(result, temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] param = {1,3,5,4,7};
        System.out.println(findLengthOfLCISVoilence(param));
    }
}