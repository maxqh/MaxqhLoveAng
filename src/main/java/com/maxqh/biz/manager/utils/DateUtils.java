package com.maxqh.biz.manager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

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
     * 一天 = 60 * 60 * 24 = 86400 秒
     */
    public static final Integer DAY_TO_SECONDS = 60 * 60 * 24;

    private static final SimpleDateFormat SHORT_DATEFORMAT = new SimpleDateFormat(yyyyMMdd);

    /**
     * 用yyyyMMdd来格式化日期
     *
     * @author qinying
     * @param d
     * @return String
     */
    public static String getYmdDateString(Date d) {
        return SHORT_DATEFORMAT.format(d);
    }

    /**
     * 计算两个日期比较
     *
     * @param date1
     * @param date2
     * @return Long
     */
    public static Long getDaysBetween(Date date1, Date date2) {
        Long d1 = date1.getTime() / 1000;
        Long d2 = date2.getTime() / 1000;
        return (d2 - d1) / DAY_TO_SECONDS;
    }

    public static Long getDaysFromNow(String dateStr) {
        Date minuend = getYmdStringToDate(dateStr);
        Date subtrahend = getYmdStringToDate(getYmdDate());
        return getDaysBetween(minuend, subtrahend);
    }

    /**
     * 用 yyyyMMdd 来格式化日期
     *
     * @param d
     * @return String
     * @author qinying
     */
    public static Date getYmdStringToDate(String d) {
        if (StringUtils.isEmpty(d)) {
            return null;
        }
        try {
            return SHORT_DATEFORMAT.parse(d);
        } catch (Exception e) {
            LOG.error("解析日期格式出错，d={}, exceptionInfo={}", d, e);
        }
        return null;
    }

    /**
     * yyyy-MM-dd 当前日期
     *
     */
    public static String getYmdDate() {
        return SHORT_DATEFORMAT.format(new Date());
    }
}
