package com.codepresso.team2app.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
    Long id;
    Long author;
    String content;
    Long postId;
    Date createdAt;
    Long countLiked;
    Boolean isVisible;
    Long idx;
    String email;
    String name;

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

    public Comment(Long id, Long author, String content, Long postId, Date createdAt, Long countLiked, Boolean isVisible, String email, String name) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.postId = postId;
        this.createdAt = createdAt;
        this.countLiked = countLiked;
        this.isVisible = isVisible;
        this.email = email;
        this.name = name;
    }
}
