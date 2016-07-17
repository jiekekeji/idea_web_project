package com.mx.fm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jack on 16/7/17.
 */
public class TimeUtils {

    /**
     * 毫秒值转日期格式
     * @param millis
     * @return
     */
    public static String getDateTime(long millis){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return formatter.format(calendar.getTime());
    }

    public static void main(String[] args) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        System.out.println(now + " = " + getDateTime(now));


    }
}
