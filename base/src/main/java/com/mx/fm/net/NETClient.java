package com.mx.fm.net;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class NETClient {

    private static NETClient netUtils = null;

    private static OkHttpClient client = null;

    private NETClient() {
        client = new OkHttpClient();
        client.setConnectTimeout(180, TimeUnit.SECONDS);
    }

    /**
     * 实例化NetUtils
     *
     * @return
     */
    public static NETClient getInstance() {
        if (netUtils == null) {
            netUtils = new NETClient();
        }
        return netUtils;
    }

    /**
     * post参数
     *
     * @param url 地址
     * @param map 请求参数
     * @return JSONObject
     */
    public JSONObject getFromNetwork(String url, Map<String, String> map) {
        Request request = null;
        if (map != null) {

            FormEncodingBuilder builder = new FormEncodingBuilder();
            /**
             * 设置参数
             */
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }

            RequestBody body = builder.build();

            /**
             * 实例化请求
             */
            request = new Request.Builder().url(url).post(body).tag("tag")
                    .build();
        } else {

            /**
             * 实例化请求
             */
            request = new Request.Builder().url(url).tag("tag").build();
        }

        /**
         * 执行请求
         */
        Response response;
        try {
            response = client.newCall(request).execute();
            /**
             * 返回结果
             */
            if (response.isSuccessful()) {
                return new JSONObject(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * xml为参数发送http请求
     *
     * @param url
     * @param xml
     * @return
     * @throws IOException
     */
    public String getFromNetwork(String url, String xml) throws IOException {

        final MediaType xmlType = MediaType
                .parse("application/xml; charset=utf-8");

        RequestBody body = RequestBody.create(xmlType, xml);
        /**
         * 将请求体加入请求中
         */
        Request request = new Request.Builder().url(url).post(body).build();
        /**
         * 执行请求
         */
        Response response = client.newCall(request).execute();

        /**
         * 返回结果
         */
        if (response.isSuccessful()) {
            return response.body().string();

        }

        return null;

    }

    /**
     * get请求json
     *
     * @param url 请求地址
     * @return String
     */
    public JSONObject getFromNetwork(String url) {
        // 创建请求
        Request request = new Request.Builder().url(url).tag("reqGet").build();
        // 客户端执行请求,execute为同步请求
        Response response;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return new JSONObject(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
