package com.mx.fm.dao;

import com.mx.fm.mapper.VideoClazzMapper;
import com.mx.fm.model.VideoClazz;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by jack on 16/7/10.
 */
public class VideoClazzDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private VideoClazzMapper mapper;

    public VideoClazzDao() {
        String resource = "conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(VideoClazzMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加分类
     *
     * @param videoClazz
     * @return
     */
    public int addVideoClazz(VideoClazz videoClazz) {
        return mapper.addVideoClazz(videoClazz);
    }

    /**
     * 查询所有的分类
     *
     * @param page
     * @param rows
     * @return
     */
    public List<VideoClazz> findVideoClazzs(int page, int rows) {
        return mapper.findVideoClazzs(page, rows);
    }

    /**
     * 根据分类名称查找分类
     *
     * @param name
     * @return
     */
    public VideoClazz findCommentByName(String name) {
        return mapper.findCommentByName(name);
    }

    /**
     * 根据分类id查找分类
     *
     * @param id
     * @return
     */
    public VideoClazz findCommentByID(int id) {
        return mapper.findCommentByID(id);
    }

    /**
     * 根据分类id删除分类
     *
     * @param id
     * @return
     */
    public int deleteCommentByUsername(int id) {
        return mapper.deleteCommentByUsername(id);
    }

}
