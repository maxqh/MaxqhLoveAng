package com.maxqh.biz.manager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:qianhao
 * @Description: 时间工具类
 * @Date:2018/3/11
 * @Version:1.0
 */
public class DateUtils {
    private static final Logger LOG = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 年月日
     */
    public static final String yyyyMMdd = "yyyyMMdd";

    /**
     * 用yyyyMMdd来格式化日期
     *
     * @author qinying
     * @param d
     * @return String
     */
    public static String getYmdDateString(Date d) {
        SimpleDateFormat destsmf = new SimpleDateFormat(yyyyMMdd);
        return destsmf.format(d);
    }
}
