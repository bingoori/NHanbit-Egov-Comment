
create table Subject(
	subj_seq int(5) primary key auto_increment,
	subj_name VARCHAR(30)
);
INSERT INTO Subject(subj_name) values('java');
INSERT INTO Subject(subj_seq,subj_name) values(subj_seq, 'jsp');
INSERT INTO Subject(subj_seq,subj_name) values(subj_seq, 'sql');
INSERT INTO Subject(subj_seq,subj_name) values(subj_seq, 'spring');

select * from Subject;
drop table Subject;

