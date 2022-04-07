package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.HashTag;
import com.codepresso.team2app.vo.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagRequestDto {
    Long id;
    String tagContent;
    Long postId;
    Long commentId;

    public HashTag getPostHashTag(){
        return new HashTag(this.id, this.tagContent, this.postId, null);
    }

    public HashTag getCommentTag(){
        return new HashTag(this.id, this.tagContent, null, this.commentId);
    }
}
