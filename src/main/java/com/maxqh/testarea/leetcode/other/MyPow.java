package com.maxqh.testarea.leetcode.other;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10 输出: 1024.00000 示例 2:
 * 
 * 输入: 2.10000, 3 输出: 9.26100 示例 3:
 * 
 * 输入: 2.00000, -2 输出: 0.25000 解释: 2-2 = 1/22 = 1/4 = 0.25 说明:
 * 
 * -100.0 < x < 100.0 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-20 15:47
 */
public class MyPow {

    /**
     * 执行结果： 通过 显示详情 执行用时 : 1 ms , 在所有 java 提交中击败了 99.95% 的用户 内存消耗 : 33.4 MB , 在所有
     * java 提交中击败了 75.10% 的用户
     * 
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n == -1) {
            return 1 / x;
        }

        if (n % 2 == 0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        }

        return x * myPow(x, n - 1);
    }
}