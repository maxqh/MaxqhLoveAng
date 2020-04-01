package com.maxqh.testarea.leetcode.array;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-01 17:51
 */
public class Search {
    /**
     * 196 / 196 个通过测试用例 状态：通过 执行用时：0 ms 内存消耗：39.5 MB
     * 
     * 击败了100%的用户
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        return resolver(nums, 0, nums.length - 1, target);
    }

    private int resolver(int[] nums, int start, int end, int target) {
        int size = end - start;
        if (size <= 1) {
            for (int i = start; i <= end; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }

            return -1;
        }

        int middle = start + size / 2 + 1;

        if (nums[end] > nums[start]) {
            // 连续递增数组
            if (target < nums[start] || target > nums[end]) {
                return -1;
            }

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] > target) {
                return resolver(nums, start, middle - 1, target);
            } else {
                return resolver(nums, middle, end, target);
            }
        }

        int result = resolver(nums, start, middle - 1, target);
        if (result > -1) {
            return result;
        }

        result = resolver(nums, middle, end, target);

        return result;

    }

    public int searchVoilence(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}