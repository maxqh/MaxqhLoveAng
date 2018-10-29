package com.maxqh.testarea.leetcode.danamic;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/29
 * @Version:1.0
 */
public class NumTrees {

    /*
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * 
     * 示例:
     * 
     * 输入: 3 输出: 5 解释: 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     * 
     * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
     */

    /*
     * 执行用时: 0 ms, 在Unique Binary Search Trees的Java提交中击败了100.00% 的用户
     */

    public static int numTrees(int n) {
        int[] resultArray = new int[n + 1];
        resultArray[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                resultArray[1] = 1;
                continue;
            }

            resultArray[i] = 0;
            for (int j = 0; j < i; j++) {
                resultArray[i] = resultArray[i] + resultArray[j] * resultArray[i - j - 1];
            }
        }

        return resultArray[n];
    }

    public static void main(String[] args) {
        numTrees(3);
    }
}
