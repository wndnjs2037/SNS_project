package com.codepresso.team2app.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
  private Integer id;
  private String email;
  private String name;
  private String password;
  private Boolean isActive;
  private LocalDateTime createdAt;
  private String profile;
  private Integer followingCount;
  private Integer followerCount;
}
