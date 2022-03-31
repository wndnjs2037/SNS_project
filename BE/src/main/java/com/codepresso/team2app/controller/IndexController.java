package com.codepresso.team2app.controller;

import com.codepresso.team2app.service.CommentService;
import com.codepresso.team2app.service.PostService;
import com.codepresso.team2app.vo.Comment;
import com.codepresso.team2app.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class IndexController {
  private PostService postService;
  private CommentService commentService;

  @GetMapping("/main")
  public String index(Model model, long id, long postId) {
    List<Post> postList = postService.getAllPost(id);
    // 로그인을 누르면 Id 값을 넘겨줘야 함 (userId)
    List<Comment> commentList = commentService.getPostComment(postId);
    // 로그인을 누르면 Id 값을 넘겨줘야 함 (postId)
    model.addAttribute("postList", postList);
    model.addAttribute("commentList", commentList);
    return "main";
  }

  @GetMapping("/profile")
  public String profile(Model model, long id) {
    List<Post> myPostList = postService.getFindByAuthor(id);
    model.addAttribute("myPostList", myPostList);
    return "profile";
  }
}
