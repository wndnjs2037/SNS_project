CREATE TABLE users
(
    id BIGINT AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id)
);

CREATE TABLE post
(
    id BIGINT AUTO_INCREMENT,
    author BIGINT NOT NULL, -- user_id
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    view VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(author) REFERENCES users(id)
);

CREATE TABLE comment
(
    id BIGINT AUTO_INCREMENT,
    author BIGINT NOT NULL, -- user_id
    content VARCHAR(255) NOT NULL,
    post_id BIGINT NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(author) REFERENCES users(id),
    FOREIGN KEY(post_id) REFERENCES post(id)
);

-- 소셜피드 테이블 
CREATE TABLE social_feed 
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  author BIGINT NOT NULL, -- users table (user_id)
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  post_id BIGINT NOT NULL, -- post table 
  other_id BIGINT NOT NULL, -- follow table 
  PRIMARY KEY(id),
  FOREIGN KEY(author) REFERENCES users(id),
  FOREIGN KEY(post_id) REFERENCES post(id)
  -- FOREIGN KEY(other_id) REFERENCES follow(id)  -> follow 테이블 생성 후 주석 제거 예정
);

-- 친구태그 테이블
CREATE TABLE friend_tag 
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  tag_name BIGINT NOT NULL,
  user_id BIGINT NOT NULL, -- users table (id)
  post_id BIGINT NOT NULL, -- post table 
  PRIMARY KEY(id),
  FOREIGN KEY(user_id) REFERENCES users(id),
  FOREIGN KEY(post_id) REFERENCES post(id)
);

-- 해시태그 테이블
create table hash_tag (
  id BIGINT not null AUTO_INCREMENT,
  tag_content VARCHAR(255) NOT NULL, 
  author BIGINT NOT NULL, -- users table (id)
  post_id BIGINT NOT NULL, -- post table
  PRIMARY KEY(id),
  FOREIGN KEY(author) REFERENCES users(id),
  FOREIGN KEY(post_id) REFERENCES post(id)
);


