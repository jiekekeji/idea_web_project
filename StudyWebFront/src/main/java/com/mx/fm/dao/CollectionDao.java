package com.mx.fm.dao;

import com.mx.fm.mapper.CollectionMapper;
import com.mx.fm.mapper.UserMapper;
import com.mx.fm.model.Collection;
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
 * 表:sdyweb_collection
 * Created by jack on 16/5/27.
 */
public class CollectionDao {

    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private CollectionMapper mapper;

    public CollectionDao() {
        String resource = "conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(CollectionMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据用户名查找
     *
     * @param username
     * @return
     */
    public Collection findCollectionByUsername(String username) {
        return mapper.findCollectionByUsername(username);
    }

    ;

    /**
     * 查找某个用户的收藏
     *
     * @param username
     * @param page
     * @param rows
     * @return
     */
    public List<Collection> findCollectionsByUsername(String username, int page, int rows) {
        return mapper.findCollectionsByUsername(username, page, rows);
    }

    ;

    /**
     * 添加一条收藏
     *
     * @param collection
     * @return
     */
    public int addCollection(Collection collection) {
        return mapper.addCollection(collection);
    }

    ;

    /**
     * 根据用户名删除一条收藏
     *
     * @param username
     * @return
     */
    public int deleteCollection(String username) {
        return mapper.deleteCollection(username);
    }

}
