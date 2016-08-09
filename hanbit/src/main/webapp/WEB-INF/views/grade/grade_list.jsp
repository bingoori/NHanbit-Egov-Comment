<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<%-- <jsp:include page="../global/header.jsp" /> --%>
<form action="${context}/member/admin_form.do">
	<table cellpadding="3" cellspacing="3" border="1">

		<tr>
			<th>아이디</th>
			<th>Java</th>
			<th>Jsp</th>
			<th>Sql</th>
			<th>Spring</th>
		</tr>
		<c:forEach var="score" items="${requestScope['member']}">
			<tr>
				<td><c:out value="${score.id}" /></td>
				<td><c:out value="${score.java}" /></td>
				<td><c:out value="${score.jsp}" /></td>
				<td><c:out value="${score.sql}" /></td>
				<td><c:out value="${score.spring}" /></td>
			</tr>
			</c:forEach>
	</table>
	<div>
			<!-- <input type="submit" value="되돌아가기" /> -->
		</div>
</form>

<%-- 
	<jsp:include page="../global/footer.jsp" /> --%>
</div>