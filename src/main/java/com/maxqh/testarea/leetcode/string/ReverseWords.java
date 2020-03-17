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
public class ReverseWords {
    public static Character SPACE = ' ';

    /**
     * 通过
     *
     * 击败了9.4%
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        s = s.trim();
        if (s == null || s.length() < 1) {
            return "";
        }

        return resolver(s.toCharArray(), s.length() - 1);
    }

    private static String resolver(char[] paramArray, int index) {
        if (index < 0) {
            return "";
        }

        StringBuffer result = new StringBuffer();

        while (index >= 0) {
            if (SPACE.equals(paramArray[index])) {
                if (result.length() < 1){
                    result = new StringBuffer();
                    result.append(resolver(paramArray, --index));
                    return result.toString();
                }

                result.reverse();
                result.append(SPACE);
                result.append(resolver(paramArray, index));
                return result.toString();
            }

            result.append(paramArray[index--]);
        }

        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        String param = "   a   b ";
        System.out.println(reverseWords(param));
    }
}