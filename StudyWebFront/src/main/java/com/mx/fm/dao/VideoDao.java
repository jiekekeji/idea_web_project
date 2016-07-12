package com.mx.fm.dao;

import com.mx.fm.mapper.VideoClazzMapper;
import com.mx.fm.mapper.VideoMapper;
import com.mx.fm.model.Video;
import com.mx.fm.model.VideoClazz;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
public class VideoDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private VideoMapper mapper;

    public VideoDao() {
        String resource = "conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(VideoMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加视频
     *
     * @param video
     * @return
     */
    public int addVideo(Video video) {
        return mapper.addVideo(video);
    }

    /**
     * 根据视频id查找视频信息
     *
     * @param videoid
     * @param page
     * @param rows
     * @return
     */
    public Video findVideosByVideoID(int videoid, int page, int rows) {
        return mapper.findVideosByVideoID(videoid, page, rows);
    }

    /**
     * 查找某个分类下的视频
     *
     * @param clazzid
     * @param page
     * @param rows
     * @return
     */
    public List<Video> findVideosByClazzID(int clazzid, int page, int rows) {
        return mapper.findVideosByClazzID(clazzid, page, rows);
    }

    /**
     * 根据视频id删除视频
     *
     * @param videoid
     * @return
     */
    public int deleteVideoByUsername(int videoid) {
        return mapper.deleteVideoByVideoid(videoid);
    }

    /**
     * 更新视频信息
     *
     * @param video
     * @return
     */
    public int updateVideo(Video video) {
        return mapper.updateVideo(video);
    }

}
