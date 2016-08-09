SELECT * FROM Test;

ALTER TABLE Member ADD COLUMN cate DECIMAL;
UPDATE Member SET cate = 1;

CREATE TABLE Member(
	id VARCHAR(30) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(26) NOT NULL,
	addr VARCHAR(100),
	birth DECIMAL,
	cate DECIMAL,
	profile_img varchar(100)
);
ALTER TABLE Member ADD COLUMN profile_img varchar(30);
select count(*) from Member;
select * from Member;
alter table Member MODIFY  profile_img varchar(250);
UPDATE Member set profile_img = 'default_profile.png'; 
UPDATE Member set profile_img = 'test_profile.png' where id = 'woo'; 
select * from Member where id = 'woo' and password = '1';
SELECT * FROM Member;
update Member set cate = 1 where id = 'choi';
update Member set cate = 1 where id = 'hong';
update Member set cate = 1 where id = 'woo';
delete from 
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('hong','1','홍길동','서울',800101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('woo','1','우길동','인천',900101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('ji','1','지길동','단양',880101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('cho','1','조길동','가양',700101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('choi','1','최길동','구로',950101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('choi2','1','최길동','종로',840101);

drop table Member cascade constraint;
 drop table Member 

--alter table Member DROP COLUMN major
--(subject varchar(100));
--alter table Member add
--(major varchar(100));

update Member SET subject ='java/jsp/sql/spring',major ='computer' where id = 'hong';
update Member SET subject ='java/jsp/sql/spring',major ='computer' where id = 'woo';
update Member SET subject ='java/jsp/sql/spring',major ='info' where id = 'ji';
update Member SET subject ='java/jsp/sql/spring',major ='info' where id = 'cho';
update Member SET subject ='java/jsp/sql/spring', major ='security' where id = 'choi';
update Member SET subject ='java/jsp/sql/spring', major ='security' where id = 'choi2';
