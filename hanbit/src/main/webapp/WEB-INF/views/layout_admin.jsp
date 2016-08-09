<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>성적관리</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="content"> 
		<tiles:insertAttribute name="content" />
	</div>
	<div id="footer" style="text-align: center">
		<tiles:insertAttribute name="footer" />
	</div>


</body>
<script src="${js}/subject.js"></script>
<script src="${js}/admin.js"></script>
<script src="${js}/member.js"></script>
<script src="${js}/Global.js"></script>
<script src="${js}/record.js"></script>
<script type="text/javascript">
	$(function() {
		var global = new Global('${context}');
		//var context = '${context}';
		$('#recordMgmt').click(function(e) {
			e.preventDefault();
			subject.init(global.getContext());
		});
		$('#memberMgmt').click(function(e) {
			e.preventDefault();
			member.init(global.getContext());
			});  
		$('#adminMgmt').click(function(e) {
			e.preventDefault();
			subject.init(global.getContext());
		});
		$('#subjectMgmt').click(function(e) {
			e.preventDefault();
			subject.init(global.getContext());
		});
	});
</script>
</html>
