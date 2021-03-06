<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<header style="width: 100%; margin: 0 auto">
	<h3 style="color: white; text-align: center;">
		<a href="${context}/">한빛 교육 센터</a>
	</h3>
	<ul class="nav nav-pills">

		<li role="presentation" class="dropdown" style="margin-left: 100px">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#"
			role="button" aria-haspopup="true" aria-expanded="false">
				JavaScript <span class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="${context}/js/hello.do">자바스크립트 소개</a></li>
				<li><a href="${context}/js/var.do">변수</a></li>
				<li><a href="${context}/js/operator.do">연산자</a></li>
				<li><a href="${context}/js/function.do">함수</a></li>
				<li><a href="${context}/js/object.do">객체</a></li>
				<li><a href="${context}/js/bom.do">BOM</a></li>
				<li><a href="${context}/js/dom.do">DOM</a></li>
				<li><a href="${context}/js/form.do">form 태그</a></li>
				<li><a href="${context}/js/closure.do">클로저</a></li>
				<li><a href="${context}/js/pattern.do">패턴</a></li>
			</ul>

		</li>
		<li role="presentation" class="dropdown" style="margin-left: 100px">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#"
			role="button" aria-haspopup="true" aria-expanded="false"> Jquery
				<span class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="${context}/jquery/attr.do">속성</a></li>
				<li><a href="${context}/jquery/core.do">코어</a></li>
				<li><a href="${context}/jquery/dom.do">DOM</a></li>
				<li><a href="${context}/jquery/event.do">이벤트</a></li>
				<li><a href="${context}/jquery/selector.do">선택자</a></li>
				<li><a href="${context}/jquery/traversing.do">조회</a></li>
			</ul>
		</li>
		<li id="board" role="presentation" style="margin-left: 100px">
			<a href="${context}/article/article_all" id="article_all">게시판</a>
		</li>
<%-- ${context}/article/list --%>
		<li role="presentation" style="margin-left: 100px"><a
			href="${context}/member/login" id="login" >로그인</a></li>
			
		<li role="presentation" style="margin-left: 100px"><a
			href="${context}/member/join" id="join">회원가입</a></li>

		<li role="presentation" style="margin-left: 100px"><a
			href="${context}/admin/login" id="admin_login">관리자</a></li>

	</ul>
</header>
 