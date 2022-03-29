package com.codepresso.team2app.controller;

import com.codepresso.team2app.controller.dto.HashTagRequestDto;
import com.codepresso.team2app.controller.dto.PostRequestDto;
import com.codepresso.team2app.controller.dto.PostResponseDto;
import com.codepresso.team2app.service.PostService;
import com.codepresso.team2app.vo.*;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public String createPost(@RequestBody @Validated PostRequestDto postRequestDto) {
        Post post = postRequestDto.getPost();
        postService.saveOnlyPost(post);
        long idx = post.getIdx();
        System.out.println(idx);

        HashTag hashTag;
        String content = post.getContent();

        Pattern hashTagPtn = Pattern.compile("\\#(\\S)*");
        Matcher hashTagMat = hashTagPtn.matcher(content);
        List<String> hashTags = new ArrayList<String>();

        while(hashTagMat.find()){
            hashTags.add(hashTagMat.group());
        }

        for (int i = 0; i < hashTags.size(); i++) {
            hashTag = new HashTag(hashTags.get(i).substring(1), idx, null);
            postService.saveHashTag(hashTag);
            Long tagIdx = hashTag.getTagIdx();
            TagPost tagPost = new TagPost(hashTag.getPostId(), tagIdx);
            // hashTag null나오는거 방지 필요
            postService.saveTagPost(tagPost);
        }

        FriendTag friendTag;
        Pattern friendTagPtn = Pattern.compile("\\@(\\S)*");
        Matcher friendTagMat = friendTagPtn.matcher(content);
        List<String> friendTags = new ArrayList<String>();

        while(friendTagMat.find()){
            friendTags.add(friendTagMat.group());
        }

        for (int i = 0; i < friendTags.size(); i++) {
            friendTag = new FriendTag(friendTags.get(i).substring(1), post.getAuthor(), idx);
            postService.saveFriendTag(friendTag);
        }

        return "success";
    }

    @GetMapping("/post/all")
    public List<PostResponseDto> getAllPostList(@RequestParam("id") Long id) {
        List<Post> postList = postService.getAllPost(id);
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for(Post post : postList){
            postResponseDtos.add(new PostResponseDto(post));
        }

        return postResponseDtos;
    }

    @GetMapping("/post")
    public List<Post> getOnePost(@RequestParam(name = "id")Long id) {
        List<Post> list = postService.getOnePost(id);
        return list;
    }

    @PutMapping("/post/like")
    public String updateLikeCount(@RequestParam("id") Long id) {
        List<Post> list = postService.getOnePost(id);

        Post post = list.get(0);
        post.postInfo();

        long like_id = 1;
        Like like;
        like = new Like(like_id, post.getId(), post.getAuthor());
        postService.countSave(like);

        postService.updateLike(post);
        return "Success";
    }

    @PutMapping("post")
    public String updatePostContent(@RequestBody PostRequestDto postRequestDto) {
        Post post = postRequestDto.getPost();
        postService.updateContent(post);
        return "success";
    }

    @PutMapping("post/delete")
    public String updateNoVisible(@RequestParam("id") Long id) {
        postService.noVisiblePost(id);
        return "Success";
    }

    @GetMapping("post/author")
    public List<Post> getFindByAuthor(@RequestParam("author") Long author) {
        List<Post> postList = postService.getFindByAuthor(author);
        return postList;
    }
}
