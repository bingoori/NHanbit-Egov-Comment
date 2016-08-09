<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;">
	<div>
	<h3>브라우저 객체 BOM</h3>
	<!--
	BOM 은 책한권
	DOM 은 책의 한 페이지( 하나의 JSP파일)
	모델 -> 기능과 속성 
	 -->
	<h4>Window</h4>
	<ul>
		<li>[1]대화창
		<ul>
			<li><a href="#" onclick="javaScript:win.alert()">경고창</a></li>
			<li><a href="#" onclick="javaScript:win.confirm()">확인창</a></li>
			<li><a href="#" onclick="javaScript:win.prompt()">입력창</a></li>
		</ul>
		</li>
		<li>[2]팝업창
		<ul>
			<li>open('문서명','창이름','속성') :
			 <a href="#" onclick="javaScript:win.open()">새창열기</a>
			 </li>
			<li>close() : 
			<a href="#" onclick="win.close()">창닫기</a>
			</li>
		
		</ul>
		</li>
	</ul>
	<h4>history 객체</h4>
	<ul>
		<li><a href="#" onclick="javaScript:win.f5()">새로고침</a></li>
		<li><a href="#" onclick="win.goBack()">이전 페이지</a></li>
	</ul>
	<h4>location 객체</h4>
	<ul>
		<li><a href="#" onclick="javaScript:win.href()">홈으로 이동</a></li>
	</ul>
	</div>
</div>
<script type="text/javascript">
var win = {
		alert : function(){
			alert('경고창은 메시지만 전달');
		},
		confirm : function(){
			confirm('컨펌창은 확인/취소  버튼 존재');
		},
		
		prompt : function(){
			prompt('프롬프트창은 값을 입력하는 것이 가능');
		},
		close : function()
		{
			myWindow.close();
		},
		open : function(){
		myWindow = window.open('${context}/member/login_form.do');
		},
		href : function(){
			location.href='${context}/global/main.do';
		},
		f5 : function(){
			history.go(0);
		},
		goBack : function(){
			history.go(-1);
		}
}
</script>