package com.codepresso.team2app.service;

import com.codepresso.team2app.repository.LikeRepository;
import com.codepresso.team2app.repository.PostRepository;
import com.codepresso.team2app.vo.Like;
import com.codepresso.team2app.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //생성자 자동 생성
public class LikeService {
    private LikeRepository likeRepository;
    private PostRepository postRepository;

    public boolean countSave(Like like) {
        Integer result = likeRepository.countSave(like);
        return result == 1; //True 반환
    }

    public boolean updateLike(Post post){
        Integer result = postRepository.updateLike(post);
        return result == 1;
    }


}
