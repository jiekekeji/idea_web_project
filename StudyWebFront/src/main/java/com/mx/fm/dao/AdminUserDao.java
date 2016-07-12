package com.mx.fm.dao;

import com.mx.fm.mapper.AdminUserMapper;
import com.mx.fm.mapper.UserMapper;
import com.mx.fm.model.AdminUser;
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
 * 表:sdyweb_admin
 * Created by jack on 16/5/27.
 */
public class AdminUserDao {

    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private AdminUserMapper mapper;

    public AdminUserDao() {
        String resource = "conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(AdminUserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public AdminUser findUserByUsername(String username) {
        return mapper.findUserByUsername(username);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addUser(AdminUser user) {
        return mapper.addUser(user);
    }

    /**
     * 获取用户列表
     *
     * @param page
     * @param rows
     * @return
     */
    public List<AdminUser> findAllUsers(int page, int rows) {
        return mapper.findAllUsers(page, rows);
    }

    /**
     * 修改密码
     * @param username
     * @param oldpassword
     * @param newpasswrod
     * @return
     */
    public int updatePassword(String username, String oldpassword, String newpasswrod) {
        return mapper.updatePassword(username, oldpassword, newpasswrod);
    }

    /**
     * 删除管理员
     * @param username
     * @return
     */
    public int deleteUserByUsername(String username){
        return  mapper.deleteUserByUsername(username);
    }
}
