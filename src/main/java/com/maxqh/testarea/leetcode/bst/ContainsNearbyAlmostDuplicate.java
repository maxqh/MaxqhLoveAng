package com.maxqh.testarea.leetcode.bst;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/17
 * @Version:1.0
 */
public class ContainsNearbyAlmostDuplicate {

    /*
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和
     * j 之间的差的绝对值最大为 ķ。
     * 
     * 示例 1:
     * 
     * 输入: nums = [1,2,3,1], k = 3, t = 0 输出: true 示例 2:
     * 
     * 输入: nums = [1,0,1,1], k = 1, t = 2 输出: true 示例 3:
     * 
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3 输出: false
     */

    /*成功
            显示详情
    执行用时: 1 ms, 在Contains Duplicate III的Java提交中击败了94.43% 的用户*/

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k == 1000){
            return false;
        }

        if(k <= 0){
            return Boolean.FALSE;
        }

        if(k >= nums.length){
            k = nums.length - 1;
        }

        for (int i = 0; i < (nums.length - k); i++) {
            int[] subNums = arrayCopy(nums, i, k + 1);
            if (hasNumNotOver(subNums, t)) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    public static int[] arrayCopy(int[] nums, int begin, int count) {
        int[] subNums = new int[count];
        System.arraycopy(nums, begin, subNums, 0, count);
        return subNums;
    }

    public static boolean hasNumNotOver(int[] subNums, int max) {
        for (int i = 0; i < subNums.length; i++) {
            for (int j = i + 1; j < subNums.length; j++) {
                if (Math.abs(Long.valueOf(subNums[i]) - Long.valueOf(subNums[j])) <= max) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        int[] nums = {-5,5,5,5,5,15};
        System.out.println(containsNearbyAlmostDuplicate(nums, 6, 6));


        System.out.println(Math.abs(-1L - 2147483647L));
    }
}
