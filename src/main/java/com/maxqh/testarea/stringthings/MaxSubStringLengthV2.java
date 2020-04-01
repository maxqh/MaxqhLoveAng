package com.maxqh.testarea.stringthings;

import java.util.HashMap;
import java.util.Map;

/**
 * MaxSubStringLength
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-12-30 10:47
 */
public class MaxSubStringLengthV2 {

    /**
     * 执行结果： 通过 显示详情 执行用时 : 8 ms , 在所有 java 提交中击败了 82.26% 的用户 内存消耗 : 36.4 MB , 在所有
     * java 提交中击败了 97.70% 的用户
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

        Map<Character, Integer> subStringMap = new HashMap<>(param.length());

        int maxLength = 0;

        int i = 0;
        int j = 0;

        while ((i < param.length()) && (j < param.length())) {
            Integer index = subStringMap.get(param.charAt(j));
            if (index != null && index < j && (i <= index)) {
                maxLength = Math.max(maxLength, (j - i));
                subStringMap.put(param.charAt(j), j);
                i = index + 1;
                System.out.println("i=" + i + ",j=" + j + ",maxLength=" + maxLength);

                j = j + 1;
                continue;
            }

            maxLength = Math.max(maxLength, (j - i + 1));
            subStringMap.put(param.charAt(j), j++);

            System.out.println("i=" + i + ",j=" + j);
        }

        return maxLength;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(maxSubStringLength("tmmzuxt"));
    }

    public int maxqh(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}