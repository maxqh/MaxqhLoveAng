package com.maxqh.testarea.leetcode.ali;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;

/**
 *
 * 编写一个简单的java爬虫， 获取http://www.shicimingju.com/chaxun/list/29694.html
 * 中《山居秋暝》完整的诗句内容，以文件存储在本地文件目录中（考虑诗句格式）
 *
 */
public class AliTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AliTest.class);

    private static final String TARGET_URL = "http://www.shicimingju.com/chaxun/list/8459.html";

    private static final String KEY_WORD = "class=\"shici";

    private static final String TITLE = "shici-title";

    private static final String CONTENT = "shici-content";

    public static void main(String[] args) {
        try {
            URL url = new URL(TARGET_URL);
            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s;

            File file = new File("maxqh.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            Boolean isDivEnd = Boolean.TRUE;
            int divNum = 0;
            while ((s = reader.readLine()) != null) {
                if (s.contains(TITLE) || s.contains(CONTENT)) {
                    LOGGER.error(s);
                    writer.write(s);
                    writer.newLine();

                    isDivEnd = Boolean.FALSE;
                    divNum = 1;
                } else {
                    if (isDivEnd) {
                        continue;
                    }

                    if (divNum > 0) {
                        LOGGER.error(s);
                        writer.write(s);
                        writer.newLine();

                        if (s.indexOf("<div") > 0) {
                            divNum++;
                        }
                        if (s.indexOf("</div") > 0) {
                            divNum--;
                        }
                    }
                }

            }

            inputStream.close();

            reader.close();

            writer.close();

            /*
             * URLConnection urlConnection = url.openConnection();
             * urlConnection.setDoOutput(Boolean.TRUE);
             * urlConnection.setDoInput(Boolean.TRUE); OutputStream outputStream
             * = urlConnection.getOutputStream(); ByteArrayOutputStream
             * byteArrayOutputStream = (ByteArrayOutputStream) outputStream;
             * byte[] result = byteArrayOutputStream.toByteArray(); String
             * string = result.toString();
             * 
             * LOGGER.info("AliTest success. result:{}", result);
             */
        } catch (Exception e) {
            LOGGER.error("AliTest exception. ", e);
        }
    }

}
