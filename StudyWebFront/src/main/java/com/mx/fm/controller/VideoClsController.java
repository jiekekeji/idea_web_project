package com.mx.fm.controller;

import com.mx.fm.service.VideoClazzService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2016-07-18.
 */
@Controller
@RequestMapping(value = "/videocls")
public class VideoClsController {

    private static Logger logger = Logger.getLogger(VideoClsController.class);
    private VideoClazzService service = new VideoClazzService();

    /**
     * 根据分类名称查询视频分类信息及该分类下的视频总数
     *
     * @return
     */
    @RequestMapping(value = "/findAllVideoClazzs", method = RequestMethod.GET)
    @ResponseBody
    public Map findAllVideoClazzs() {
        logger.debug("findAllVideoClazzs:");
        Map map = service.findAllVideoClazzs();
        logger.debug("findAllVideoClazzs:" + map);
        return map;
    }

}
