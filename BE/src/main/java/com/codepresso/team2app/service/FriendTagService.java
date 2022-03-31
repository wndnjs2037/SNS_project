package com.codepresso.team2app.service;

import com.codepresso.team2app.repository.FriendTagRepository;
import com.codepresso.team2app.vo.FriendTag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FriendTagService {
    private FriendTagRepository friendTagRepository;

    public List<FriendTag> getAllFriendTag(){
        return friendTagRepository.findFriendTag();
    }
}
