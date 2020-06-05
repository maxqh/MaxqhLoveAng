package com.maxqh.testarea.utils;

import java.util.regex.Pattern;

/**
 * Unicode工具类
 *
 * @program: maxqh
 * @description:
 * @author: sh
 * @create: 2020-06-05 17:36
 */
public class UicodeUtil {
    // 单个字符的正则表达式
    private static final String singlePattern = "[0-9|a-f|A-F]";
    // 4个字符的正则表达式
    private static final String pattern = singlePattern + singlePattern +
            singlePattern + singlePattern;

    public static void main(String[] args) {
        String bb = new String("{\"result\":1,\"response\":{\"data\":{\"version\":\"20200603\",\"result\":1,\"timestamp\":1591348282,\"message\":\"success\",\"id\":\"8e3f112909866da88482370c91c6e417\",\"sha1\":\"981b19db817bee1eeeb9a01288d7b37775f797f0\",\"time_cost\":\"666\",\"identify_results\":[{\"type\":\"10102\",\"orientation\":0,\"details\":{\"code\":\"041001800111\",\"number\":\"75844375\",\"date\":\"2020\\u5e7405\\u670810\\u65e5\",\"pretax_amount\":\"427.00\",\"tax\":\"\",\"check_code\":\"16213332723873534060\",\"total\":\"427.00\",\"seller\":\"\\u5df4\\u5974\\u6bdb\\u809a\\u706b\\u9505\\u6709\\u9650\\u516c\\u53f8\",\"seller_tax_id\":\"91410105MA3X5ANA56\",\"buyer\":\"\\u90d1\\u5dde\\u5b87\\u901a\\u5ba2\\u8f66\\u80a1\\u4efd\\u6709\\u9650\\u516c\\u53f8\",\"buyer_tax_id\":\"91410000170001401D\",\"company_seal\":\"1\",\"form_type\":\"\",\"kind\":\"\\u9910\\u996e\",\"ciphertext\":\"03>0+3*7-63378345++9-4706187,<\\/569-<55>215++>3>1*35\\/6570+,25195233-73221>8<3806\\/0>8-00,<592433\\/8\\/011>2119936*737+3*\",\"machine_code\":\"499099830800\",\"receiptor\":\":\\u5f20\\u4e9a\\u8339\",\"reviewer\":\"\\u90ed\\u7389\\u7fe0\",\"issuer\":\"\\u5434\\u4ee5\\u541b\",\"province\":\"\\u6cb3\\u5357\\u7701\",\"city\":\"\",\"service_name\":\"\\u9910\\u996e\\u670d\\u52a1\",\"remark\":\",\\u6d41\\u6c34\\u53f7:zAb5MK31GPgj 2dE2245;\",\"item_names\":\"*\\u9910\\u996e\\u670d\\u52a1*\\u9910\\u996e\\u670d\\u52a1\"},\"extra\":{\"check_code_candidates\":[],\"check_code_last_six\":[],\"number_order_error\":[],\"qrcode\":[\"01,10,041001800111,75844375,427.00,20200510,16213332723873534060,C488\"]}}]}}}");

        System.out.println(unicodeToCn(bb));
    }

    /**
     * 字符串中，所有以 \\u 开头的UNICODE字符串，全部替换成汉字
     * @param str
     * @return
     */
    public static String unicodeToCn(final String str) {
        // 用于构建新的字符串
        StringBuilder sb = new StringBuilder();
        // 从左向右扫描字符串。tmpStr是还没有被扫描的剩余字符串。
        // 下面有两个判断分支：
        // 1. 如果剩余字符串是Unicode字符开头，就把Unicode转换成汉字，加到StringBuilder中。然后跳过这个Unicode字符。
        // 2.反之， 如果剩余字符串不是Unicode字符开头，把普通字符加入StringBuilder，向右跳过1.
        int length = str.length();
        for (int i = 0; i < length;) {
            String tmpStr = str.substring(i);
            if (isStartWithUnicode(tmpStr)) { // 分支1
                sb.append(ustartToCn(tmpStr));
                i += 6;
            } else { // 分支2
                sb.append(str.substring(i, i + 1));
                i++;
            }
        }
        return sb.toString();
    }

    /**
     * 把 \\u 开头的单字转成汉字，如 \\u6B65 ->　步
     * @param str
     * @return
     */
    private static String ustartToCn(final String str) {
        StringBuilder sb = new StringBuilder().append("0x")
                .append(str.substring(2, 6));
        Integer codeInteger = Integer.decode(sb.toString());
        int code = codeInteger.intValue();
        char c = (char)code;
        return String.valueOf(c);
    }

    /**
     * 字符串是否以Unicode字符开头。约定Unicode字符以 \\u开头。
     * @param str 字符串
     * @return true表示以Unicode字符开头.
     */
    private static boolean isStartWithUnicode(final String str) {
        if (null == str || str.length() == 0) {
            return false;
        }
        if (!str.startsWith("\\u")) {
            return false;
        }
        // \u6B65
        if (str.length() < 6) {
            return false;
        }
        String content = str.substring(2, 6);

        boolean isMatch = Pattern.matches(pattern, content);
        return isMatch;
    }
}