package com.example.myapplication.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class NetworkUtils {
    public static String get(String urlPath) {
        HttpURLConnection connection = null;
        InputStream is = null;
        try {
            //1.将url字符串转为URL对象
            URL url = new URL(urlPath);
            //2.获得HttpURLConnection对象
            connection = (HttpURLConnection) url.openConnection();
            //3.设置连接的相关参数
            connection.setRequestMethod("GET");//默认位GET
            connection.setUseCaches(false);//不使用缓存
            connection.setConnectTimeout(10000);//设置超时时间
            connection.setReadTimeout(10000);//设置读取超时时间
            connection.setDoInput(true);
            //5.进行数据的读取，首先判断响应码是否为200
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                is = connection.getInputStream();//获得输入流
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder();
                String line;
            }
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            //6.返回结果
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String post(String urlPath, Map<String, String> params) {
        //1.处理post参数
        if (params == null || params.size() == 0) {
            return get(urlPath);
        }
        OutputStream os = null;
        InputStream is = null;
        HttpURLConnection connection = null;
        StringBuffer body = getParamString(params);
        byte[] data = body.toString().getBytes();
        return  null;
    }
}
