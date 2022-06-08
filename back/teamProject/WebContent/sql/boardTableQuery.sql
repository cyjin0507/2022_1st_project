CREATE TABLE boardTable(
idx int,
uidx int,
tage VARCHAR(20), --태그
userContent VARCHAR(20), --내용
image VARCHAR(2000) not null, --이미지 경로
image_type CHAR(10), --사진 or 동영상
create_date DATE, --날짜
reserved1 varchar(20),--나중에
reserved2 varchar(20),--추가 용
CHECK(image_type IN('image', 'video')),
PRIMARY KEY (idx)
);

