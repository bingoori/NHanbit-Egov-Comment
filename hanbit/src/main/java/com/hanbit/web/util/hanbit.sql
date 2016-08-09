show tables;
SHOW databases;
user 
CREATE TABLE Member(
	id VARCHAR(30) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(26) NOT NULL,
	addr VARCHAR(100),
	birth DECIMAL,
	cate DECIMAL,
	profile_img varchar(100)
);

CREATE TABLE Admin(
	id VARCHAR(30) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(26) NOT NULL,
	addr VARCHAR(100),
	birth INT,
	role varchar(30) DEFAULT 'admin'
);

create table Subject(
	subj_seq int(5) primary key auto_increment,
	subj_name VARCHAR(30)
);
ALTER TABLE Subject ADD COLUMN prof_id varchar(30);
ALTER TABLE Subject
ADD FOREIGN KEY(prof_id)
REFERENCES Admin(id);

create table Grade(
	score_seq int PRIMARY KEY auto_increment,
	id VARCHAR(30),
	subj_seq int ,
	score int ,
	exam_date varchar(15),
	constraint  grade_member_fk foreign key(id)
	references Member(id) ,
	constraint grade_subject_fk foreign key(subj_seq) 
	references Subject(subj_seq) 
);

CREATE OR REPLACE VIEW Record
AS
SELECT 
g.score_seq AS score_seq, 
g.id AS id, 
m.name AS name,  
s.subj_name AS subject, 
g.score AS score, 
g.exam_date  AS examDate  
FROM Member m, Grade g, Subject s
WHERE m.id = g.id and g.subj_seq = s.subj_seq;

CREATE TABLE Article(
	article_id INT NOT NULL AUTO_INCREMENT,
	group_id INT NOT NULL,
	sequence_no CHAR(16) NOT NULL,
	posting_date DATETIME NOT NULL,
	read_count INT NOT NULL,
	writer_name VARCHAR(20) NOT NULL,
	password VARCHAR(10),
	title VARCHAR(100),
	content TEXT,
	PRIMARY KEY(article_id),
	INDEX(sequence_no)
	);

CREATE TABLE Reply(
 	reply_seq INT NOT NULL AUTO_INCREMENT,
 	reply VARCHAR(1000),
 	article_id INT,
	reply_date DATETIME ,
 	PRIMARY KEY(reply_seq)
);
	
select * from Admin;

select * from Member;

INSERT INTO Member(id,password,name,addr,birth,cate,profile_img) 
VALUES ('hong','1','홍길동','서울',800101,1,"asdfasdf");
INSERT INTO Member(id,password,name,addr,birth,cate,profile_img) 
VALUES ('woo','1','우길동','인천',900101,1,"asdfasdf");