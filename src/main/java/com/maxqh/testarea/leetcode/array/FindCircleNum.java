package com.maxqh.testarea.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 朋友圈
 * 
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C
 * 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 
 * 示例 1:
 * 
 * 输入: [[1,1,0], [1,1,0], [0,0,1]] 输出: 2 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。 示例 2:
 * 
 * 输入: [[1,1,0], [1,1,1], [0,1,1]] 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。 注意：
 * 
 * N 在[1,200]的范围内。 对于所有学生，有M[i][i] = 1。 如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-17 15:49
 */
public class FindCircleNum {

    public static void main(String[] args) {
        // [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        int[][] param = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        // int[][] param = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1,
        // 1 } };

        System.out.println(findCircleNum(param));
    }

    /**
     * 错误的答案
     *
     * @param M
     * @return
     */
    public static int findCircleNumWrong(int[][] M) {
        if (M == null || M.length < 1) {
            return 0;
        }

        int colomn = M.length;
        HashMap<Integer, Set<Integer>> result = new HashMap<>(colomn);

        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(0);
        result.put(0, firstSet);

        for (int i = 0; i < colomn; i++) {
            Boolean isParent = Boolean.TRUE;
            Integer parent = null;
            for (int j = 0; j < colomn; j++) {
                if (M[i][j] == 1) {
                    if (j < i) {
                        if (isParent) {
                            parent = j;

                            Set<Integer> set = result.get(parent);
                            set.add(j);

                            isParent = Boolean.FALSE;
                        } else {
                            Set<Integer> set = result.get(parent);
                            set.add(j);
                        }
                    }

                    if (j == i && isParent) {
                        Set<Integer> set = new HashSet<>();
                        set.add(i);
                        result.put(i, set);
                    }

                    if (j > i) {
                        if (isParent) {
                            Set<Integer> set = result.get(i);
                            set.add(j);
                        } else {
                            Set<Integer> set = result.get(parent);
                            set.add(j);
                        }
                    }
                }
            }
        }

        return result.size();
    }

    /**
     * 通过 击败了99.9%
     *
     * 执行用时：1 ms 内存消耗：40.3 MB
     * 
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length < 1) {
            return 0;
        }

        int colomn = M.length;
        int result = 0;

        int[] visitArray = new int[colomn];
        for (int i = 0; i < colomn; i++) {
            if (visitArray[i] == 0) {
                result += 1;

                helper(visitArray, i, M);
            }
        }

        return result;
    }

    private static void helper(int[] visitArray, int i, int[][] m) {
        visitArray[i] = 1;

        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visitArray[j] == 0) {
                helper(visitArray, j, m);
            }
        }
    }

}