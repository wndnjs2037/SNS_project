package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.Like;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class LikeDto {

    private long articleId;
    private long userId;

    public Like toEntity() {
        return new Like(userId, articleId);
    }
}
