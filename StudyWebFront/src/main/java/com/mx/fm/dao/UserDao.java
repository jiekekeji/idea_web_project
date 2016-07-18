package com.mx.fm.dao;

import com.mx.fm.mapper.UserMapper;
import com.mx.fm.model.Collection;
import com.mx.fm.model.Comment;
import com.mx.fm.model.User;
import com.mx.fm.model.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dom4j.util.UserDataDocumentFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by jack on 16/7/10.
 */
public class UserDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private UserMapper mapper;

    public UserDao() {
        String resource = "conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addUser(User user) {
        int code = 0;
        try {
            code = mapper.addUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.commit();
        }
        return code;
    }

    /**
     * 添加收藏
     *
     * @param collection
     * @return
     */
    public int addCollection(Collection collection) {
        return mapper.addCollection(collection);
    }

    /**
     * 查找用户
     *
     * @param username
     * @return
     */
    public User findUserByUsername(String username) {
        return mapper.findUserByUsername(username);
    }

    /**
     * 查找用户
     *
     * @param phonenum
     * @return
     */
    public List<User> findUserByPhonenum(String phonenum, int page, int rows) {
        return mapper.findUserByPhonenum(phonenum, page, rows);
    }

    /**
     * 查找用户
     *
     * @param username
     * @param page
     * @param rows
     * @return
     */
    public List<User> findUsersByUsername(String username, int page, int rows) {
        return mapper.findUsersByUsername(username, page, rows);
    }

    /**
     * 查找用户列表
     *
     * @param page
     * @param rows
     * @return
     */
    public List<User> findAllUsers(int page, int rows) {
        return mapper.findAllUsers(page, rows);
    }

    /**
     * 查找用户收藏的视频
     *
     * @param username
     * @param page
     * @param rows
     * @return
     */
    public List<Video> findColleciontVideo(String username, int page, int rows) {
        return mapper.findColleciontVideo(username, page, rows);
    }

    /**
     * 删除收藏
     *
     * @param videoid
     * @return
     */
    public int deleteVideoCommentByVideoid(int videoid) {
        return mapper.deleteVideoCommentByVideoid(videoid);
    }

    /**
     * 查询用户的评论
     *
     * @param username
     * @param page
     * @param rows
     * @return
     */
    public List<Comment> findCommentsByUsername(String username, int page, int rows) {
        return mapper.findCommentsByUsername(username, page, rows);
    }

    /**
     * 用户删除评论
     *
     * @param username
     * @return
     */
    public List<Comment> deleteCommentsByUsername(String username) {
        return mapper.deleteCommentsByUsername(username);
    }

    /**
     * 修改密码
     *
     * @param username
     * @param oldpassword
     * @param newpasswrod
     * @return
     */
    public int updatePassword(String username, String oldpassword, String newpasswrod) {
        return mapper.updatePassword(username, oldpassword, newpasswrod);
    }

    /**
     * 修改 昵称,电话号,QQ号,头像,微信,邮箱,自我介绍
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return mapper.updateUser(user);
    }

    /**
     * 修改头像
     *
     * @param username
     * @param headerurl
     * @return
     */
    public int updateUserHeaderurl(String username, String headerurl) {
        return mapper.updateUserHeaderurl(username, headerurl);
    }

    /**
     * 修改自我介绍
     *
     * @param username
     * @param introduce
     * @return
     */
    public int updateUserIntroduce(String username, String introduce) {
        return mapper.updateUserIntroduce(username, introduce);
    }


}
