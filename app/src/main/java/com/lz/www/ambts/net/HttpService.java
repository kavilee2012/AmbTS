package com.lz.www.ambts.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016-05-24.
 */
public class HttpService {

    public interface HttpCallBack
    {
        void onRequestComplete(String result);
    }



    /**
     * Get请求方法
     */
    public static String doGet(String url) {
        HttpURLConnection connection = null;
        String response="";
        try {
            URL _url = new URL(url);
            connection = (HttpURLConnection) _url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000 * 10);
            connection.setReadTimeout(1000 * 10);
            InputStream in=connection.getInputStream();
            //读取输入流
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
            response = sb.toString();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(connection!=null)
                connection.disconnect();
        }
        return response;
    }

    /**
     * POST请求方法
     */
    public static String doPost(String url,String params){
        //params="key1=value1&key2=value2";
        HttpURLConnection connection = null;
        String response="";
        try {
            URL _url = new URL(url);
            connection = (HttpURLConnection) _url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(1000 * 10);

            // 发送POST请求必须设置如下两行
            connection.setDoOutput(true);// 使用 URL 连接进行输出
            connection.setDoInput(true);// 使用 URL 连接进行输入
            connection.setUseCaches(false);// 忽略缓存

            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Length", String.valueOf(params.length()));
            connection.setRequestProperty("Charset","UTF-8");

            byte[] byteParams=params.getBytes("UTF-8");
            connection.getOutputStream().write(byteParams);
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

//            //OutputStream没法直接将字符串写入到输出流中，必须以char[]数据的方式写入，操作上比较麻烦，PrintWriter可以很方便的直接将String写入到输出流中
//            PrintWriter pw = new PrintWriter(connection.getOutputStream());
//            pw.print(params);
//            pw.flush();
//            pw.close();

            //读取输入流
            InputStream in=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
            response = sb.toString();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(connection!=null)
                connection.disconnect();
        }
        return response;
    }


    /***
     * 异步GET请求
     *
     * */
    public static void doGetAsyn(final String url, final HttpCallBack callback) {
        new Thread() {
            public void run() {
                try {
                    String result = doGet(url);
                    if (callback != null) {
                        callback.onRequestComplete(result);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            };
        }.start();
    }

    /***
     * 异步POST请求
     *
     * */
    public static void doPostAsyn(final String url,final String params,final HttpCallBack callBack) throws Exception {

        new Thread(){
            public void run(){
              try {
                  String result=doPost(url,params);
                  if(callBack!=null){
                      callBack.onRequestComplete(result);
                  }
              }catch (Exception ex){
                  ex.printStackTrace();
              }
            };
        }.start();

    }


}
