package com.maxqh.testarea.jsontest;

import com.alibaba.fastjson.JSON;
import com.maxqh.biz.dal.jsontest.ObjectBigOne;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/3/30
 * @Version:1.0
 */
public class JsonTest {
    public static void main(String[] args) {
        String jsonStr = "{\"status\":\"0\",\"message\":\"正确\",\n" +
                "\n" +
                "\n" +
                "\"result\":[{\n" +
                "\n" +
                "\"iccid\":\"898602B1031600067226\",\n" +
                "\n" +
                "\"prodinfos\":[{\n" +
                "\n" +
                "\"prodinstefftime\":\"2018-01-09 17:24:50\",\"prodinstexptime\":\"2099-12-31 23:59:59\",\"prodname\":\"专用机器卡（原子产品）\",\"prodid\":\"I00010300037\"},\n" +
                "\n" +
                "{\"prodinstefftime\":\"2018-01-09 17:24:50\",\"prodinstexptime\":\"2099-12-31 23:59:59\",\"prodname\":\"机器卡产品(产品包)\",\"prodid\":\"I00010100036\"},{\"prodinstefftime\":\"2018-01-09 17:24:50\",\"prodinstexptime\":\"2099-12-31 23:59:59\",\"prodname\":\"全国通用流量产品包（附加产品包)\",\"prodid\":\"I00010101001\"},\n" +
                "\n" +
                "{\"prodinstefftime\":\"2018-01-09 17:24:50\",\"prodinstexptime\":\"2099-12-31 23:59:59\",\"prodname\":\"全国通用流量5元套餐\",\"prodid\":\"I00010101104\"},{\"prodinstefftime\":\"2018-01-09 17:24:50\",\"prodinstexptime\":\"2099-12-31 23:59:59\",\"prodname\":\"机器卡主体产品（个人）\",\"prodid\":\"I00010100001\"},\n" +
                "\n" +
                "{\"prodinstefftime\":\"2018-01-09 17:24:50\",\"prodinstexptime\":\"2099-12-31 23:59:59\",\"prodname\":\"GPRS基础服务产品\",\"prodid\":\"I00010100035\"}],\"imsi\":\"460040122610226\",\"msisdn\":\"1064742101476\"}]}";

        ObjectBigOne obj = JSON.parseObject(jsonStr, ObjectBigOne.class);
        System.out.println(obj);
    }
}
