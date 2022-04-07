package com.codepresso.team2app.repository;

import com.codepresso.team2app.vo.HashTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HashTagRepositroy {
    Integer saveHashTag(@Param("HashTag")HashTag hashTag);
    List<HashTag> findHashTag();
}
