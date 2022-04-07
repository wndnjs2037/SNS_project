package com.codepresso.team2app.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTag {
    Long id;
    String tagContent;
    Long postId;
    Long commentId;
    Long tagIdx;

    public HashTag(String tagContent, Long postId, Long commentId) {
        this.tagContent = tagContent;
        this.postId = postId;
        this.commentId = commentId;
    }

    public HashTag(Long id, String tagContent, Long postId, Long commentId) {
        this.id = id;
        this.tagContent = tagContent;
        this.postId = postId;
        this.commentId = commentId;
    }
}
