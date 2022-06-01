select * from userTable;
delete userTable;
DROP TABLE userTable;

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

insert into userTable values(0,'test','test','test','test','test','관리자','he',SYSDATE-2	,null,null);