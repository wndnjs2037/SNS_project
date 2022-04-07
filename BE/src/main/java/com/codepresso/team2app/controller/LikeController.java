package com.codepresso.team2app.controller;

import com.codepresso.team2app.controller.dto.LikeDto;
import com.codepresso.team2app.service.LikeService;
import com.codepresso.team2app.vo.Like;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LikeController {

    private LikeService likeService;

    @PostMapping("/like")
    public Long handleLike(@RequestBody LikeDto request) {
        return likeService.handleLike(request);
    }

}
