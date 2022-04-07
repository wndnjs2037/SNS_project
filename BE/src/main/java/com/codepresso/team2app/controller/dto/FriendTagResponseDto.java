package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.FriendTag;
import lombok.Getter;

@Getter
public class FriendTagResponseDto {
    Long id;
    String tag_name;
    Long user_id;
    Long post_id;

    public FriendTagResponseDto(FriendTag friendTag) {
        this.id = friendTag.getId();
        this.tag_name = friendTag.getTag_name();
        this.user_id = friendTag.getUser_id();
        this.post_id = friendTag.getPost_id();
    }
}
