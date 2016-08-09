<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">${sessionScope.user.name} ${member.role}상세정보</h2>
		</div>
		<div class="joinCenter row">
		<form class="form-horizontal">
			<fieldset class="joinField">
				<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">프로필 이미지</label>
					 	<div class="col-sm-2">
							<img src="${img}/profile/${member.profileImg}" alt="" style="width:200px;height:230px"/>
						</div>
					 	<div class="col-sm-2">
							<input type="file" id="profile_img" name="profile_img" />
						</div>
					</div>
				<div class="form-group">
				 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
				 	<div class="col-sm-4">
				 		<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.id}" readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
				 	<div class="col-sm-4">
						<input type="password" class="form-control" id="password" name="password" value="${sessionScope.user.password}" readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">이름</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="name" name="name" value="${sessionScope.user.name}" readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">주소</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="addr" name="addr" value="${sessionScope.user.addr}" readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">생년월일</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="birth" name="birth" value="${sessionScope.user.birth}" readonly="readonly"/>
					</div>
				</div>
			</fieldset>
			</form>
	
	<div class="input_button text-center">
		
		<button id = "gradeButton">성적</button>
		<button id = "updateButton">수정</button>
		<button id = "deleteButton">삭제</button>
		<button id = "homeButton">홈</button>
		</div>
	</div>
</div>
<script src="${js}/member.js"></script>
	<script type="text/javascript">
	
	$(function() {
		var global = new Global('${context}');
		var $form = $('form');
		$form.addClass('form-horizontal');	
		$('#gradeButton').addClass('btn btn-primary');
		$('#updateButton').addClass('btn btn-primary');
		$('#deleteButton').addClass('btn btn-primary');
		$('#homeButton').addClass('btn btn-primary');
			
		$('#gradeButton').click(function() {
			location.href='${context}/grade/my_grade.do?id=${sessionScope.user.id}';	
		});
	/* 	$('#updateButton').click(function() {
			location.href='${context}/member/update_form?id=${sessionScope.user.id}';		
		}); */
		$('#updateButton').click(function() {
			/* location.href='${context}/member/update?id=${sessionScope.user.id}'; */		
			member.updateForm(global.getContext());
		});
		$('#deleteButton').click(function() {
			location.href='${context}/member/delete';		
		});
		$('#homeButton').click(function() {
			location.href='${context}/global/main.do';		
		});
	

	
	});
	
	
	</script>

