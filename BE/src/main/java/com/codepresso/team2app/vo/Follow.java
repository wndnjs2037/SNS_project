package com.codepresso.team2app.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Follow {
    Long id;
    Long otherId;
    Long userId;

    public Follow() {
    }

    public Follow(Long otherId, Long userId) {
        this.otherId = otherId;
        this.userId = userId;
    }
}
