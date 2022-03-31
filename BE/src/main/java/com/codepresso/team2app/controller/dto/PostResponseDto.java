package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.Post;
import lombok.Getter;

import java.util.Date;

@Getter
public class PostResponseDto {
    Long id;
    Long author;
    String content;
    Date createdAt;
    Long countLiked;
    Long countRevogel;
    Long countComment;
    Long revogelPostId;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.author = post.getAuthor();
        this.content =post.getContent();
        this.createdAt = post.getCreatedAt();
        this.countLiked = post.getCountLiked();
        this.countRevogel = post.getCountRevogel();
        this.countComment = post.getCountComment();
        this.revogelPostId = post.getRevogelPostId();
    }
}
