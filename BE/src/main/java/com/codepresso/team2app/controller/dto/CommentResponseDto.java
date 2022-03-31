package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.Comment;
import com.codepresso.team2app.vo.Post;
import lombok.Getter;

import java.util.Date;

@Getter
public class CommentResponseDto {
    Long id;
    Long author;
    String content;
    Long postId;
    Date createdAt;
    Long countLiked;
    Boolean isVisible;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.content =comment.getContent();
        this.postId = comment.getPostId();
        this.createdAt = comment.getCreatedAt();
        this.countLiked = comment.getCountLiked();
        this.isVisible = comment.getIsVisible();
    }
}
