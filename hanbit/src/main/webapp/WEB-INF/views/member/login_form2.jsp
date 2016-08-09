<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class= "mg_auto" style="width: 1000px;" >
	<form action="${context}/member/login.do" name="frm" method = "get">
		<div>
			<h2>로그인 화면</h2>
			<!--  -->
			<div>
				<h4>아이디가 없으면, 계정을 생성하시오</h4>
			</div>
			<table>
				<tr>
					<td>
						<h3>아이디</h3>
					</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>
						<h3>비밀번호</h3>
					</td>
					<td><input type="password" /></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="로그인" />
				<input type="reset" value="취소" />
				 <input type="button" value="회원가입"	onclick="location.href='${context}/member/join_form.do'" />
			</div>
		</div>
	</form>
</body>
</html>

<jsp:include page="../global/footer.jsp" />
</div>

