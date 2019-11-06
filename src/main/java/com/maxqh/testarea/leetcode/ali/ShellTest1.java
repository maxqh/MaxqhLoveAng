package com.maxqh.testarea.leetcode.ali;

import com.alibaba.fastjson.JSONObject;
import com.google.common.io.Files;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/10/17
 * @Version:1.0
 */
public class ShellTest1 {
    private final static Logger LOG = LoggerFactory.getLogger(ShellTest1.class);

    /*
     * 评测题目: shell脚本模拟
     * 
     * 请用编程的方式实现以下shell脚本的功能
     * cat/home/admin/logs/webx.log|grep"Login"|sort|uniq-c|sort- nr
     * 找出包含login的，去重， 排序 读文件的函数可以用guava或者apache FileUtils，也可以自己实现
     */

    public List<String> readLinesFromFile(String path) throws Exception {
        File file = new File(path);
        List<String> lines = Files.readLines(file, Charset.defaultCharset());
        return lines;
    }

    public void handle(String keyWord, int size, String path, String fileName) throws Exception {
        if (StringUtils.isBlank(keyWord)) {
            LOG.error("handle fail param null");
            return;
        }

        List<String> list = readLinesFromFile(path + fileName);
        Map<String, Integer> numMap = new HashMap<>();

        if (CollectionUtils.isEmpty(list)) {
            LOG.error("handle fail. list null");
            return;
        }

        for (String str : list) {
            if (StringUtils.isBlank(str)) {
                continue;
            }

            if (!str.contains(keyWord)) {
                continue;
            }

            if (numMap.containsKey(str)) {
                Integer old = numMap.get(str);
                numMap.put(str, ++old);
            } else {
                numMap.put(str, 1);
            }
        }

        List<JSONObject> reslult = new ArrayList<>(numMap.size());
        for (Map.Entry entry : numMap.entrySet()) {
            JSONObject strObj = new JSONObject();
            strObj.put("key", entry.getKey());
            strObj.put("value", entry.getValue());
            reslult.add(strObj);
        }

        reslult.sort(new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject o1, JSONObject o2) {
                Integer num1 = Integer.valueOf(o1.get("value").toString());
                Integer num2 = Integer.valueOf(o1.get("value").toString());
                return num2.compareTo(num1);
            }
        });

        Iterator<JSONObject> iterator = reslult.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = iterator.next();
            System.out.println(String.format("内容：【%s】, 出现次数：【%s】", jsonObject.get("value"), jsonObject.get("value")));
        }
    }
}
