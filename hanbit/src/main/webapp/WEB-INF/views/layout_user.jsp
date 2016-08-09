<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8" />
	<title>성적관리</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
</head>
 <body>
	<div id="header">
		  <tiles:insertAttribute name="header" />
	</div>
	<div id="content">
		<tiles:insertAttribute name="content" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
 </body>

<script src="${js}/Admin.js"></script>
<script src="${js}/Article.js"></script>
<script src="${js}/Global.js"></script>
<%-- <script src="${js}/Grade.js"></script>--%>
<script src="${js}/Member.js"></script> 
<script src="${js}/Habit.js"></script>
<script type="text/javascript">
	$(function() {
		var context = $.fn.global('${context}').getContext();
		var article = $.fn.article();
		var member = $.fn.member();
		
		$('#article_all').click(function(e) {
			e.preventDefault();
			article.articleAll(context,1);
		});
		$('#logout').click(function(e) {
			e.preventDefault();
			location.href ='${context}/member/logout';
			});  
		$('#my_article').click(function(e) {
			e.preventDefault();
			article.myArticle(context);
		});
		$('#updateBtn').click(function(e) {
			e.preventDefault();
			member.updateForm(context);
		});
		$('#join').click(function(e) {
			e.preventDefault();
			alert('회원가입 시도');
			member.joinForm(context);
		});
		$('#board').click(function() {
			//article.init(context);	
		});
	});
</script>
</html>
