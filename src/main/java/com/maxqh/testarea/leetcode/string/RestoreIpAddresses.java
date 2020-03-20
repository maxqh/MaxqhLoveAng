package com.maxqh.testarea.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135" 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-03-20 07:35
 */
public class RestoreIpAddresses {
    /**
     * 击败97.79%
     *
     * 执行用时：3 ms 内存消耗：38.4 MB
     * 
     * @param param
     * @return
     */
    public static List<String> restoreIpAddressesVoilence(String param) {
        int length = param.length();
        if (length < 4) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();

        String[] resultTemp = new String[4];
        for (int i = 1; (i < 4 && (length -i) >= 3); i++) {
            for (int j = 1; j < 4 && (length -i -j) >= 2; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int m = 1; m < 4; m++) {
                        if ((i + j + k + m) == length) {

                            resultTemp[0] = param.substring(0, i);
                            resultTemp[1] = param.substring(i, i + j);
                            resultTemp[2] = param.substring(i + j, i + j + k);
                            resultTemp[3] = param.substring(i + j + k, i + j + k + m);

                            Boolean isCheckFail = Boolean.FALSE;

                            for (String item : resultTemp) {
                                if (item.length() > 1 && item.startsWith("0")) {
                                    isCheckFail = Boolean.TRUE;
                                    break;
                                }

                                if (Integer.valueOf(item) > 255) {
                                    isCheckFail = Boolean.TRUE;
                                    break;
                                }
                            }

                            if (isCheckFail) {
                                continue;
                            }

                            StringBuilder sb = new StringBuilder();
                            sb.append(resultTemp[0]).append(".").append(resultTemp[1]).append(".").append(resultTemp[2])
                                    .append(".").append(resultTemp[3]);
                            result.add(sb.toString());
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void  main(String[] args) {
        //String param = "25525511135";
        // String param = "192168012";
        //String param = "010010";
        String param = "0000";
        List<String> result = restoreIpAddressesVoilence(param);

        result.stream().forEach(item -> System.out.println(item));
    }
}