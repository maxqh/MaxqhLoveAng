package com.maxqh.testarea.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/16
 * @Version:1.0
 */
public class ShitouYuBaoshi {
    /*
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S
     * 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * 
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * 
     * 示例 1:
     * 
     * 输入: J = "aA", S = "aAAbbbb" 输出: 3 示例 2:
     * 
     * 输入: J = "z", S = "ZZ" 输出: 0 注意:
     * 
     * S 和 J 最多含有50个字母。 J 中的字符不重复。
     */

    public int numJewelsInStones(String J, String S) {
        /*
        成功
                显示详情
        执行用时: 23 ms, 在Jewels and Stones的Java提交中击败了41.95% 的用户
        */
        Map<String, Integer> sMap = new HashMap<>(S.length());
        for (int i = 0; i < S.length(); i++) {
            if (sMap.containsKey(String.valueOf(S.charAt(i)))) {
                Integer value = sMap.get(String.valueOf(S.charAt(i)));
                sMap.put(String.valueOf(S.charAt(i)), ++value);
            } else {
                sMap.put(String.valueOf(S.charAt(i)), 1);
            }
        }

        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            Integer value = sMap.get(String.valueOf(J.charAt(i)));
            if (value != null && value > 0) {
                result += value;
            }
        }
        return result;
    }
}
