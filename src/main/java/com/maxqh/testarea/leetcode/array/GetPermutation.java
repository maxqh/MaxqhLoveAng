package com.maxqh.testarea.leetcode.array;

import java.util.*;

/**
 * 第k个排列 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * "123" "132" "213" "231" "312" "321" 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 给定 n 的范围是 [1, 9]。 给定 k 的范围是[1, n!]。 示例 1:
 * 
 * 输入: n = 3, k = 3 输出: "213" 示例 2:
 * 
 * 输入: n = 4, k = 9 输出: "2314"
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-17 10:35
 */
public class GetPermutation {
    /**
     * 状态：超出时间限制
     提交时间：0 分钟之前
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int capacity = 1;
        for (int i = n; i > 0; i--) {
            capacity *= i;
            sb.append(i);
        }
        char[] c = sb.toString().toCharArray();
        List<String> list = new ArrayList<>(capacity);

        System.out.println(capacity);

        f(c, 0, list);
        // 大顶堆
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (String item : list) {
            if (minHeap.size() < k) {
                minHeap.add(item);
            } else {
                if (minHeap.peek().compareTo(item) > 0) {
                    minHeap.poll();
                    minHeap.add(item);
                }
            }
        }

        return minHeap.peek();
    }

    private static void f(char[] c, int k, List<String> result) {
        // 注意: 程序的出口由for循环控制
        for (int i = k; i < c.length; i++) {
            char temp = c[k];
            c[k] = c[i];
            c[i] = temp;

            f(c, k + 1, result);// 递归调用

            // 回溯
            // 交换完之后一定要换回原始数据，否则后边的交换就会变乱
            temp = c[k];
            c[k] = c[i];
            c[i] = temp;

        }

        // 输出
        if (k == c.length) {// 换完一轮之后打印结果
            result.add(new String(c));
        }
    }

    public String getPermutationVoilence(int n, int k) {
        return null;
    }

    public String getPermutationOptimize(int n, int k) {
        // todo Optimize
        return null;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(getPermutation(3, 3));
        long end = System.currentTimeMillis();

        System.out.println("cost:" + (end - start) + " ms");
    }

}
