package com.codepresso.team2app.controller;

import com.codepresso.team2app.service.FollowService;
import com.codepresso.team2app.vo.Follow;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class FollowController {
    FollowService followService;

    @PostMapping("/follow")
    public String saveFollow(@RequestBody Follow follow) {
        followService.saveFollow(follow);
        return "Success";
    }

    @DeleteMapping("/follow")
    public String deleteFollowing(@RequestParam("otherId") Long otherId, @RequestParam("userId") Long userId) {
        followService.deleteFollowing(otherId, userId);
        return "Success";
    }
}
