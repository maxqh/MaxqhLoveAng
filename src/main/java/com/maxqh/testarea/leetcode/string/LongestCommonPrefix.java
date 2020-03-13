package com.maxqh.testarea.leetcode.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl"
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-03-11 07:51
 */
public class LongestCommonPrefix {
    /**
     *
     * 118 / 118 个通过测试用例 状态：通过 执行用时：2 ms 内存消耗：38.8 MB
     *
     * 战胜37.88%
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }

        if (strs == null || strs.length <= 0) {
            return "";
        }

        String commonPrefix = "";

        commonPrefix = commonPrefixResovler(strs, 0, strs.length - 1);

        return commonPrefix;
    }

    private static String commonPrefixResovler(String[] strs, int start, int end) {
        int minus = end - start;

        if (minus == 0) {
            return strs[start];
        }

        if (minus == 1) {
            return commonPrefixResovler(strs[start], strs[end]);
        }

        String a = commonPrefixResovler(strs, start, start + (minus + 1) / 2);
        String b = commonPrefixResovler(strs, start + minus / 2 + 1, end);

        return commonPrefixResovler(a, b);
    }

    /**
     * 暴力法 通过 战胜了noone
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefixViolence(String[] strs) {
        //
        return null;
    }

    private static String commonPrefixResovler(String str1, String str2) {
        if (str2 == null || str1 == null) {
            return str1 == null ? str2 : str1;
        }

        StringBuffer sb = new StringBuffer();
        int lim = Math.min(str1.length(), str2.length());
        char[] oldArray = str1.toCharArray();
        char[] newArray = str2.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = oldArray[k];
            char c2 = newArray[k];
            if (c1 != c2) {
                return sb.toString();
            }
            sb.append(c1);
            k++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] str = { "abc", "aba", "ab" };
        System.out.println(longestCommonPrefix(str));
        ;
    }
}