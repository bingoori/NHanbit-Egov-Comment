<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="../global/header.jsp"/>
<div id="parent" style="background-color : yellow; width : 500px ;height :500px; margin-left: 30%;">
	<div id='son1'>this 예제</div>
	<div id='son2'>parent 예제</div>
	<div id='son3'>siblings 예제</div>
</div>

<script type="text/javascript">
	$(function() {

		$('#son1').css('background-color', 'white').css('width', '100px').css(
				'height', '100px');
		$('#son2').css('background-color', 'white').css('width', '100px').css(
				'height', '100px');
		$('#son3').css('background-color', 'white').css('width', '100px').css(
				'height', '100px');

/* 		$('#parent').click(function() {
			$(this).children().css('background-color', 'blue');
		}) */
		$('#son1').click(function() {
			$(this).css('background-color', 'red');
		});
		$('#son2').click(function() {
			$(this).parent().css('background-color', 'red');
		});
		$('#son3').click(function() {
			$(this).siblings().css('background-color', 'red');
		});
	})
</script>