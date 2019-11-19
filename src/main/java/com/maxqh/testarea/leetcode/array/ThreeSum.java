package com.maxqh.testarea.leetcode.array;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * 找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-18 10:10
 */

public class ThreeSum {
    /**
     * 执行用时 : 422 ms , 在所有 java 提交中击败了 6.00% 的用户 内存消耗 : 51.2 MB , 在所有 java 提交中击败了
     * 81.68% 的用户
     * 
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (Integer item : nums) {
            if (map.containsKey(item)) {
                map.put(item, (map.get(item) + 1));
            } else {
                map.put(item, 1);
            }
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Integer a = iterator.next();

            decrease(map, a, iterator);

            HashMap<Integer, Integer> subMap = (HashMap<Integer, Integer>) map.clone();

            Iterator<Integer> subIterator = subMap.keySet().iterator();
            while (subIterator.hasNext()) {
                Integer b = subIterator.next();
                decrease(subMap, b, subIterator);

                Integer c = 0 - a - b;
                if (subMap.containsKey(c)) {
                    ArrayList<Integer> aa = new ArrayList<Integer>();
                    aa.add(a);
                    aa.add(b);
                    aa.add(c);

                    if (subMap.containsKey(b)) {
                        subIterator.remove();
                    }

                    result.add(aa);
                }
            }

            if (map.containsKey(a)) {
                iterator.remove();
            }
        }

        return result;
    }

    private static Boolean decrease(HashMap<Integer, Integer> map, Integer key, Iterator<Integer> subIterator) {
        if (!map.containsKey(key)) {
            return Boolean.FALSE;
        }

        Integer value = map.get(key);
        if (value <= 1) {
            subIterator.remove();
        } else {
            map.put(key, (map.get(key) - 1));
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[] { 259111, 0, 1, 2, -1, -1 });
        for (List item : result) {
            System.out.println(item.get(0) + "," + item.get(1) + "," + item.get(2) + ",");
        }
    }
}