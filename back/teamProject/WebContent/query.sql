create table userTable(
idx int PRIMARY KEY,
id varchar(20) PRIMARY KEY,
password varchar(20),
name varchar(20),
nickname varchar(20),
major varchar(20)
type check,  /* 교사, 학생 구별*/
gender check,
start_date date,
reserved1 varchar(20),/*나중에*/
reserved2 varchar(20),/*추가 용*/
check(type in('teacher', 'student')),
CHECK(gender IN('he', 'she'))
);

 select * from userTable;

drop table userTable;

delete userTable;