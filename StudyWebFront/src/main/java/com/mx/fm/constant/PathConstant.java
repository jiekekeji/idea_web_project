package com.mx.fm.constant;

/**
 * 路径相关参数
 * Created by Administrator on 2016-07-18.
 */
public class PathConstant {

    /**
     * 视频文件存放地址
     * 需在tomcat的../conf/server/xml  <host></host>重配置虚拟目录，方面访问
     *
     * 浏览器访问路径格式:http://localhost:8080/video/1468892463084.png
     */
    public static final String UPLOAD_VIDEO = "D:\\upload\\video";

    /**
     * 图片文件存放地址
     * 需在tomcat的../conf/server/xml  <host></host>重配置虚拟目录，方面访问
     *
     * 浏览器访问路径格式:http://localhost:8080/images/1468892463084.png
     */
    public static final String UPLOAD_IMAGES = "D:\\upload\\images";
}
