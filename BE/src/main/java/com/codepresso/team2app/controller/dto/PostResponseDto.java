package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.domain.User;
import com.codepresso.team2app.vo.Comment;
import com.codepresso.team2app.vo.Post;
import lombok.Getter;

import java.util.Date;
import java.util.List;

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
//    List<Comment> comment;
    String name;
    String email;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.author = post.getAuthor();
        this.content =post.getContent();
        this.createdAt = post.getCreatedAt();
        this.countLiked = post.getCountLiked();
        this.countRevogel = post.getCountRevogel();
        this.countComment = post.getCountComment();
        this.revogelPostId = post.getRevogelPostId();
        this.email = post.getUser().getEmail();
        this.name = post.getUser().getName();
    }
}
