package com.codepresso.team2app.service;

import com.codepresso.team2app.controller.dto.LoginDto;
import com.codepresso.team2app.domain.User;
import com.codepresso.team2app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

  private final UserRepository userRepository;

  public String login(LoginDto dto) {
    User user = userRepository.findByEmail(dto.getEmail());
    String params = null;
    if(user.getEmail().equals(dto.getEmail()) &&
    user.getPassword().equals(dto.getPassword())){
      params = String.format("?id=%d", user.getId());
    }
    return params;
  }
}
