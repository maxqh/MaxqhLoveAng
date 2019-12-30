package com.maxqh.testarea.stringthings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * MaxSubStringLength
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-12-30 10:47
 */
public class MaxSubStringLengthViolence {
    /**
     * 执行结果： 通过 显示详情 执行用时 : 235 ms , 在所有 java 提交中击败了 5.00% 的用户 内存消耗 : 39.4 MB , 在所有
     * java 提交中击败了 80.59% 的用户
     *
     * @param param
     * @return
     */
    public int lengthOfLongestSubstring(String param) {
        if (param == null) {
            return 0;
        }

        if (param.length() == 1) {
            return 1;
        }

        String[] stringArray = charArray2StringArray(param.toCharArray());

        Map<String, Integer> subStringMap = null;

        Integer maxLength = 0;

        for (int i = 0; i < stringArray.length; i++) {
            subStringMap = new HashMap<>(stringArray.length);
            for (int j = i; j < stringArray.length; j++) {
                if (subStringMap.containsKey(stringArray[j])) {

                    break;
                }

                subStringMap.put(stringArray[j], j);
            }
            maxLength = (maxLength < subStringMap.size()) ? subStringMap.size() : maxLength;
        }

        return maxLength;
    }

    public String[] charArray2StringArray(char[] charArray) {
        String[] stringArray = new String[charArray.length];

        for (int i = 0; i < charArray.length; i++) {

            stringArray[i] = String.valueOf(charArray[i]);
        }

        return stringArray;
    }
}