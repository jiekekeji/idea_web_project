package com.mx.fm.mapper;

import com.mx.fm.model.AdminUser;
import com.mx.fm.model.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 表:sdyweb_comment
 * Created by jack on 16/5/27.
 */
public interface CommentMapper {

    @Insert("INSERT INTO sdyweb_comment(comment,timemillis,videoid,username) " +
            "values(#{comment},#{timemillis},#{videoid},#{username})")
    int addComment(Comment user);

    @Select("SELECT * FROM sdyweb_comment WHERE videoid=#{0} LIMIT #{1},#{2}")
    List<Comment> findCommentByVideoid(int videoid,int page, int rows);

    @Select("SELECT * FROM sdyweb_comment WHERE username =#{0} LIMIT #{1},#{2}")
    List<Comment> findCommentByUsername(String username,int page, int rows);

    @Delete("DELETE FROM sdyweb_comment WHERE username=#{username}")
    int deleteCommentByUsername(String username);
}
