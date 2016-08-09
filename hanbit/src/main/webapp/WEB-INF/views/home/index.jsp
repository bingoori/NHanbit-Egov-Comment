<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<img src="${context}/resources/img/main/mainImage.jpg" alt="" width="100%" height=
 />
<br />
<div style="margin-left: 43.5%;">
   <a href="${context}/member/login">로그인</a> <br/> 
   <a href="${context}/member/join">회원가입</a> <br/>
   <a href="${context}/admin/join">관리자 등록</a> <br/>
   <a href="${context}/admin/login">관리자 화면</a> <br/>
</div>
 
<jsp:include page="../global/footer.jsp" />