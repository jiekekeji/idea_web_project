package com.mx.fm.dao;

import com.mx.fm.mapper.UserMapper;
import com.mx.fm.model.User;
import org.apache.ibatis.io.Resources;
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
        return mapper.addUser(user);
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
     * 分页查找用户
     *
     * @param page
     * @param rows
     * @return
     */
    public List<User> findAllUsers(int page, int rows) {
//        return mapper.findAllUsers(page, rows);
        return  null;
    }

    public static void main(String[] arg) {
//        User user = new User();
//        user.setUsername("jack");
//        user.setPassword("123456");
//        System.out.println(new UserDao().addUser(user));
//        System.out.println("00000");
        UserDao dao=new UserDao();
        System.out.println(dao.mapper.findAllUsers("0","3"));
    }


}
