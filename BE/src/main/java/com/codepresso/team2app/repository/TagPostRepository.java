package com.codepresso.team2app.repository;

import com.codepresso.team2app.vo.HashTag;
import com.codepresso.team2app.vo.TagPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagPostRepository {
    public Integer saveTagPost(@Param("tagPost") TagPost tagPost);
}
