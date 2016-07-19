package com.mx.fm.dao;

import com.mx.fm.mapper.VideoMapper;
import com.mx.fm.model.*;
import org.apache.ibatis.annotations.Select;
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
        int code = 0;
        try {
            code = mapper.addVideo(video);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.commit();
        }
        return code;
    }

    /**
     * 添加视频图片
     *
     * @param img
     * @return
     */
    public int addVideoImg(VideoImg img) {
        return mapper.addVideoImg(img);
    }

    /**
     * 添加视频评论
     *
     * @param comment
     * @return
     */
    public int addVideoComment(Comment comment) {
        return mapper.addVideoComment(comment);
    }

    /**
     * 删除视频
     *
     * @param videoid
     * @return
     */
    public int deleteVideoByVideoid(int videoid) {
        return mapper.deleteVideoByVideoid(videoid);
    }

    /**
     * 删除视频图片
     *
     * @param videoid
     * @return
     */
    int deleteVideoImgByVideoid(int videoid) {
        return deleteVideoImgByVideoid(videoid);
    }

    /**
     * 删除视频评论
     *
     * @param videoid
     * @return
     */
    public int deleteVideoCommentByVideoid(int videoid) {
        return mapper.deleteVideoCommentByVideoid(videoid);
    }

    /**
     * 查找分页视频
     *
     * @param page
     * @param rows
     * @return
     */
    public List<Video> findVideos(int page, int rows) {
        return mapper.findVideos(page, rows);
    }

    /**
     * 查找分类下的分页视频
     *
     * @param classid
     * @param page
     * @param rows
     * @return
     */
    public List<Video> findVideosByClassID(int classid, int page, int rows) {
        return mapper.findVideosByClassID(classid, page, rows);
    }

    /**
     * 根据视频ID查找对应的图片
     *
     * @param videoid
     * @param page
     * @param rows
     * @return
     */
    public List<VideoImg> findVideoImgByVideoID(int videoid, int page, int rows) {
        return mapper.findVideoImgByVideoID(videoid, page, rows);
    }

    /**
     * 根据视频ID查找对应的视频评论
     *
     * @param videoid
     * @param page
     * @param rows
     * @return
     */
    public List<CommentUser> findVideoCommentByVideoID(int videoid, int page, int rows) {
        return mapper.findVideoCommentByVideoID(videoid, page, rows);
    }

    /**
     * 查询视频分类信息及该分类下的视频总数
     *
     * @param page
     * @param rows
     * @return
     */
    public List<VideoClazz> findVideoClazz(int page, int rows) {
        return mapper.findVideoClazz(page, rows);
    }

    /**
     * 根据分类名称查询视频分类信息及该分类下的视频总数
     *
     * @param name
     * @param page
     * @param rows
     * @return
     */
    public List<VideoClazz> findVideoClazzByName(String name, int page, int rows) {
        return mapper.findVideoClazzByName(name, page, rows);
    }

    /**
     * 根据ID查询视频详情
     *
     * @param id
     * @return
     */
    public Video findVideosByID(long id) {
        return mapper.findVideosByID(id);
    }

    /**
     * 根据ID更新视频
     *
     * @param video
     * @return
     */
    public int updateVideoByID(Video video) {
        int code = 0;
        try {
            code = mapper.updateVideoByID(video);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.commit();
        }
        return code;
    }
}
