<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<header style="width: 100%; margin: 0 auto">
	<div style="text-align: center;">
		<h3 style="color: white; text-align: center;">
			<a href="${context}/">사용자 페이지</a>
		</h3>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav nav-pills">
				<li role="presentation" style="margin-left: 100px"><a
					href="#" id ="my_article">게시판</a></li>

				<li role="presentation" style="margin-left: 100px"><a
					href="${context}/member/logout">Logout</a></li>
				<li role="presentation" style="margin-left: 100px"><a
					href="${context}/member/mypage">MyPage</a></li>
			</ul>
		</div>
	</nav>


</header>