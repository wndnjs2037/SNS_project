package com.codepresso.team2app.repository;

import com.codepresso.team2app.vo.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeRepository {
    Integer countSave(@Param("Like") Like like);


}
