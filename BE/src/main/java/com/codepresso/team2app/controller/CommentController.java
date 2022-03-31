package com.codepresso.team2app.controller;

import com.codepresso.team2app.controller.dto.CommentRequestDto;
import com.codepresso.team2app.service.CommentService;
import com.codepresso.team2app.vo.Comment;
import com.codepresso.team2app.vo.HashTag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @PostMapping("/comment")
    public String createComment(@RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = commentRequestDto.getComment();
        commentService.saveComment(comment, comment.getPostId());
        long idx = comment.getIdx();
        System.out.println(idx);

        String content = comment.getContent();

        Pattern hashTagPtn = Pattern.compile("\\#(\\S)*");
        Matcher hashTagMat = hashTagPtn.matcher(content);
        List<String> hashTags = new ArrayList<String>();
        while(hashTagMat.find()){
            hashTags.add(hashTagMat.group());
        }

        for (int i = 0; i < hashTags.size(); i++) {
            HashTag hashTag = new HashTag(hashTags.get(i).substring(1), null, idx);
            commentService.saveHashTag(hashTag);
        }

        return "Success";
    }

    @GetMapping("/comment/all")
    public List<Comment> getAllComment() {
        List<Comment> commentList = commentService.getAllComment();
        return commentList;
    }

    @GetMapping("/comment")
    public Comment getOneComment(@RequestParam("id") Long id) {
        Comment comment = commentService.getOneComment(id);
        return comment;
    }

    @GetMapping("/comment/post")
    public List<Comment> getPostComment(@RequestParam("id") Long id) {
        List<Comment> commentList = commentService.getPostComment(id);
        return commentList;
    }
}
