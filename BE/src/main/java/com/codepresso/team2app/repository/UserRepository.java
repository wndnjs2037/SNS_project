package com.codepresso.team2app.repository;

import com.codepresso.team2app.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
  void save(User user);
  User findByEmail(String email);
  User findById(@Param("id") long id);
  void updateFollower(@Param("id") long id);
  void updateFollowing(@Param("id") long id);
}
