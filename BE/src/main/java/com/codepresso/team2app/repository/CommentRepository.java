package com.codepresso.team2app.repository;

import com.codepresso.team2app.vo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentRepository {
    Integer saveComment(@Param("comment") Comment comment);
    List<Comment> findAllComment();
    Comment findOneComment(@Param("id") Long id);
    List<Comment> findPostComment(@Param("id") Long id);
    List<Comment> findPostCommentByPage(@Param("postId") Long postId, @Param("limit") Integer limit, @Param("offset") Integer offset);
//    page, Limit 갯수에 맞게 조회가 안됨..
    Integer noVisibleComment(@Param("commentId") Long commentId);
}
