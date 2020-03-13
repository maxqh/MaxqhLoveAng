package com.maxqh.testarea.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 
 * 示例1:
 * 
 * 输入: s1 = "ab" s2 = "eidbaooo" 输出: True 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-03-13 14:46
 */
public class CheckInclusion {

    /**
     * 通过 打败了noone
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return Boolean.FALSE;
        }

        Map<Character, Integer> subStrMap = new HashMap<>(s1.length());
        for (char item : s1.toCharArray()) {
            if (subStrMap.containsKey(item)) {
                subStrMap.put(item, subStrMap.get(item) + 1);
            } else {
                subStrMap.put(item, 1);
            }
        }

        int k = s2.length() - s1.length();
        for (int i = 0; i <= k; i++) {
            if (diff(s2.toCharArray(), i, subStrMap, s1.length())) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    public static Boolean diff(char[] charArray, int i, Map<Character, Integer> subStrMap, int length) {
        Map<Character, Integer> tempMap = new HashMap<>();
        subStrMap.keySet().forEach(item -> tempMap.put(item, subStrMap.get(item)));

        Integer index = i;

        while (length + i > index) {
            Integer number = tempMap.get(charArray[index]);
            if (number == null || number == 0) {
                return Boolean.FALSE;
            } else {
                number = number - 1;

                if (number > 0) {
                    tempMap.put(charArray[index++], number);
                } else {
                    tempMap.remove(charArray[index++]);
                }
            }
        }

        if (tempMap.size() == 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}