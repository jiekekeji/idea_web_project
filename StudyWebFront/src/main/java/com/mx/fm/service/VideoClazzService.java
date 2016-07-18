package com.mx.fm.service;

import com.mx.fm.dao.UserDao;
import com.mx.fm.dao.VideoClazzDao;
import com.mx.fm.mapper.VideoClazzMapper;
import com.mx.fm.model.VideoClazz;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 16/7/10.
 */
public class VideoClazzService {
    private static Logger logger = Logger.getLogger(UserService.class);
    private VideoClazzDao dao = new VideoClazzDao();

    /**
     * 添加分类
     *
     * @param videoClazz
     * @return
     */
    public Map addVideoClazz(VideoClazz videoClazz) {
        Map map = new HashMap();
        int code = dao.addVideoClazz(videoClazz);
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
     * 查询所有的分类
     *
     * @param page
     * @param rows
     * @return
     */
    public Map findVideoClazzs(int page, int rows) {
        Map map = new HashMap();
        map.put("videoClazzs", dao.findVideoClazzs(page, rows));
        return map;
    }

    /**
     * 查询所有的分类
     *
     * @return
     */
    public Map findAllVideoClazzs() {
        Map map = new HashMap();
        map.put("videoClazzs", dao.findAllVideoClazzs());
        return map;
    }

    /**
     * 根据分类名称查找分类
     *
     * @param name
     * @return
     */
    public VideoClazz findCommentByName(String name) {
        return dao.findCommentByName(name);
    }

    /**
     * 根据分类id查找分类
     *
     * @param id
     * @return
     */
    public VideoClazz findCommentByID(int id) {
        return dao.findCommentByID(id);
    }

    /**
     * 根据分类id删除分类
     *
     * @param id
     * @return
     */
    public int deleteCommentByUsername(int id) {
        return dao.deleteCommentByUsername(id);
    }

}
