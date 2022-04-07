package com.codepresso.team2app.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;

@Getter
@Setter
@AllArgsConstructor
public class TagPost {
    Long id;
    Long postId;
    Long hashTagId;

    public TagPost(Long postId, Long hashTagId) {
        this.postId = postId;
        this.hashTagId = hashTagId;
    }
}
