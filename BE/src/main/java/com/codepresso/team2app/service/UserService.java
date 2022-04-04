package com.codepresso.team2app.service;

import com.codepresso.team2app.domain.User;
import com.codepresso.team2app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public void updateFollower(Long id) {
        userRepository.updateFollower(id);
    }

    public void updateFollowing(Long id) {
        userRepository.updateFollowing(id);
    }
}
