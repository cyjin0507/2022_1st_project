SELECT * FROM usertable;
SELECT * FROM boardtable where uidx = 1;
SELECT * FROM commenttable;
SELECT * FROM friendTable;

DELETE FROM usertable WHERE idx != 0;
DELETE FROM boardtable;
DELETE FROM commenttable WHERE idx != 0;
DELETE FROM friendTable WHERE idx != 0;

DROP TABLE userTable;
DROP TABLE boardtable;
DROP TABLE commenttable;
DROP TABLE friendTable;

INSERT INTO usertable VALUES (0, 'id', '비번', '이름', '닉네임','소개글', '010-1234-5678', 'mail', '전공','he', '2022-05-30', 'resources/upload/imageProfile/defaultProfile.jpeg', null, null);
INSERT INTO boardtable VALUES (0, 0, '태그', 'test  내용','image 경로','2022-06-02',null, null);
INSERT INTO commenttable VALUES(0, 0, 0, 'test', '2022-06-07', null, null);

/* 로그인 and 회원가입 용  */
create table userTable (
idx int not null,
userId varchar(20) not null, --id
userPassword varchar(20) not null, -- 비번
userName varchar(20) not null, -- 이름
nickname varchar(20) not null, -- 닉네임
introduce varchar(200), -- 자기소개
phoneNumber VARCHAR(20),-- 전호번호
mail varchar(30), -- 메일
major varchar(20) not null, -- 전공
gender CHAR(10) not null, -- 성별
start_date date,
userProfile VARCHAR(2000), -- 프사 경로
reserved1 varchar(20),--나중에
reserved2 varchar(20),--추가 용
CHECK(gender IN('he', 'she')),
PRIMARY KEY (idx)
);

/* 게시물 용 */
CREATE TABLE boardTable(
idx int,
uidx int, -- userTable idx 값 가져오기
tage VARCHAR(20), --태그
userContent VARCHAR(200), --내용
image VARCHAR(2000) not null, --이미지 경로
create_date DATE, --날짜
reserved1 varchar(20),--나중에
reserved2 varchar(20),--추가 용
PRIMARY KEY (idx)
);

/* 댓글 용 */
CREATE TABLE commentTable(
idx int,
uidx int, -- userTable idx 값 가져오기
bidx int, -- boardTable idx 값 가져오기
commentContent varchar(200) not null, -- 댓글 내용 
create_date date, -- 댓글 쓴 날짜
reserved1 varchar(20), --나중에
reserved2 varchar(20), --추가 용
PRIMARY KEY (idx)
);

/* 팔로우 */


/* A.I? usertable*/
INSERT INTO usertable VALUES (0, 'id', '비번', '이름', '닉네임','소개글', '010-1234-5678', 'mail', '전공','he', '2022-05-30', 'resources/upload/imageProfile/defaultProfile.jpeg', null, null);
INSERT INTO usertable VALUES (1, 'id_1', '1234', 'name_1', '닉네임_1','소개글', '010-1234-5678', 'mail', '전공','he', sysdate, 'resources/upload/imageProfile/defaultProfile.jpeg', 'ai', null);
INSERT INTO usertable VALUES (2, 'id_2', '1234', 'name_2', '닉네임_2','소개글', '010-1234-5678', 'mail', '전공','he', sysdate, 'resources/upload/imageProfile/defaultProfile.jpeg', 'ai', null);
INSERT INTO usertable VALUES (3, 'id_3', '1234', 'name_3', '닉네임_3','소개글', '010-1234-5678', 'mail', '전공','he', sysdate, 'resources/upload/imageProfile/defaultProfile.jpeg', 'ai', null);
INSERT INTO usertable VALUES (4, 'id_4', '1234', 'name_4', '닉네임_4','소개글', '010-1234-5678', 'mail', '전공','he', sysdate, 'resources/upload/imageProfile/defaultProfile.jpeg', 'ai', null);

/* A.I? boardtable*/
INSERT INTO boardtable VALUES (0, 0, '태그', 'test  내용','image 경로','2022-06-02',null, null);
INSERT INTO boardtable VALUES (1, 1, '태그', '1학년 팀플 사진임','resources/upload/imageProfile/1_1.png','2022-06-02',null, null);
INSERT INTO boardtable VALUES (2, 1, '태그', '최서윤_그림','183f20641e785699.jpg', sysdate, null, null);
INSERT INTO boardtable VALUES (3, 2, '태그', '1학년 팀플 사진임_2','2_1.png',sysdate,null, null);
INSERT INTO boardtable VALUES (4, 2, '태그', '1학년 팀플 사진임_3','3_1.png',sysdate,null, null);

insert into friendTable values(1, 2, 3, 'true', '2022-02-20');
drop table friendTable;

CREATE TABLE friendTable(
idx int,
follow int,
followers int,
suggestion varchar(20),
create_date date,
PRIMARY KEY (idx)
);


select * from userTable;
select * from boardTable;

insert into friendTable values(2, 2, 3, 'true', '2022-02-20');

select DISTINCT u.* from userTable u, friendTable f WHERE u.idx != 1 and (u.idx != f.follow or u.idx != f.followers) and f.suggestion = 'true';

SELECT * FROM usertable where idx = '1' 


