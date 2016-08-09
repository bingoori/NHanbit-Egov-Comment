<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class= "mg_auto" style="width: 1000px;" >

<form action="login_form.do" >
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name ="id" size="30" autofocus required="required"/></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pass" size="30" maxlength ="15" required="required"/></td>
	</tr>
	<tr>
		<td>재확인</td>
		<td><input type="password" name="repass" size="30" maxlength ="15" required="required"/></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name = "name" size="30" required="required"/></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><input type="text" name = "birth" size="30" required="required"/></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name = "addr1" size="30" required="required"/></td>
		<td><input type="text" name = "addr2" size="30" required="required"/></td>
	</tr>
</table>
	<div>
	
	<input type="submit" value="가입" />
	</div>
	<%-- <input type="button" value="가입" onclick="location.href='${context}/member/login_form.do'"/> --%>
</form>
<jsp:include page="../global/footer.jsp" />
</div>
