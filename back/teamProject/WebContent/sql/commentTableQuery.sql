CREATE TABLE commentTable(
idx int,
uidx int,
bidx int,
commentContent varchar(200) not null, -- 댓글 내용 
create_date date, -- 댓글 쓴 날짜
reserved1 varchar(20), --나중에
reserved2 varchar(20), --추가 용
PRIMARY KEY (idx)
);