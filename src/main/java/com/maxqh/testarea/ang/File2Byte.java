package com.maxqh.testarea.ang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.crypto.hash.Md5Hash;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/7/4
 * @Version:1.0
 */
public class File2Byte {
    //»ñÈ¡Í¼Æ¬base64±àÂë
    public static String getImangeStr(String imgFile){
        InputStream inputStream=null;
        byte[] data=null;

        try {
            inputStream=new FileInputStream(imgFile);
            data=new byte[inputStream.available()];
            if(data.length>(1024*1024*8)){
                System.out.println("Í¼Æ¬³¬¹ý8Õ×,ÐèÒªÑ¹Ëõ");
            }else{
                System.out.println("Í¼Æ¬Ð¡ÓÚ8m£¬²»ÐèÒªÑ¹Ëõ");
            }

            System.out.println(data.length);
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //¼ÓÃÜ
        BASE64Encoder encoder=new BASE64Encoder();
        String sb= encoder.encode(data);
        System.out.println("base64´óÐ¡:"+sb.length()/1024);
        //Ìæ»»»»ÐÐºÍ¼ÓºÅ
        String imageBase64 = encoder.encode(data).replaceAll("\r|\n", "");
        imageBase64=imageBase64.replaceAll("\\+", "%2B");
        //System.out.println(imageBase64);

        FileWriter fw = null;
        File f = new File("D:\\log\\base64.txt");
        try {
            if(!f.exists()){
                f.createNewFile();
            }
            fw = new FileWriter(f);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(imageBase64, 0, imageBase64.length()-1);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageBase64;

    }

    //Æ±¾ÝÊ¶±ð
    public static JSONObject getInvoiceMessage(String image_data,byte[] bytes){

        JSONObject jsonObject=null;
        String appKey = "5ce39ea8"; //ÕâÀïÊäÈëÌá¹©µÄapp_key
        String appSecret = "602ab6b00b648b29edf74ae357da8c3f"; //ÕâÀïÊäÈëÌá¹©µÄapp_secret
        //·¢Æ±Ê¶±ð
        //String interface_address = "http://fapiao.glority.cn/v1/item/get_item_info";
        //·¢Æ±Ê¶±ð²¢ÑéÕæ
        //String interface_address = "http://fapiao.glority.cn/v1/item/get_item_info_with_validation";
        //¶àÕÅ·¢Æ±Ê¶±ð
        String interface_address = "https://fapiao.glority.cn/v1/item/get_multiple_items_info";
        long timestamp = System.currentTimeMillis() / 1000;
        String token = new Md5Hash(appKey + "+" + timestamp + "+" + appSecret).toString();
        URL url;
        long  t1 =System.currentTimeMillis();
        try {


            System.out.println("µ±Ç°Ê±¼ä:"+t1);
            url = new  URL(interface_address);
            HttpURLConnection conn= (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(100000000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.addRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");

            //OutputStream  outputStream = conn.getOutputStream();
            DataOutputStream   outputStream = new DataOutputStream(conn.getOutputStream());
            //String strUrl1="app_key="+appKey+"&timestamp="+timestamp+"&image_data="+image_data+"&token="+token;
            String strUrl1="app_key="+appKey+"&timestamp="+timestamp+"&token="+token+"&image_file="+new String(bytes);
            outputStream.write(strUrl1.getBytes());
            outputStream.close();


            int statusCode =conn.getResponseCode();

            System.out.println("·µ»Ø´úÂëstatusCode:"+statusCode);

            if(statusCode==200){
                BufferedReader  in =  new BufferedReader(new  InputStreamReader(conn.getInputStream(),"UTF-8"));
                String inputLine;

                while((inputLine=in.readLine())!=null){
                    inputLine.replaceAll("\"", "1");
                    System.out.println("inputLine:"+inputLine);
                    jsonObject= JSON.parseObject(inputLine);
                    //invoiceTest invoice= JSON.toJavaObject(jsonObject, invoiceTest.class);
                    System.out.println(jsonObject.get("result"));
                }
                in.close();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long  t2 =System.currentTimeMillis();
        System.out.println("µ±Ç°Ê±¼ä:"+t2);
        System.out.println(t2-t1);
        return jsonObject;

    }

    public static void main(String[] args) throws IOException {

        //String imgName = ConnectionFactory.getFileName("38541");
        //System.out.println(imgName);
        //imgName Í¼Æ¬¾ø¶ÔÂ·¾¶
        String  imgName ="/Users/qianhao/Downloads/sample.jpg";
        InputStream inputStream=new FileInputStream(imgName);
        byte[] data=new byte[inputStream.available()];

        inputStream.read(data);
        inputStream.close();
        String  image_data =new String(data);
        System.out.println("Í¼Æ¬Êý¾Ý:"+data);
        System.out.println("data:"+data.length/1024);
        //String	image_data = getImangeStr(imgName);
        JSONObject jsonObject = getInvoiceMessage(image_data,data);
        JSONObject  jsonDetails= (JSONObject)jsonObject.get("details");
        //´íÎó´¦ÀíºÍjson½âÎö,´æÈëÊý¾Ý¿â todo

    }
}
