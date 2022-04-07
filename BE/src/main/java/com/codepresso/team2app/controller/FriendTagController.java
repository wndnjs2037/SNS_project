package com.codepresso.team2app.controller;

import com.codepresso.team2app.controller.dto.FriendTagResponseDto;
import com.codepresso.team2app.service.FriendTagService;
import com.codepresso.team2app.vo.FriendTag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class FriendTagController {
    private FriendTagService friendTagService;

    @GetMapping("/FriendTag")
    public List<FriendTagResponseDto> getAllFriendTag() {
        List<FriendTag> friendTagList = friendTagService.getAllFriendTag();
        List<FriendTagResponseDto> friendTagResponseDtos = new ArrayList<>();
        for (FriendTag friendTag : friendTagList ) {
            friendTagResponseDtos.add(new FriendTagResponseDto(friendTag));
        }
        return friendTagResponseDtos;
    }

}
