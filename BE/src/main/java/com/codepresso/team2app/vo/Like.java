package com.codepresso.team2app.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter  //getter setter 자동생성
@AllArgsConstructor
public class Like {
    Long id;
    Long user_id;
    Long article_id;

    public Like(Long user_id, Long article_id) {
        this.user_id = user_id;
        this.article_id = article_id;
    }


}
