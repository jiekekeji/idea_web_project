package com.mx.fm.service;

import com.mx.fm.dao.UserDao;
import com.mx.fm.dao.VideoDao;
import com.mx.fm.model.User;
import com.mx.fm.model.Video;
import com.mx.fm.model.VideoClazz;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-07-18.
 */
public class VideoService {

    private static Logger logger = Logger.getLogger(VideoService.class);
    private VideoDao dao = new VideoDao();


    /**
     * 查询视频分类信息及该分类下的视频总数
     *
     * @param page
     * @param rows
     * @return
     */
    public Map findVideoClazz(int page, int rows) {
        Map map = new HashMap();
        List<VideoClazz> videoClazzs = dao.findVideoClazz(page, rows);
        map.put("videoClazzs", videoClazzs);
        return map;
    }

    /**
     * 根据分类名称查询视频分类信息及该分类下的视频总数
     *
     * @param name
     * @param page
     * @param rows
     * @return
     */
    public Map findVideoClazzByName(String name, int page, int rows) {
        Map map = new HashMap();
        List<VideoClazz> videoClazzs = dao.findVideoClazzByName(name, page, rows);
        map.put("videoClazzs", videoClazzs);
        return map;
    }

    /**
     * 添加视频
     *
     * @param video
     * @return
     */
    public Map addVideo(Video video) {
        Map map = new HashMap();
        int code = dao.addVideo(video);
        if (code > 0) {
            map.put("code", 2000);
            map.put("desc", "添加成功");
            return map;
        }

        map.put("code", 4000);
        map.put("desc", "添加失败");
        return map;
    }

    /**
     * 查找分页视频
     *
     * @param page
     * @param rows
     * @return
     */
    public Map findVideos(int page, int rows) {
        Map map = new HashMap();
        map.put("videos", dao.findVideos(page, rows));
        return map;
    }

    /**
     * 查找分类下的分页视频
     *
     * @param classid
     * @param page
     * @param rows
     * @return
     */
    public Map findVideosByClassID(int classid, int page, int rows) {
        Map map = new HashMap();
        map.put("videos", dao.findVideosByClassID(classid, page, rows));
        return map;
    }
}
