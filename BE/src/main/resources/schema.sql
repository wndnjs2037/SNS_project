-- 사용자
CREATE TABLE users
(
    id BIGINT not null AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    profile_message VARCHAR(255) NOT NULL,
    following_count BIGINT NOT NULL DEFAULT 0,
    follower_count BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);

-- 글
CREATE TABLE post
(
    id BIGINT AUTO_INCREMENT,
    author BIGINT NOT NULL, -- user_id
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    count_liked BIGINT NOT NULL DEFAULT 0,
    count_revogel BIGINT NOT NULL DEFAULT 0,
    count_comment BIGINT NOT NULL DEFAULT 0,
    revogel_post_id BIGINT,
    is_visible BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id),
    FOREIGN KEY(author) REFERENCES users(id)
);

-- 댓글
CREATE TABLE comment
(
    id BIGINT AUTO_INCREMENT,
    author BIGINT NOT NULL, -- user_id
    content VARCHAR(255) NOT NULL,
    post_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    count_liked BIGINT NOT NULL DEFAULT 0,
    is_visible BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id),
    FOREIGN KEY(author) REFERENCES users(id),
    FOREIGN KEY(post_id) REFERENCES post(id)
);


-- 팔로우
CREATE TABLE follow
(
    id bigint auto_increment NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    other_id BIGINT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY(other_id) REFERENCES users(id) ON DELETE CASCADE
);

-- 북마크
CREATE TABLE bookmark(
    bookmark_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    article_id BIGINT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY(article_id) REFERENCES post(id) ON DELETE CASCADE
);

-- 좋아요
CREATE TABLE likes(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    article_id BIGINT NOT NULL,
    UNIQUE KEY ukey_user_id_article_id (user_id, article_id),
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY(article_id) REFERENCES post(id) ON DELETE CASCADE
);

-- 소셜피드
CREATE TABLE social_feed
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    author BIGINT NOT NULL, -- users table (user_id)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    post_id BIGINT NOT NULL, -- post table
    follow_id BIGINT NOT NULL, -- follow table
    PRIMARY KEY(id),
    FOREIGN KEY(author) REFERENCES users(id),
    FOREIGN KEY(post_id) REFERENCES post(id),
    FOREIGN KEY(follow_id) REFERENCES follow(id)
);


-- 친구태그
CREATE TABLE friend_tag
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    tag_name VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL, -- users table (id)
    post_id BIGINT NOT NULL, -- post table
--     disable 추가
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(post_id) REFERENCES post(id)
);

-- 해시태그
create table hash_tag (
    id BIGINT not null AUTO_INCREMENT,
    tag_content VARCHAR(255) NOT NULL,
    post_id BIGINT, -- post table
    comment_id BIGINT, -- comment table
    --     disable 추가
    PRIMARY KEY(id),
    FOREIGN KEY(comment_id) REFERENCES comment(id)
);

-- 해시태그-글 매핑 테이블
CREATE TABLE tag_post
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    post_id BIGINT NOT NULL, -- post table (id)
    hashtag_id BIGINT NOT NULL, -- hash_tag table (id)
    PRIMARY KEY(id),
    FOREIGN KEY(post_id) REFERENCES post(id),
    FOREIGN KEY(hashtag_id) REFERENCES hash_tag(id)
);

CREATE TABLE images
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    img_path VARCHAR(260) NOT NULL,
    post_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(post_id) REFERENCES post(id),
    FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE revogel
(
  id BIGINT NOT NULL AUTO_INCREMENT, -- revogel 기본 id
  revogel_post_id BIGINT, -- revogel된 post의 id
  user_id BIGINT NOT NULL, -- revogel한 user의 id
  PRIMARY KEY(id),
  FOREIGN KEY(revogel_post_id) REFERENCES post(id),
  FOREIGN KEY(user_id) REFERENCES users(id)
);