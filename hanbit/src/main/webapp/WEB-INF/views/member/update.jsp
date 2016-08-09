<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="update">
		<div class="updateTop">
			<h2 class="text-center">수정 정보</h2>
		</div>		
		<div class="updateCenter  row">
			<form >
				<fieldset class="updateField">
				   <div class="form-group">
                   <label for="profile_img" class="col-sm-4 control-label"> 프로필 이미지 등록</label>
                   <div class="col-sm-2">
                     <img alt="" src="${img}/profile/${member.profileImg}" style="width:110px; height:130px;">
                  </div>
                   <div class="col-sm-3">
                     <input type="file" id="profile_img" name="profile_img"/>
                  </div>
               </div>
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.id}" />
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="password" name="password" value="${sessionScope.user.password}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" value="${sessionScope.user.name}" />
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" value="${sessionScope.user.addr}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${sessionScope.user.birth}" />
						</div>
					</div>
					<div class="input_button text-center">
					<button id="updateBtn">수정</button>
					<button id="cancleBtn">취소</button>
					</div>				
				</fieldset>
			</form>
		</div>
	</div>
		<script src="${js}/member.js"></script>
		<script type="text/javascript">
	
		$(function() {
				//ajax 적용 전
				/* $('form').attr('action','${context}/member/update').attr('method','post').submit(); */		
			$form = $('form');
			$form.addClass('form-horizontal');	
			$('#updateButton').addClass('btn btn-primary').click(function() {
				member.serContext('${context}');
				member.update();
			});
			$('#"cancleBtn"').addClass('btn btn-primary').click(function() {
			$form.reset();
			});
		
		});
		</script>
</div>