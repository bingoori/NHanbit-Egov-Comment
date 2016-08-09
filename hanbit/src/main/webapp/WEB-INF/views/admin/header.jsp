<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<header style="width: 100%; margin: 0 auto">
	<h3 style="color: white; text-align: center;">
		<a href="${context}/">관리자 페이지</a>
	</h3>
	<p style="float: right; margin-right: 50px;">
		<fmt:formatDate value="${time}" type="both" />
	</p>
	<ul class="nav nav-pills">
		<li role="presentation" style="float: right">
			<a href="${context}/admin/regist" >관리자 등록</a>
		</li>
	<li role="presentation" style="float: right">
			<a href="${context}/" >메인 화면</a>
		</li>
			
		
	</ul>

</header>