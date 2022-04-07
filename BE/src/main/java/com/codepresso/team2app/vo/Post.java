package com.codepresso.team2app.vo;

import com.codepresso.team2app.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    Long id;
    Long author;
    String content;
    Date createdAt;
    Long countLiked;
    Long countRevogel;
    Long countComment;
    Long revogelPostId;
    Boolean isVisible;
    Long idx;
    User user;

    public Post(Long id, Long author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public Post(Long id, Long author, String content, Date createdAt, Long countLiked, Long countRevogel, Long countComment, Long revogelPostId, Boolean isVisible) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
        this.countLiked = countLiked;
        this.countRevogel = countRevogel;
        this.countComment = countComment;
        this.revogelPostId = revogelPostId;
        this.isVisible = isVisible;
    }

    public Post(Long id, Long author, String content, Date createdAt, Long countLiked, Long countRevogel, Long countComment, Long revogelPostId, Boolean isVisible, String email, String name) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
        this.countLiked = countLiked;
        this.countRevogel = countRevogel;
        this.countComment = countComment;
        this.revogelPostId = revogelPostId;
        this.isVisible = isVisible;
        this.user = new User(email, name);
    }

    public void postInfo(){
        System.out.println("id " + this.id);
        System.out.println(this.getId());
        System.out.println("author " + this.author);
        System.out.println(this.getAuthor());
    }
}
