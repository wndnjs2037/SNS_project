package com.codepresso.team2app.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
  private Long id;
  private String email;
  private String name;
  private String password;
  private LocalDateTime createdAt;
  private Boolean isActive;
  private String profile;
  private Long followingCount;
  private Long followerCount;
}
