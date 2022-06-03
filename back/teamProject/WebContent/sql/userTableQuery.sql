select * from userTable;
delete userTable;
DROP TABLE userTable;

DELETE FROM usertable WHERE idx != 0;

--INSERT into usertable VALUES (0, 'test', 'test', 'test', 'test', '관리자', 'he', '2022-05-30', '/image_test/defaultProfile.jpeg', null, null);

create table userTable (
idx int not null,
userId varchar(20) not null, --id
userPassword varchar(20) not null, -- 비번
userName varchar(20) not null, -- 이름
nickname varchar(20) not null, -- 닉네임
major varchar(20) not null, -- 전공
userType CHAR(10) not null, --학생인지 교사인지
gender CHAR(10) not null, -- 성별
start_date date,
userProfile VARCHAR(2000), -- 프사 경로
reserved1 varchar(20),--나중에
reserved2 varchar(20),--추가 용
check(userType in('teacher', 'student', '관리자')),
CHECK(gender IN('he', 'she')),
PRIMARY KEY (idx)
);

