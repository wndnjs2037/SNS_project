package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.HashTag;
import lombok.Getter;

@Getter
public class HashTagResponseDto {
    Long id;
    String tagContent;
    Long postId;
    Long commentId;

    public HashTagResponseDto(HashTag hashTag) {
        this.id = hashTag.getId();
        this.tagContent = hashTag.getTagContent();
        this.postId =  hashTag.getPostId();
        this.commentId = hashTag.getCommentId();
    }
}
