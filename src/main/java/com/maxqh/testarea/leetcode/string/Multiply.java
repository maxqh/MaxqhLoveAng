package com.maxqh.testarea.leetcode.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3" 输出: "6" 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456" 输出: "56088"
 * 
 * 
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-03-16 17:37
 */
public class Multiply {
    /**
     * 通过
     *
     * 击败了97.87%
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }

        return resolver(num1, num2);
    }

    private String resolver(String param1, String param2) {

        int[] resultArray = new int[param1.length() + param2.length()];

        char[] param1Array = param1.toCharArray();
        char[] param2Array = param2.toCharArray();


        for (int i = param1Array.length - 1; i >= 0; i--) {
            for (int j = param2Array.length - 1; j >= 0; j--) {
                Integer temp = (param1Array[i] - '0') * (param2Array[j] - '0');

                resultArray[ i+j+1] = resultArray[i+j+1] + temp;
            }
        }

        for (int i = resultArray.length - 1; i >= 0; i--) {
            if (resultArray[i] > 9) {
                Integer units = resultArray[i] % 10;
                Integer tens = resultArray[i] / 10;

                resultArray[i] = units;
                resultArray[i - 1] = resultArray[i - 1] + tens;
            }
        }

        StringBuffer sb = new StringBuffer(resultArray.length);

        Boolean zeroInit = Boolean.TRUE;
        for (Integer item : resultArray) {
            if (zeroInit) {
                if (item <= 0) {
                    continue;
                } else {
                    zeroInit = Boolean.FALSE;
                }
            }

            sb.append(item);

        }

        if (zeroInit) {
            // 初始化为零
            sb.append(0);
        }
        return sb.toString();
    }
}