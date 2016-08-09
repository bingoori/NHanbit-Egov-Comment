drop view Record cascade;

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
-- int
-- varchar
-- varchar
-- varchar
-- int
-- varchar

-- ANSI JOIN(Natural JOIN)
SELECT 
g.score_seq AS score_seq,
g.id AS id,
m.name AS name,
g.score AS score
FROM Member m NATURAL JOIN Grade g NATURAL JOIN Subject s 

-- ANSI JOIN(USING)
SELECT 
g.score_seq AS score_seq,
g.id AS id,
m.name AS name,
g.score AS score
FROM Member m JOIN Grade g 
USING (id);


SELECT * FROM Subject;
select * from Record;
select * from GradeMember
where name = '홍길동';

INSERT INTO GradeMember(hak, id, java,jsp,sql,spring,password,name,addr,birth) 
     VALUES (hak.nextval, 'park', 30,31,32,67,'1','박길동','북한',540101);
SELECT * FROM GradeMember WHERE hak = 9000127;
SELECT * FROM GradeMember WHERE name = '우길동';

select count(*) from GradeMember;

		SELECT 
		seq,
		score,
		id,
		name,
		subject,
		examDate,
		prof_id,
		prof_Name 
		FROM Record 
		WHERE id = 'woo'; 
		
		


select * from subject;
UPDATE Record set score = 60 WHERE id = 'woo' AND examDate = '2016-03-31' AND subject='java';
DELETE FROM Grade WHERE id = 'hong'
DELETE FROM Member WHERE id = 'woo'

select * from Grade;
select * from Member;
 
 

--DELETE Grade, Member FROM Grade INNER JOIN  Member
--WHERE Grade.id = Member.id 
select * from Record 
where id = 'woo' AND examDate = '2016-03-31';
DELETE FROM Grade where score_seq = 29; 
 -- 29~37
 select * from Grade;

INSERT INTO Member(id,password,name,addr,birth,cate) 
VALUES ('song','1','송중기','우르크',800101,1);
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date) 
VALUES (score_seq,'song',4,54,'2016-03-31');

select * from Member WHERE id = 'woo';
select * from grade;
WHERE m.id = g.id and g.subj_seq = s.subj_seq;
-- fix 2
CREATE OR REPLACE VIEW Record
AS
SELECT 
g.score_seq AS seq, -- int
g.id AS id, -- varchar
m.name AS name, -- varchar
s.subj_name AS subject, -- varchar
g.score AS score, -- int
g.exam_date AS exam_date  -- varchar
FROM Member m, Grade g, Subject s
WHERE m.id = g.id and g.id = 'woo' 
AND g.subj_seq = s.subj_seq
AND g.exam_date = '2016-03-31'
GROUP BY s.subj_name;

-- GROUP BY & HAVING 예제
CREATE OR REPLACE VIEW Record
AS
SELECT 
g.score_seq AS seq, -- int
g.id AS id, -- varchar
m.name AS name, -- varchar
s.subj_name AS subject, -- varchar
g.score AS score, -- int
g.exam_date AS exam_date  -- varchar
FROM Member m, Grade g, Subject s
WHERE m.id = g.id and g.id = 'woo'  
AND g.exam_date = '2016-03-31'
GROUP BY s.subj_name
HAVING score is not null;
