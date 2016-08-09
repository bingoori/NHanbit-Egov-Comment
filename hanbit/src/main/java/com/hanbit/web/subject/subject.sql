
SELECT 
	s.subj_seq AS subjSeq,
	s.subj_name AS subjName,
	s.prof_id AS profId,
	a.name AS profName
FROM Subject s, Admin a
WHERE s.prof_id = a.id;

create table Subject(
	subj_seq int(5) primary key auto_increment,
	subj_name VARCHAR(30),
	prof_id varchar(30)
	CONSTRAINT subj_admin_fk 
	foreign key prof_id 
	REFERENCES Admin(id) 
	 
);

ALTER TABLE Subject ADD COLUMN prof_id varchar(30);

ALTER TABLE Subject
ADD CONSTRAINT subj_admin_fk  
FOREIGN KEY prof_id REFERENCES Admin(id);


INSERT INTO Subject(subj_name) values('java');
INSERT INTO Subject(subj_seq,subj_name,prof_id) values(subj_seq, 'java','prof_kim');
INSERT INTO Subject(subj_seq,subj_name,prof_id) values(subj_seq, 'jsp','prof_kim');
INSERT INTO Subject(subj_seq,subj_name,prof_id) values(subj_seq, 'sql','prof_lee');
INSERT INTO Subject(subj_seq,subj_name,prof_id) values(subj_seq, 'spring','prof_lee');
INSERT INTO Subject(subj_seq,subj_name,prof_id) values(subj_seq, 'node.js','prof_choi');
INSERT INTO Subject(subj_seq,subj_name,prof_id) values(subj_seq, 'python','prof_choi');
INSERT INTO Subject(subj_seq,subj_name,prof_id) values(subj_seq, 'android','prof_woo');
INSERT INTO Subject(subj_seq,subj_name,prof_id) values(subj_seq, 'ajax','prof_woo');

UPDATE Subject SET prof_id = 'prof_kim'
WHERE subj_name = 'java' or subj_name = 'jsp';

UPDATE Subject SET prof_id = 'prof_lee'
WHERE subj_name = 'sql' or subj_name = 'spring';

UPDATE Subject SET prof_id = 'prof_choi'
WHERE subj_name = 'node.js' or subj_name = 'python';

UPDATE Subject SET prof_id = 'prof_woo'
WHERE subj_name = 'android' or subj_name = 'ajax';

select * from Subject;
drop table Subject;

