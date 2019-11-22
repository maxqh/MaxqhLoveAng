package com.maxqh.testarea.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-20 23:35
 */

public class MajorityElement {
    /**
     * 执行用时 : 18 ms , 在所有 java 提交中击败了 36.73% 的用户 内存消耗 : 40.7 MB , 在所有 java 提交中击败了
     * 88.57% 的用户
     * 
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer item : nums) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 1, 2, 2, 1, -1 }));
    }
}