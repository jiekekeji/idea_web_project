package com.mx.fm.utils;

/**
 * Created by Administrator on 2016-07-12.
 */
public class TextUtils {
    /**
     * 判断是否为空字符串
     *
     * @param string
     * @return
     */
    public static boolean isEmpty(String string) {
        if (null == string || string.equals("")) {
            return true;
        }
        return false;
    }
}
