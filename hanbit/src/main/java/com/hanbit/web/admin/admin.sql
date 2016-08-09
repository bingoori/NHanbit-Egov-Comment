CREATE TABLE Admin(
	id VARCHAR(30) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(26) NOT NULL,
	addr VARCHAR(100),
	birth INT,
	role varchar(30) DEFAULT 'admin'
);

drop table Admin;

INSERT INTO Admin(id,password,name,addr,birth,role) 
VALUES ('admin','1','관리자','서울',800101,'admin');

INSERT INTO Admin(id,password,name,addr,birth,role) 
VALUES ('prof_kim','1','김교수','인천',800101,'prof');

INSERT INTO Admin(id,password,name,addr,birth,role) 
VALUES ('prof_lee','1','이교수','부천',851201,'prof');
INSERT INTO Admin(id,password,name,addr,birth,role) 
VALUES ('prof_choi','1','최교수','경기',700101,'prof');
INSERT INTO Admin(id,password,name,addr,birth,role) 
VALUES ('prof_woo','1','우교수','강원',900101,'prof');

select * from Admin;