<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>글쓰기</title>
</head>
<body>
	<form action="${context}/article/write" method="post">
	제목 : <input type="text" name="title" size="20" /><br />	
	작성자 : <input type="text" name="writeName" size="20" /><br />	
	글암호 : <input type="password" name="password" size="20" /><br />	
	글내용 : <br/>
	<textarea name="content" cols="40"	rows="5"></textarea>
		<br />
		<input type="submit" value="전송"/>
	</form>
</body>
</html>