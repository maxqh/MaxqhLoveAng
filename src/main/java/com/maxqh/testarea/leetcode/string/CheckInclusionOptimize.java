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
public class CheckInclusionOptimize {

    /**
     *
     * 103 / 103 个通过测试用例 状态：通过 执行用时：6 ms 内存消耗：39 MB
     *
     * 击败了92.42%
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return Boolean.FALSE;
        }

        int[] s1Array = new int[26];
        int[] s2Array = new int[26];

        for (char item : s1.toCharArray()) {
            s1Array[item - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            s2Array[s2.charAt(i) - 'a']++;
        }

        if (diff(s1Array, s2Array)) {
            return Boolean.TRUE;
        }

        int i = s2.length() - s1.length();
        for (int index = 0; index < i; index++) {
            s2Array[(s2.charAt(index) - 'a')]--;
            s2Array[(s2.charAt(index + s1.length()) - 'a')]++;

            if (diff(s1Array, s2Array)) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    private static boolean diff(int[] s1Array, int[] s2Array) {
        for (int i = 0; i < s1Array.length; i++) {
            if ((s1Array[i] - s2Array[i]) != 0) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}