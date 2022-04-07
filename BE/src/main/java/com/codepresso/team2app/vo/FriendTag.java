package com.codepresso.team2app.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendTag {
    Long id;
    String tag_name;
    Long user_id;
    Long post_id;

    public FriendTag(String tag_name, Long user_id, Long post_id) {
        this.tag_name = tag_name;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public FriendTag(Long id, String tag_name, Long user_id, Long post_id) {
        this.id = id;
        this.tag_name = tag_name;
        this.user_id = user_id;
        this.post_id = post_id;
    }
}
