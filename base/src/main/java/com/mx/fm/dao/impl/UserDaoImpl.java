package com.mx.fm.dao.impl;

import com.mx.fm.dao.IUserDao;
import com.mx.fm.mapper.UserMapper;
import com.mx.fm.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by jack on 16/5/27.
 */
public class UserDaoImpl  implements IUserDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private UserMapper mapper;
    public UserDaoImpl() {
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

    public User findUserById(int id) {
        return mapper.findUserById(id);
    }

    public int addUser(User user) {
         mapper.addUser(user);
         session.commit();
        return 0;
    }

    public List<User> getAllUsers() {
        return mapper.getAllUsers();
    }
}
