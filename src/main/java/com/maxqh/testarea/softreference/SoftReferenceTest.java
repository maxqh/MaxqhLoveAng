package com.maxqh.testarea.softreference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * @Author:qianhao
 * @Description: 软引用测试
 * @Date:2018/3/19
 * @Version:1.0
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws Exception{
        ArrayList<String> a = new ArrayList<>(1024);
        for (int i = 0; true; i++) {
            a.addAll(new ArrayList<>(1024));
            Object obj = new Object();
            SoftReference<Object> sf = new SoftReference<Object>(obj);
            obj = null;
            System.gc();
            System.out.println(String.format("第[%s]次调用软引用， obj=[%s]", i, sf.get()));
        }

    }
}
