package com.codepresso.team2app.service;

import com.codepresso.team2app.repository.*;
import com.codepresso.team2app.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;
    private HashTagRepositroy hashTagRepositroy;
    private FriendTagRepository friendTagRepository;
    private LikeRepository likeRepository;
    private TagPostRepository tagPostRepository;
    private CommentRepository commentRepository;


    public boolean savePost(Post post, HashTag hashTag){
        Integer result = postRepository.save(post, hashTag);
        hashTagRepositroy.saveHashTag(hashTag);
        return result == 1;
    }

    public boolean saveHashTag(HashTag hashTag){
        Integer result = hashTagRepositroy.saveHashTag(hashTag);
        return result == 1;
    }

    public boolean saveTagPost(TagPost tagPost){
        Integer result = tagPostRepository.saveTagPost(tagPost);
        return result == 1;
    }

    public boolean saveFriendTag(FriendTag friendTag){
        Integer result = friendTagRepository.saveFriendTag(friendTag);
        return result == 1;
    }
    public boolean saveOnlyPost(Post post){
        Integer result = postRepository.savePost(post);
        return result == 1;
    }

    public List<Post> getAllPost(long id) {
        return postRepository.findAllPost(id);
    }

    public List<Post> getAllPost() {
        return postRepository.findAllPost();
    }

    public boolean countSave(Like like) { //insert 쿼리
        Integer result = likeRepository.countSave(like);
        return result == 1; //True 반환
    }

//    public boolean updateLike(Post post){
//        Integer result = postRepository.updateLike(post);
//        return result == 1;
//    }


//    public Post getOnePost(Long id){
//        return postRepository.findOnePost(id);
//    }

    public List<Post> getOnePost(Long id){
        return postRepository.findOnePost(id);
    }

    public boolean updateContent(Post post) {
        Integer result = postRepository.updateContent(post);
        return result == 1;
    }

    public boolean noVisiblePost(Long id) {
        Integer result = postRepository.noVisiblePost(id);
        return result == 1;
    }

    public List<Post> getFindByAuthor(Long author){
        return postRepository.findByAuthor(author);
    }

    public List<Post> getFindByPagePost(Long userId, Integer page, Integer size) {
        return postRepository.findByPagePost(userId, size, (page-1) * size);
    }
}
