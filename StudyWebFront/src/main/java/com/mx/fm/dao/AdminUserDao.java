package com.mx.fm.dao;

import com.mx.fm.mapper.UserMapper;
import com.mx.fm.model.User;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * 表:sdy_user   管理员能操作的
 * Created by jack on 16/5/27.
 */
public class AdminUserDao {

    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private UserMapper mapper;

    public AdminUserDao() {
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
        return mapper.addUser(user);
    }

    /**
     * 删除用户
     *
     * @param username
     * @return
     */
    public int deleteUserByUsername(String username) {
        return mapper.deleteUserByUsername(username);
    }


    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public User findUserByUsername(String username) {
        return mapper.findUserByUsername(username);
    }

    /**
     * 根据手机号查找用户
     *
     * @param phonenum
     * @return
     */
    public User findUserByPhonenum(String phonenum) {
        return mapper.findUserByPhonenum(phonenum);
    }

    /**
     * 获取用户列表
     *
     * @param page
     * @param rows
     * @return
     */
    public List<User> findAllUsers(int page, int rows) {
        return mapper.findAllUsers(page, rows);
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


}
