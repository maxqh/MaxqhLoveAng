package com.maxqh.testarea.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/16
 * @Version:1.0
 */
public class SumTwoNum {
    public int[] twoSum(int[] nums, int target) {
        /*
         * //解法一 暴力法 for(int n = 0; n < nums.length; n++){ for (int m=0; m <
         * nums.length; m ++){ if(m == n){ // 数不能重复使用 continue; }
         * 
         * if(nums[n] + nums[m] == target){ int[] result = new int[2]; result[0]
         * = nums[m]; result[1] = nums[n]; return result; } } } return null;
         */

        // 解法二 空间换时间
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            Integer value = numMap.get(sum);
            if (value != null && value != i) {
                int[] result = { i, value };
                return result;
            }
        }
        return null;
    }

}
