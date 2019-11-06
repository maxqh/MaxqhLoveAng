package com.maxqh.testarea.ang;

import okhttp3.*;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/7/4
 * @Version:1.0
 */
public class GlorityGetItemInfoDemo {
    public static void main(String... args) throws IOException {

        String appKey = "5ce39ea8"; // 这里输入提供的app_key
        String appSecret = "602ab6b00b648b29edf74ae357da8c3f"; // 这里输入提供的app_secret

        String host = "http://fapiao.glority.cn/v1/item/get_item_info";
        long timestamp = System.currentTimeMillis() / 1000;
        String token = new Md5Hash(appKey + "+" + timestamp + "+" + appSecret).toString();

        OkHttpClient client = new OkHttpClient();

        File file = new File("/Users/qianhao/Downloads/sample.jpg");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        // 设置类型
        builder.setType(MultipartBody.FORM);

        // 参数
        builder.addFormDataPart("app_key", appKey);
        builder.addFormDataPart("timestamp", String.valueOf(timestamp));
        builder.addFormDataPart("token", token);

        // 文件参数
        builder.addFormDataPart("image_file", file.getName(), RequestBody.create(null, file));

        // 创建RequestBody
        RequestBody body = builder.build();
        // 创建Request
        final Request request = new Request.Builder().url(host).post(body).build();
        // 单独设置参数 比如读取超时时间
        final Call call = client.newBuilder().writeTimeout(50, TimeUnit.SECONDS).build().newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    System.out.println(string);
                } else {
                    System.out.println("失败");
                }
            }
        });

    }
}
