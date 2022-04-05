package com.codepresso.team2app.service;

import com.codepresso.team2app.repository.CommentRepository;
import com.codepresso.team2app.repository.HashTagRepositroy;
import com.codepresso.team2app.repository.PostRepository;
import com.codepresso.team2app.vo.Comment;
import com.codepresso.team2app.vo.HashTag;
import com.codepresso.team2app.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    PostRepository postRepository;
    CommentRepository commentRepository;
    HashTagRepositroy hashTagRepositroy;

    public boolean saveComment(Comment comment, Long id) {
        Integer result = commentRepository.saveComment(comment);
        postRepository.updateCountComment(id);
        return result == 1;
    }

    public boolean saveHashTag(HashTag hashTag) {
        Integer result = hashTagRepositroy.saveHashTag(hashTag);
        return result == 1;
    }
    public List<Comment> getAllComment() {
        List<Comment> commentList = commentRepository.findAllComment();
        return commentList;
    }

    public Comment getOneComment(Long id) {
        Comment comment = commentRepository.findOneComment(id);
        return comment;
    }

    public List<Comment> getPostComment(Long id) {
        List<Comment> commentList = commentRepository.findPostComment(id);
        return commentList;
    }

    public List<Comment> getFindPostCommentByPage(Long postId, Integer page, Integer size) {
        List<Comment> comments = commentRepository.findPostCommentByPage(postId, size, (page-1) * size);
        return comments;
    }

    public boolean noVisibleComment(Long commentId){
        Integer result = commentRepository.noVisibleComment(commentId);
        return result == 1;
    }
}
