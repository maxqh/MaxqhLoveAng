package com.maxqh.testarea.leetcode.danamic;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/11/20
 * @Version:1.0
 */
public class CountSubstrings {
    /*
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
     * 
     * 示例 1:
     * 
     * 输入: "abc" 输出: 3 解释: 三个回文子串: "a", "b", "c". 示例 2:
     * 
     * 输入: "aaa" 输出: 6 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa". 注意:
     * 
     * 输入的字符串长度不会超过1000。
     */

    /*
     * 成功 显示详情 执行用时: 14 ms, 在Palindromic Substrings的Java提交中击败了76.18% 的用户
     */
    public static int countSubstrings(String s) {
        int total = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int temp = 1;
            while ((i - temp) >= 0 && (i + temp) < charArray.length && charArray[i - temp] == charArray[i + temp]) {
                temp++;
                total++;
            }

            temp = 0;
            while ((i - temp) >= 0 && (i + temp + 1) < charArray.length
                    && charArray[i - temp] == charArray[i + temp + 1]) {
                temp++;
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        countSubstrings("aaaa");
    }
}
