package com.codepresso.team2app.controller;

import com.codepresso.team2app.service.LoginService;
import com.codepresso.team2app.service.dto.request.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginDto dto) {
    if (loginService.login(dto)) {
      return ResponseEntity.ok("로그인 성공");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인 실패");
  }
}
