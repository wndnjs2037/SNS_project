package com.codepresso.team2app.repository;

import com.codepresso.team2app.domain.UserSession;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSessionRepository {
  UserSession findByEmail(String email);
  void save(String email, String name);
  void deleteByEmail(String email);
}
