package com.codepresso.team2app.service;

import com.codepresso.team2app.repository.FollowRepository;
import com.codepresso.team2app.vo.Follow;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowService {
    FollowRepository followRepository;

    public boolean saveFollow(Follow follow) {
        Integer result = followRepository.saveFollow(follow);
        return result == 1;
    }

    public boolean deleteFollowing(Long otherId, Long userId) {
        Integer result = followRepository.cancelFollowing(otherId, userId);
        return result == 1;
    }
}
