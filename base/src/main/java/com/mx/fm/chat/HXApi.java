package com.mx.fm.chat;

/**
 * Created by jack on 16/5/28.
 */
public class HXApi {

    public static final String SERVER = "https://a1.easemob.com";

    public static final String ORG_APP_NAME = SERVER + "/" + HXConstants.ORG_NAME
            + "/" + HXConstants.APP_NAME;

    /**
     * 请求token
     */
    public static final String TOKEN = ORG_APP_NAME + "/token";

    /**
     * 用户相关接口
     */
    public static final String USERS = ORG_APP_NAME + "/users";

}
