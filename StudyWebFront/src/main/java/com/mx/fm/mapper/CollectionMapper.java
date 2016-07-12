package com.mx.fm.mapper;

import com.mx.fm.model.Collection;
import com.mx.fm.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 表:sdyweb_collection
 * Created by jack on 16/5/27.
 */
public interface CollectionMapper {

    @Select("SELECT * FROM sdyweb_collection WHERE username = #{username}")
    Collection findCollectionByUsername(String username);

    @Select("SELECT * FROM sdyweb_collection WHERE username = #{0} LIMIT #{1},#{2}")
    List<Collection> findCollectionsByUsername(String username,int page, int rows);

    @Insert("INSERT INTO sdyweb_collection(username,videoid) values(#{username},#{videoid})")
    int addCollection(Collection collection);

    @Delete("DELETE FROM sdyweb_collection WHERE username=#{username}")
    int deleteCollection(String username);

    @Select("SELECT * FROM sdyweb_collection LIMIT #{0},#{1}")
    List<Collection> findCollections(int page, int rows);

}
