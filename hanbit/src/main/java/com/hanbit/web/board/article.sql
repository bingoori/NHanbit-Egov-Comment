CREATE TABLE Id_sequence(
	sequence_name VARCHAR(10) NOT NULL,
	next_value INT NOT NULL,
	PRIMARY KEY (sequence_name)
);

INSERT INTO Id_sequence values ('article',0);

SELECT * FROM Id_sequence;

drop table id_sequence;

CREATE TABLE Reply(
 	reply_seq INT NOT NULL AUTO_INCREMENT,
 	reply VARCHAR(1000),
 	article_id INT,
	reply_date DATETIME ,
 	PRIMARY KEY(reply_seq)
);
ALTER TABLE Reply ADD COLUMN reply_date DATETIME;
truncate Reply 

update Reply set reply_date = now();
select * from Reply;

		SELECT reply, 
		DATE_FORMAT(reply_date,'%Y-%m-%d') AS replyDate
		FROM Reply WHERE article_id = 19
		
select * from Article;
select reply FROM Reply WHERE article_id = 10;
truncate table Reply;
		INSERT INTO Reply
		(reply,article_id)
		VALUES ('asdfasdf',1)
	SELECT reply FROM Reply WHERE article_id = '10';
 
		
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
	
	select * from article;
	SELECT  title,writer_name,password,content FROM Article;
	
			SELECT article_id AS articleId,
			group_id AS groupId,
			sequence_no AS sequenceNo,
			DATE_FORMAT(posting_date,'%Y-%m-%d') AS postingDate,
			read_count AS readCount,
			writer_name AS writerName,
			password,
			title
		FROM Article 
			ORDER BY sequence_no 
			DESC LIMIT 0, 10
		
	
	    INSERT INTO Article
		(group_id,sequence_no,posting_date,read_count,writer_name,password,title,content)
		VALUES (1,'abcd',now(),0,'bingoori','1234','title','test')
		
		select 
		article_id AS articleId,
		group_id AS groupId,
		DATE_FORMAT(posting_date,'%Y-%m-%d') AS postingDate,
		read_count AS readCount,
		writer_name AS writerName,
		password,
		title
		from Article 
		where article_id='2';
		
		
		SELECT article_id AS articleId,
			group_id AS groupId,
			sequence_no AS sequenceNo,
			DATE_FORMAT(posting_date,'%Y-%m-%d') AS postingDate,
			read_count AS readCount,
			writer_name AS writerName,
			password,
			title
		FROM Article 
			WHERE title LIKE CONCAT('%','a','%')
			ORDER BY sequence_no 
			DESC LIMIT 0, 10
		
			SELECT * FROM Article;
			                            
			delete from Article where article_id = 5;

			update Article 
			set title= 'ambasa',
			writer_name= '1234',
			password= '1234',
			content= '1234',
			posting_date = now()
			where article_id = 5;