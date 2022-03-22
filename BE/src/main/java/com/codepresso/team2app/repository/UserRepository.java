package com.codepresso.team2app.repository;

import com.codepresso.team2app.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
  void save(User user);
  User findByEmail(String email);
}
