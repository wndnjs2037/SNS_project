package com.codepresso.team2app.controller;

import com.codepresso.team2app.domain.User;
import com.codepresso.team2app.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    UserService userService;

    @GetMapping("/user")
    public User findById(@RequestParam("id") Long id){
        User user = userService.findById(id);
        return user;
    }

}
