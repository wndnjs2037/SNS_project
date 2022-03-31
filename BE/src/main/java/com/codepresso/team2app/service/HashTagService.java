package com.codepresso.team2app.service;

import com.codepresso.team2app.repository.HashTagRepositroy;
import com.codepresso.team2app.vo.HashTag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HashTagService {
    private HashTagRepositroy hashTagRepositroy;

    public List<HashTag> getAllHashTag() {
       return hashTagRepositroy.findHashTag();
    }
}
