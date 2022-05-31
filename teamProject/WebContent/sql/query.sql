create table userTable (
idx int,
userId varchar(20),
userPassword varchar(20),
userName varchar(20),
nickname varchar(20),
major varchar(20),
userType CHAR(5), --학생인지 교사인지
gender CHAR(5),
start_date date,
reserved1 varchar(20),--나중에
reserved2 varchar(20),--추가 용 
check(userType in('teacher', 'student')),
CHECK(gender IN('he', 'she')),
PRIMARY KEY(idx)
);

 select * from userTable;

drop table userTable;

delete userTable;