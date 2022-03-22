package com.codepresso.team2app.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSession {
  private Integer Id;
  private String email;
  private String name;
  private LocalDateTime createdAt;
}
