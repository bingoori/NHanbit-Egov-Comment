<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
.nav li a {
	color: gray
}
</style>
<header style="width: 100%; margin: 0 auto">
	<div style="text-align: center;">
		<h3 style="color: white; text-align: center;">
			<a href="${context}/">관리자 페이지</a>
		</h3>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav nav-pills">
				<li role="presentation" style="float: right"><a href="#">로그아웃</a></li>
				<li role="presentation" style="float: right"><a href="#" id="recordMgmt">성적관리</a></li>
				<li role="presentation" style="float: right"><a href="#" id = "memberMgmt">학생관리</a></li>
				<li role="presentation" style="float: right"><a href="#" id = "adminMgmt">교직원관리</a></li>
				<li role="presentation" style="float: right"><a href="#" id = "subjectMgmt">학과관리</a></li>

			</ul>
		</div>

	</nav>


</header>