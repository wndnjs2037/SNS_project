package com.codepresso.team2app.controller;

import com.codepresso.team2app.controller.dto.HashTagResponseDto;
import com.codepresso.team2app.service.HashTagService;
import com.codepresso.team2app.vo.HashTag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class HashTagController {
    private HashTagService hashTagService;

    @GetMapping("/HashTag")
    public List<HashTagResponseDto> getAllHashTag() {
        List<HashTag> hashTagList = hashTagService.getAllHashTag();
        List<HashTagResponseDto> hashTagResponseDto  = new ArrayList<>();
        for(HashTag hashTag : hashTagList){
            hashTagResponseDto.add(new HashTagResponseDto(hashTag));
        }

        return hashTagResponseDto;
    }
}
