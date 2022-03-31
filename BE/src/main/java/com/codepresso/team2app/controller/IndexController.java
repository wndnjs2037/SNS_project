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

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
public class IndexController {
  private PostService postService;
  private LoginService loginService;
  private CommentService commentService;

  @PostMapping("/login")
  public String loginApi(LoginDto dto, RedirectAttributes redirectAttributes){
    String params = loginService.login(dto);
    if(params == null){
      redirectAttributes.addAttribute("message", "아이디 혹은 비밀번호가 틀립니다.");
      return "redirect:/login";
    }
    return "redirect:/main" + params;
  }

  @GetMapping("/login")
  public String login(){
    return "login";
  }

  @GetMapping("/main")
  public String index(Model model, @RequestParam Long id) {
    List<Post> postList = postService.getAllPost(id);
    // 로그인을 누르면 Id 값을 넘겨줘야 함 (userId)
    // 로그인을 누르면 Id 값을 넘겨줘야 함 (postId)
    model.addAttribute("postList", postList);
    return "main";
  }

  @GetMapping("/profile")
  public String profile(Model model, long id) {
    List<Post> myPostList = postService.getFindByAuthor(id);
    model.addAttribute("myPostList", myPostList);
    return "profile";
  }
}
