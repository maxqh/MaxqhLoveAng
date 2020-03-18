package com.maxqh.testarea.leetcode.string;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: "the sky is blue" 输出: "blue is sky the" 示例 2：
 * 
 * 输入: " hello world! " 输出: "world! hello" 解释:
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 示例 3：
 * 
 * 输入: "a good example" 输出: "example good a" 解释:
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 说明：
 * 
 * 无空格字符构成一个单词。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-03-17 07:13
 */
public class ReverseWordsOptimize {
    public static Character SPACE = ' ';

    /**
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        s = s.trim();
        if (s.length() < 1) {
            return "";
        }

        StringBuffer result = new StringBuffer(s.length());

        int index = s.length() - 1;
        char[] paramArray = s.toCharArray();

        StringBuilder word = new StringBuilder();
        while (index >= 0) {
            if (SPACE.equals(paramArray[index])) {
                if (word.length() >= 1) {
                    word.reverse();
                    result.append(SPACE);
                    result.append(word);
                }

                index--;
                word = new StringBuilder();
            } else {
                word.append(paramArray[index--]);
            }
        }

        if (word.length() > 0) {
            result.append(SPACE).append(word.reverse());
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String param = "the sky is     blue";
        System.out.println(reverseWords(param));

        System.out.println(internet(param));
    }

    /**
     * 通过
     *
     * 击败了42%
     *
     * 执行用时：7 ms 内存消耗：41.4 MB
     * 
     * @param s
     * @return
     */
    public static String internet(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || "".equals(s.trim())) {
            return "";
        } else {
            String[] strs = s.trim().split("\\s+");
            int len = strs.length - 1;
            for (int i = len; i >= 0; i--) {
                if (i == 0) {
                    sb.append(strs[i]);
                } else {
                    sb.append(strs[i] + " ");
                }
            }
            return sb.toString();
        }
    }
}