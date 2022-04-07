package com.codepresso.team2app.repository;

import com.codepresso.team2app.vo.Follow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowRepository {
    Integer saveFollow(@Param("follow") Follow follow);
    Integer cancelFollowing(@Param("otherId") Long otherId, @Param("userId") Long userId);
}
