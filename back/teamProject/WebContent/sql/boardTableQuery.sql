CREATE TABLE boardTable(
idx int,
uidx int,
title VARCHAR(20),
tage VARCHAR(20),
userContent VARCHAR(20), --내용
image VARCHAR(2000) not null, --이미지 경로
image_type CHAR(10), --사진 or 동영상
create_date DATE, --날짜
reserved1 varchar(20),--나중에
reserved2 varchar(20),--추가 용
CHECK(image_type IN('image', 'video')),
PRIMARY KEY (idx)
);

select * from BOARDTABLE;

--INSERT INTO boardtable VALUES (0, 0, '제목', '태그', '내용','/image_test/defaultProfile.jpeg','image','2022-05-30','','');

