package com.maxqh.testarea.stringthings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * MaxSubStringLength
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-12-30 10:47
 */
public class MaxSubStringLength {
    /**
     * 执行结果： 通过 显示详情 执行用时 : 11 ms
     * 
     * 在所有 java 提交中击败了 71.46% 的用户 内存消耗 : 38 MB , 在所有 java 提交中击败了 89.93% 的用户
     * 
     * @param param
     * @return
     * @throws Exception
     */
    public static int maxSubStringLength(String param) throws Exception {
        if (param == null) {
            return 0;
        }

        if (param.length() == 1) {
            return 1;
        }

        String[] stringArray = charArray2StringArray(param.toCharArray());

        Map<String, Integer> subStringMap = new HashMap<>(stringArray.length);
        LinkedList<String> subStringList = new LinkedList<>();

        Boolean isDuplicate = null;
        Integer maxLength = 0;

        for (int i = 0; i < stringArray.length; i++) {
            isDuplicate = Boolean.FALSE;
            for (int j = i; j < stringArray.length; j++) {
                subStringList.addLast(stringArray[j]);

                if (subStringMap.containsKey(stringArray[j])) {
                    isDuplicate = Boolean.TRUE;
                } else {
                    subStringMap.put(stringArray[j], j);
                }

                if (isDuplicate) {
                    String preItem = subStringList.removeFirst();
                    if (subStringList.size() > maxLength) {
                        maxLength = subStringList.size();
                    }

                    while (!stringArray[j].equals(preItem)) {
                        subStringMap.remove(preItem);
                        preItem = subStringList.removeFirst();
                    }

                    i = j;
                    break;
                }

                i = j;
            }

            if (subStringList.size() > maxLength) {
                maxLength = subStringList.size();
            }
        }

        return maxLength;
    }

    public static String[] charArray2StringArray(char[] charArray) throws Exception {
        String[] stringArray = new String[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < 'a' || charArray[i] > 'z') {
                throw new Exception("异常的输入");
            }

            stringArray[i] = String.valueOf(charArray[i]);
        }

        return stringArray;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(maxSubStringLength("dvdf"));
    }
}