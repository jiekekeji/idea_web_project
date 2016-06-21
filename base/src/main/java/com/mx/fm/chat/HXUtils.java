package com.mx.fm.chat;

import com.alibaba.fastjson.JSON;
import com.mx.fm.chat.model.UserEntity;
import com.squareup.okhttp.*;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 环信相关工具类
 * Created by jack on 16/5/28.
 */
public class HXUtils {

    private static Logger log = Logger.getLogger(HXUtils.class);

    //管理员 Token,有效期7填
    private static String access_token;

    //expires_in,access_token获取的时间毫秒值
    private static long expires_in = 0;

    //token获取的时间
    private static long token_time = 0;

    /**
     * 获取 APP 管理员 Token
     *
     * @return 成功获取返回String else null;
     */
    public static String getAccess_token() {
        //先判断是否过期,当前时间减去上次获取的时间是否大于6天,提前一天获取新的
        if (System.currentTimeMillis() / 1000 - token_time < expires_in) {
            return access_token;
        }

        //******获取新的********
        Map requestBody = new HashMap();
        requestBody.put("grant_type", HXConstants.GRANT_TYPE);
        requestBody.put("client_id", HXConstants.CLIENT_ID);
        requestBody.put("client_secret", HXConstants.CLIENT_SECRET);
        String requestJson = JSON.toJSONString(requestBody);
        log.debug("token请求参数:" + requestJson);

        final MediaType jsonType = MediaType
                .parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonType, requestJson);

        //发起请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(HXApi.TOKEN)
                .header("Content-Type", "application/json").post(body).build();

        try {
            Response response = client.newCall(request).execute();
            log.debug("token请求结果:" + response.toString());
            if (response.isSuccessful()) {
                String result = response.body().string();
                log.debug("token成功请求结果:" + result);

                //重新给变量赋值
                JSONObject json = new JSONObject(result);
                expires_in = json.getInt("expires_in");
                access_token = json.getString("access_token");
                token_time = System.currentTimeMillis() / 1000;

                return access_token;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void registerUser(String username, String password) {

        //请求参数
        Map requestBody = new HashMap();
        requestBody.put("username", username);
        requestBody.put("password", password);
        String requestJson = JSON.toJSONString(requestBody);
        log.debug("注册用户参数:" + requestJson);

        final MediaType jsonType = MediaType
                .parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonType, requestJson);

        //发起请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(HXApi.USERS)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + getAccess_token()).post(body).build();

        try {
            Response response = client.newCall(request).execute();
            log.debug("注册用户请求结果:" + response.toString());
            if (response.isSuccessful()) {
                String result = response.body().string();
                log.debug("注册用户成功请求结果:" + result);

                //重新给变量赋值
//                JSONObject json = new JSONObject(result);
//                expires_in = json.getInt("expires_in");
//                access_token = json.getString("access_token");

//                return access_token;
            }
//            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return null;

    }


    /**
     * 获取 IM 用户 单个
     *
     * @param username 用户名
     * @return UserEntity else null
     */
    public static UserEntity findSingleUser(String username) {

        UserEntity entity = null;
        String requestURL = HXApi.USERS + "/" + username;
        //发起请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(requestURL)
                .header("Authorization", "Bearer " + getAccess_token()).get().build();

        try {
            Response response = client.newCall(request).execute();
            log.debug("查找用户请求结果:" + response.toString());
            if (response.isSuccessful()) {
                String result = response.body().string();
                log.debug("查找用户成功请求结果:" + result);

                //解析结果
                JSONObject json = new JSONObject(result);
                JSONArray array = json.getJSONArray("entities");
                if (null != array && array.length() > 0)
                    json = array.getJSONObject(0);
                entity = JSON.parseObject(json.toString(), UserEntity.class);
                return entity;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }

        return entity;

    }

    /**
     * 修改用户密码
     *
     * @param username    用户名
     * @param newpassword 新的用户密码
     * @return 修改成功返回true else false
     */
    public static boolean modifyPassword(String username, String newpassword) {

        String requestURL = HXApi.USERS + "/" + username + "/password";

        Map requestBody = new HashMap();
        requestBody.put("newpassword", newpassword);
        String requestJson = JSON.toJSONString(requestBody);
        log.debug("修改密码请求参数:" + requestJson);

        final MediaType jsonType = MediaType
                .parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonType, requestJson);

        //发起请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(requestURL)
                .header("Authorization", "Bearer " + getAccess_token())
                .put(body).build();

        try {
            Response response = client.newCall(request).execute();
            log.debug("修改密码请求结果:" + response.toString());
            if (response.isSuccessful()) {
                String result = response.body().string();
                log.debug("修改密码成功请求结果:" + result);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }

        return false;
    }

    /**
     * 修改用户的昵称
     *
     * @param username 用户名
     * @param nickname 昵称
     * @return 修改成功返回true else false
     */
    public static boolean modifyNickName(String username, String nickname) {

        String requestURL = HXApi.USERS + "/" + username;

        Map requestBody = new HashMap();
        requestBody.put("nickname", nickname);
        String requestJson = JSON.toJSONString(requestBody);
        log.debug("修改昵称请求参数:" + requestJson);

        final MediaType jsonType = MediaType
                .parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonType, requestJson);

        //发起请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(requestURL)
                .header("Authorization", "Bearer " + getAccess_token())
                .put(body).build();

        try {
            Response response = client.newCall(request).execute();
            log.debug("修改昵称请求结果:" + response.toString());
            if (response.isSuccessful()) {
                String result = response.body().string();
                log.debug("修改昵称成功请求结果:" + result);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }

        return false;
    }

    /**
     * 添加好友
     *
     * @param owner_username  要添加好友的用户名
     * @param friend_username 被添加的用户名
     * @return 成功返回true else false
     */
    public static boolean addFriend(String owner_username, String friend_username) {
        String requestURL = HXApi.USERS + "/" + owner_username
                + "/contacts" + "/users" + "/" + friend_username;

        Map requestBody = new HashMap();
        String requestJson = JSON.toJSONString(requestBody);
        log.debug("添加好友请求参数:" + requestJson);

        final MediaType jsonType = MediaType
                .parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonType, requestJson);

        //发起请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(requestURL)
                .header("Authorization", "Bearer " + getAccess_token()).post(body).build();

        try {
            Response response = client.newCall(request).execute();
            log.debug("添加好友请求结果:" + response.toString());
            if (response.isSuccessful()) {
                String result = response.body().string();
                log.debug("添加好友成功请求结果:" + result);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * 删除好友
     *
     * @param owner_username  要删除好友的用户名
     * @param friend_username 被删除好友的用户名
     * @return 成功返回true else false
     */
    public static boolean deleteFriend(String owner_username, String friend_username) {
        String requestURL = HXApi.USERS + "/" + owner_username
                + "/contacts" + "/users" + "/" + friend_username;

        Map requestBody = new HashMap();
        String requestJson = JSON.toJSONString(requestBody);
        log.debug("删除好友请求参数:" + requestJson);

        final MediaType jsonType = MediaType
                .parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonType, requestJson);

        //发起请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(requestURL)
                .header("Authorization", "Bearer " + getAccess_token()).delete(body).build();

        try {
            Response response = client.newCall(request).execute();
            log.debug("删除好友请求结果:" + response.toString());
            if (response.isSuccessful()) {
                String result = response.body().string();
                log.debug("删除好友成功请求结果:" + result);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 获取用户的好友
     *
     * @param username 用户名
     * @return List<String> else null
     */
    public static List<String> findFriend(String username) {

        List<String> friendNames = null;
        String requestURL = HXApi.USERS + "/" + username + "/contacts/users";
        //发起请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(requestURL)
                .header("Authorization", "Bearer " + getAccess_token()).get().build();

        try {
            Response response = client.newCall(request).execute();
            log.debug("查找好友请求结果:" + response.toString());
            if (response.isSuccessful()) {
                String result = response.body().string();
                log.debug("查找好友成功请求结果:" + result);

                //解析结果
                JSONObject json = new JSONObject(result);
                JSONArray array = json.getJSONArray("data");
                friendNames = JSON.parseArray(array.toString(), String.class);
                return friendNames;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }

        return friendNames;
    }


    public static void main(String[] args) {
        getAccess_token();
        registerUser("rose1", "123456");
        System.out.println(findSingleUser("rose1"));
        System.out.println(modifyPassword("rose1", "123456789"));
        System.out.println(modifyNickName("rose1", "小骗子"));
        System.out.println(addFriend("rose", "rose1"));
        System.out.println(addFriend("rose", "jack"));
        System.out.println(findFriend("rose"));
//        System.out.println(deleteFriend("rose", "rose1"));
    }


}
