insert into users(email, name, password, profile_message)
values ('1@codepresso.kr', 'user1', '1111',  'hello');
insert into users(email, name, password, profile_message)
values ('2@codepresso.kr', 'user2', '2222',  'hello');
insert into users(email, name, password, profile_message)
values ('3@codepresso.kr', 'user3', '3333',  'hello');
insert into users(email, name, password, profile_message)
values ('4@codepresso.kr', 'user4', '4444',  'hello');
insert into users(email, name, password, profile_message)
values ('5@codepresso.kr', 'user5', '5555',  'hello');
insert into users(email, name, password, profile_message)
values ('6@codepresso.kr', 'user6', '6666',  'hello');
insert into users(email, name, password, profile_message)
values ('7@codepresso.kr', 'user7', '7777',  'hello');
insert into users(email, name, password, profile_message)
values ('8@codepresso.kr', 'user8', '8888',  'hello');

insert into post(content, author)
values ('my name is code', 1);
insert into post(content, author)
values ('hi code', 2);
insert into post(content, author)
values ('my name is code3', 3);
insert into post(content, author)
values ('hi code4', 4);
insert into post(content, author)
values ('my name is code5', 5);
insert into post(content, author)
values ('hi code6', 6);
insert into post(content, author)
values ('my name is code7', 7);
insert into post(content, author)
values ('hi code8', 8);


insert into comment(author, content, post_id)
values (1, 'hi', 1);
insert into comment(author, content, post_id)
values (2, 'hello', 1);
insert into comment(author, content, post_id)
values (1, 'hello~', 2);
insert into comment(author, content, post_id)
values (2, 'hi!!', 2);

insert into follow(user_id, other_id)
values (1,2);
insert into follow(user_id, other_id)
values (1, 3);
insert into follow(user_id, other_id)
values (1,4);
insert into follow(user_id, other_id)
values (1,5);
insert into follow(user_id, other_id)
values (1,6);
insert into follow(user_id, other_id)
values (1,7);
insert into follow(user_id, other_id)
values (2,1);
