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

  public long login(LoginDto dto) {
    User user = userRepository.findByEmail(dto.getEmail());
    if (user.getPassword().equals(dto.getPassword())) {
      return user.getId();
    } else {
      return 0;
    }
  }
}
