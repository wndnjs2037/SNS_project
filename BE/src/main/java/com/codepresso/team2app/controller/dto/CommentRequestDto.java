package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.Comment;
import com.codepresso.team2app.vo.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentRequestDto {
    Long id;
    Long author;
    String content;
    Long postId;
    Date createdAt;
    Long countLiked;
    Boolean isVisible;

    public Comment getComment(){
        return new Comment(this.id, this.author, this.content, this.postId);
    }
}
