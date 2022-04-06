package com.codepresso.team2app.controller;

import com.codepresso.team2app.controller.dto.LoginDto;
import com.codepresso.team2app.controller.dto.ProfileRequestDto;
import com.codepresso.team2app.domain.User;
import com.codepresso.team2app.service.CommentService;
import com.codepresso.team2app.service.LoginService;
import com.codepresso.team2app.service.PostService;
import com.codepresso.team2app.service.UserService;
import com.codepresso.team2app.vo.Comment;
import com.codepresso.team2app.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
  private PostService postService;
  private LoginService loginService;
  private CommentService commentService;
  private UserService userService;

  public IndexController(PostService postService, LoginService loginService, CommentService commentService, UserService userService) {
    this.postService = postService;
    this.loginService = loginService;
    this.commentService = commentService;
    this.userService = userService;
  }

  Long myId;

  @PostMapping("/login")
  public RedirectView loginApi(LoginDto dto){
    myId = loginService.login(dto);
    long userId = myId;
    if(userId != 0) {
      return new RedirectView("/main?id=" + userId + "&page=1");
    }
    else {
//      redirectAttributes.addAttribute("message", "아이디 혹은 비밀번호가 틀립니다.");
      return new RedirectView("/login");
    }
  }

  @GetMapping("/login")
  public String login(){
    return "login";
  }

  @GetMapping("/main")
  public String index(Model model, long id) {
    List<Post> postList = postService.getFindByPagePost(id, 1, 3);

    List<List<Comment>> commentList = new ArrayList<>();
    for(int i = 0; i < postList.size(); i++){
      long postId = postList.get(i).getId();
      List<Comment> comments = commentService.getFindPostCommentByPage(postId, 0, 3);
      while(!comments.isEmpty()){
        commentList.add(comments);
        break;
      }
    }
    model.addAttribute("userId", myId);
    model.addAttribute("postList", postList);
    model.addAttribute("commentList", commentList);
    return "main";
  }

  @GetMapping("/profile")
  public String profile(Model model, long id) {
    long userId = myId;
    List<Post> postList = postService.getFindByAuthor(id);
    User user = userService.findById(id);
    model.addAttribute("user", user);
    model.addAttribute("postList", postList);
    model.addAttribute("myId", myId);
    return "profile";
  }

  @PatchMapping("/profile/{id}")
  public String updateProfile(long id, ProfileRequestDto dto){
    userService.updateProfile(id, dto);
    return "profile";
  }
}
