package com.maxqh.testarea.leetcode.danamic;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 示例 1:
 * 
 * 输入: 2 输出: [0,1,1] 示例 2:
 * 
 * 输入: 5 输出: [0,1,1,2,1,2] 进阶:
 * 
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-26 15:04
 */
public class countBits2 {
    /**
     * 执行结果： 通过 显示详情 执行用时 : 2 ms , 在所有 java 提交中击败了 87.65% 的用户 内存消耗 : 38.9 MB , 在所有
     * java 提交中击败了 86.14% 的用户
     * 
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        if (num >= 1) {
            dp[1] = 1;
        }

        for (int i = 2; i <= num; i++) {
            if ((i % 2) == 0) {
                dp[i] = dp[i >> 1];
            } else {
                dp[i] = dp[i >> 1] + 1;
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);
        System.out.println(5 >> 1);
    }
}