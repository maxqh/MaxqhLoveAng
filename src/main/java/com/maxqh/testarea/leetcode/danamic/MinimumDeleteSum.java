package com.maxqh.testarea.leetcode.danamic;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/30
 * @Version:1.0
 */
public class MinimumDeleteSum {
    /*
     * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
     * 
     * 示例 1:
     * 
     * 输入: s1 = "sea", s2 = "eat" 输出: 231 解释: 在 "sea" 中删除 "s" 并将 "s"
     * 的值(115)加入总和。 在 "eat" 中删除 "t" 并将 116 加入总和。 结束时，两个字符串相等，115 + 116 = 231
     * 就是符合条件的最小和。 示例 2:
     * 
     * 输入: s1 = "delete", s2 = "leet" 输出: 403 解释: 在 "delete" 中删除 "dee" 字符串变成
     * "let"， 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
     * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。 如果改为将两个字符串转换为 "lee" 或
     * "eet"，我们会得到 433 或 417 的结果，比答案更大。 注意:
     * 
     * 0 < s1.length, s2.length <= 1000。 所有字符串中的字符ASCII值在[97, 122]之间。
     */

    // 通过 击败了98%的选手
    public static int minimumDeleteSum(String s1, String s2) {
        char[] charArrayS1 = s1.toCharArray();
        char[] charArrayS2 = s2.toCharArray();
        int[][] dp = new int[charArrayS1.length + 1][charArrayS2.length + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= charArrayS1.length; i++) {
            dp[i][0] = dp[i - 1][0] + charArrayS1[i - 1];
        }

        for (int j = 1; j <= charArrayS2.length; j++) {
            dp[0][j] = dp[0][j - 1] + charArrayS2[j - 1];
        }

        for (int i = 1; i <= charArrayS1.length; i++) {
            for (int j = 1; j <= charArrayS2.length; j++) {
                if (charArrayS1[i - 1] == charArrayS2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + charArrayS1[i - 1], dp[i][j - 1] + charArrayS2[j - 1],
                            dp[i - 1][j - 1] + charArrayS1[i - 1] + charArrayS2[j - 1]);
                }
            }
        }

        return dp[charArrayS1.length][charArrayS2.length];
    }

    public static int min(int x, int y, int z) {
        int min = (x < y) ? x : y;
        min = (z < min) ? z : min;
        return min;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "at";
        System.out.println(minimumDeleteSum(s1, s2));
    }
}
