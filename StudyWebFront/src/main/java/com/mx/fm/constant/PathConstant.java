package com.mx.fm.constant;

/**
 * 路径相关参数
 * Created by Administrator on 2016-07-18.
 */
public class PathConstant {

    /**
     * 视频文件存放地址
     * 需在tomcat的../conf/server/xml  <host></host>重配置虚拟目录，方面访问
     */
    public static final String UPLOAD_VIDEO = "D:\\upload\\video";

    /**
     * 图片文件存放地址
     * 需在tomcat的../conf/server/xml  <host></host>重配置虚拟目录，方面访问
     */
    public static final String UPLOAD_IMAGES = "D:\\upload\\images";
}
