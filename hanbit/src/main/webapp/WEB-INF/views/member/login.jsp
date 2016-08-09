<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 

<div id="login">
	<div id="loginDiv1" class="loginTop text-center"></div>
	<form class="form-horizontal">
		<div class="loginCenter row" style="margin-left: 38%;">
			<div id="input1" class="col-sm-5"></div>
		</div>
		<div id="loginButton"></div>
	</form>
</div>
</body>
<script src="${context}/resources/js/login_form.js"></script>
<script type="text/javascript">
	/* 	 $(document).ready(function() {
	
	 }); */
	$(function() {
		var context = '${context}';
		setFormLogin.setFormLogin(context);
	});
	// 메인 메소드
</script>
</html>