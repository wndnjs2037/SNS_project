package com.codepresso.team2app.controller;

import com.codepresso.team2app.controller.dto.LoginDto;
import com.codepresso.team2app.service.CommentService;
import com.codepresso.team2app.service.LoginService;
import com.codepresso.team2app.service.PostService;
import com.codepresso.team2app.vo.Comment;
import com.codepresso.team2app.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
public class IndexController {
  private PostService postService;
  private LoginService loginService;
  private CommentService commentService;

  @PostMapping("/login")
  public RedirectView loginApi(LoginDto dto){
    long userId = loginService.login(dto);
    if(userId != 0){
      return new RedirectView("/main?id=" + userId);
    }
    return new RedirectView("/login");
  }

  @GetMapping("/login")
  public String login(){
    return "login";
  }

  @GetMapping("/main")
  public String index(Model model, long id) {
//    user 객체 넘겨줘야 함

    List<Post> postList = postService.getAllPost(id);
    // 로그인을 누르면 Id 값을 넘겨줘야 함 (userId)
//    Comment를 Post 객체에 넣어줌

    List<List<Comment>> commentList = new ArrayList<>();
    for(int i = 0; i < postList.size(); i++){
      long postId = postList.get(i).getId();
      List<Comment> comments = commentService.getPostComment(postId);
      while(!comments.isEmpty()){
        commentList.add(comments);
        System.out.println(comments.get(0).getContent());
        System.out.println(comments.get(1).getContent());
        break;
      }
    }
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
