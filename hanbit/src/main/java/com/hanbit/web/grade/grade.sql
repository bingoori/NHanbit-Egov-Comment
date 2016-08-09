
<!-- create table Grade(
	score_seq int PRIMARY KEY auto_increment,
	id VARCHAR(30),
	subj_seq int ,
	score int ,
	constraint  grade_member_fk foreign key(id)
	references Member(id) ON DELETE CASCADE,
	constraint grade_subject_fk foreign key(subj_seq) 
	references Subject(subj_seq) ON DELETE CASCADE
	
); -->
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
select * from Subject;
alter table Grade add COLUMN exam_date varchar(15);
drop table Grade;
select * from Grade;
truncate table Grade;

INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date) 
VALUES (score_seq,'hong',1,90,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'hong',2,80,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'hong',3,70,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'hong',4,60,'2016-03-31');

INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date) 
VALUES (score_seq,'woo',1,50,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'woo',2,50,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'woo',3,50,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'woo',4,50,'2016-03-31');

INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date) 
VALUES (score_seq,'choi',1,90,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'choi',2,90,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'choi',3,90,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'choi',4,90,'2016-03-31');

UPDATE Grade SET exam_date = '2016-03-31'; 
select * from Grade;


--INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
--VALUES (score_seq.nextval,'hong',90,90,90,90);
--INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)  
--VALUES (score_seq.nextval,'woo',80,80,80,80);
--INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
--VALUES (score_seq.nextval,'ji',70,70,70,70);
--INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
--VALUES (score_seq.nextval,'cho',60,60,60,60);
--INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
--VALUES (score_seq.nextval,'choi',50,50,50,50);
--INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
--VALUES (score_seq.nextval,'choi2',40,40,40,40);
update Grade set java = 20, sql = 30, jsp = 40, spring = 50
where hak = 9000002;
SELECT  * FROM Grade;
drop table Grade cascade constraints;
 truncate table Grade;
 select * from Grade
 delete from Grade where subj_seq ='4';
 