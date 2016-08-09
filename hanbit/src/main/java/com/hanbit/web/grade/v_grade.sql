drop view GrademMember cascade;

CREATE OR REPLACE VIEW GradeMember
AS
SELECT 
g.score_seq AS score_seq,
g.id AS id,
m.name AS name,
s.subj_name AS subject,
g.score AS score
FROM Member m, Grade g, Subject s
WHERE m.id = g.id and g.subj_seq = s.subj_seq;
-- fix 1
CREATE OR REPLACE VIEW Record
AS
SELECT 
g.score_seq AS seq, -- int
g.id AS id, -- varchar
m.name AS name, -- varchar
s.subj_name AS subject, -- varchar
g.score AS score, -- int
g.exam_date AS examDate,  -- varchar
s.prof_id AS prof_id, -- varchar
a.name AS prof_name -- varchar
FROM Member m, Grade g, Subject s, Admin a
WHERE m.id = g.id   
AND g.subj_seq = s.subj_seq 
AND s.prof_id = a.id
GROUP BY g.score_seq;


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

 
select * from Record;
INSERT INTO GradeMember(hak, id, java,jsp,sql,spring,password,name,addr,birth) 
     VALUES (hak.nextval, 'park', 30,31,32,67,'1','박길동','북한',540101);
SELECT * FROM GradeMember WHERE hak = 9000127;
SELECT * FROM GradeMember WHERE name = '우길동';

select count(*) from GradeMember;