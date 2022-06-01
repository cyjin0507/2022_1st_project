create table userTable (
idx int not null,
userId varchar(20) not null,
userPassword varchar(20) not null,
userName varchar(20) not null,
nickname varchar(20) not null,
major varchar(20) not null,
userType CHAR(10) not null, --학생인지 교사인지
gender CHAR(10) not null,
start_date date,
reserved1 varchar(20),--나중에
reserved2 varchar(20),--추가 용 
check(userType in('teacher', 'student', '관리자')),
CHECK(gender IN('he', 'she')),
PRIMARY KEY (idx)
);

CREATE TABLE boardTable(
idx int,
uidx int,
title VARCHAR(30),
tage VARCHAR(20),
content VARCHAR(200),
images VARCHAR(20),
images_type VARCHAR(20),
crate_date date,
reserved1 varchar(20),--나중에
reserved2 varchar(20),--추가 용
PRIMARY KEY (idx)
);

select * from boardTable;
drop table boardTable;
delete boardTable;

select * from userTable;
drop table userTable;
delete userTable;