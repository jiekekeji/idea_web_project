package com.mx.fm.dao;

import com.mx.fm.mapper.CommentMapper;
import com.mx.fm.mapper.UserMapper;
import com.mx.fm.model.Comment;
import com.mx.fm.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
public class CommentDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private CommentMapper mapper;

    public CommentDao() {
        String resource = "conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(CommentMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条评论
     *
     * @param comment
     * @return
     */
    public int addComment(Comment comment) {
        return mapper.addComment(comment);
    }

    /**
     * 查找某个视频下的评论
     *
     * @param videoid
     * @param page
     * @param rows
     * @return
     */
    public List<Comment> findCommentByVideoid(int videoid, int page, int rows) {
        return mapper.findCommentByVideoid(videoid, page, rows);
    }

    /**
     * 查找某个用户的所有评论
     *
     * @param username
     * @param page
     * @param rows
     * @return
     */
    public List<Comment> findCommentByUsername(String username, int page, int rows) {
        return mapper.findCommentByUsername(username, page, rows);
    }

    /**
     * 删除某个用户的评论
     *
     * @param username
     * @return
     */
    public int deleteCommentByUsername(String username) {
        return mapper.deleteCommentByUsername(username);
    }


}
