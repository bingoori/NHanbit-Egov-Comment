<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="wrapper">
	<jsp:include page="list_table.jsp" />
</div>
<script src="${js}/article.js"></script>
<script type="text/javascript">
$(function() {
	
		article.setContext('${context}');
	$('#writeBtn').click(function() {
		/* $('.container').empty(); */ 
		article.writeForm();
		
		});
	
	$('#searchBtn').click(function() {
		/* var birth =$('input:text[name=birth]').val(); */
		
		$('#wrapper').load(context+'/article/list');	
		});
	$('.searchId').click(function() {
		article.detail($(this).attr('href'));
	});
	
	});
</script>