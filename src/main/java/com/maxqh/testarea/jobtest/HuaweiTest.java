package com.maxqh.testarea.jobtest;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 题目描述：小明负责公司年会，想出一个趣味游戏：屏幕给出1~9中任意3个不重复的数字，大家以最快时间给出这几个数字可拼成的数字从小到大排列位于第N位置的数字，
 * 其中N为给出的数字中最大的（如果不到这么多个数字则给出最后一个即可），谁最快给出谁得奖。 注意：
 * （1）屏幕如果给出的是“2”，大家可把它当作“2”，也可把它当作“5”来拼接数字；同理，如果屏幕给的是“5”，大家可把它当作“5”，也可以把它当作“2”来拼接数字，但屏幕不能同时给出“2”和“5”。
 * （2）屏幕如果给出的是“6”，大家可把它当作“6”，也可把它当作“9”来拼接数字；同理，如果屏幕给的是“9”，大家可把它当作“9”，也可以把它当作“6”来拼接数字，但屏幕不能同时给出“6”和“9”。
 * 现在需要编写一个小程序，根据给出的数字计算出能组合的所有2数字以及最终的正确答案。 如：给出：1，4，8，则可以拼成的数字为：
 * 1，4，8，14，18，41，48，81，84，148，184，418，481，814，841 那么最第N（即8）个的数字为81.
 * 输入描述：以逗号为分隔，描述3个int类型整数的字符串。
 * 输出描述：这几个数字可拼成的数字从小到大排列位于第N（N为输入数字中最大的数字）位置的数字，如果输入的数字为负数或者不是合法的字符串或者有重复，返回-1。
 * 输入例子：1，4，8 输出例子：81
 * 
 * @Author:qianhao
 * @Description: 华为试题
 * @Date:2018/5/3
 * @Version:1.0
 */
public class HuaweiTest {
    private static Integer ZERO = 0;

    private static Integer TWO = 2;

    private static Integer FIVE = 5;

    private static Integer SIX = 6;

    private static Integer NINE = 9;

    private static Integer MAX_NUM = 9;

    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        Set<Integer> nums = new HashSet<>();
        // 从1-9中随机取数
        for (int i = 3; i > 0; i--) {
            Integer newNum = sr.nextInt(MAX_NUM);
            while (newNum == ZERO || !nums.add(newNum)) {
                newNum = sr.nextInt(MAX_NUM);
            }

            if (newNum.equals(TWO)) {
                nums.add(FIVE);
            }

            if (newNum.equals(FIVE)) {
                nums.add(TWO);
            }

            if (newNum.equals(SIX)) {
                nums.add(NINE);
            }

            if (newNum.equals(NINE)) {
                nums.add(SIX);
            }
        }

        ArrayList<Integer> increseList = new ArrayList<>(nums.size());
        Iterator<Integer> iterable = nums.iterator();
        while (iterable.hasNext()) {
            increseList.add(iterable.next());
        }

        // 将数组排序 构造递增数组
        Collections.sort(increseList);

        int length = increseList.size();
        int maxNum = increseList.get(length - 1);

        int totalNum = 0;

        int resultSize = 0;

        for (int i = 1; i < length; i++) {
            totalNum += algorithm(length, i);
            if (totalNum >= maxNum && resultSize == 0) {
                resultSize = i;
            }
        }

        if (maxNum >= totalNum) {
            // 若数字最大值比排列组合数大，则返回最后一个数
            int reslult = 0;
            for (int i = length; i > 0; i--) {
                reslult += Math.pow(10, i - 1) * increseList.get(i - 1);
            }

            System.out.println(increseList.toString());
            System.out.println(reslult);
            return;
        } else {
            ArrayList resultList = getListByNumSize(resultSize, increseList);
            Collections.sort(resultList);
            System.out.println(increseList);
            System.out.println(resultList.toString());
            System.out.println(resultList.get(maxNum - 1));
        }

    }

    /**
     * 计算排列组合的组合数
     *
     * @param n 元素的总个数
     * @param m 参与选择的元素个数
     * @return
     */
    public static Integer algorithm(Integer n, Integer m) {
        if (n == null || m == null || m > n || m < 0 || n < 1) {
            return null;
        }

        Integer div = 1;
        Integer dived = 1;
        for (int i = n; i > 0; i--) {
            div *= i;
        }

        for (int i = (n - m); i > 0; i--) {
            dived *= i;
        }

        return div / dived;
    }

    /**
     * 返回包含target的全排列数组
     *
     * @param numberSize 最大参与排列的元素个数
     * @param increseList 原元素list
     */
    private static ArrayList<Integer> getListByNumSize(int numberSize, ArrayList<Integer> increseList) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 1; i <= numberSize; i++) {
            maxqh(increseList, resultList, i);
        }

        return resultList;
    }

    /**
     * 从n个数中取m
     *
     * @param sourceList
     * @param resultList
     * @param size
     */
    private static void maxqh(ArrayList<Integer> sourceList, ArrayList<Integer> resultList, int size) {
        if (size == 1) {
            for (int i = 0; i < sourceList.size(); i++) {
                resultList.add(sourceList.get(i));
            }
        }

        if (size == 2) {
            for (int i = 0; i < sourceList.size(); i++) {
                for (int j = 0; j < sourceList.size(); j++) {
                    if (i != j) {
                        resultList.add((int) Math.pow(10, 1) * sourceList.get(i) + sourceList.get(j));
                    }
                }
            }
        }
    }

}
