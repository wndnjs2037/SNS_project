package com.codepresso.team2app.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment {
    Long id;
    Long author;
    String content;
    Long postId;
    Date createdAt;
    Long countLiked;
    Boolean isVisible;
    Long idx;

    public Comment() {
    }

    public Comment(Long id, Long author, String content, Long postId) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.postId = postId;
    }

    public Comment(Long id, Long author, String content, Long postId, Date createdAt, Long countLiked, Boolean isVisible) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.postId = postId;
        this.createdAt = createdAt;
        this.countLiked = countLiked;
        this.isVisible = isVisible;
    }
}
