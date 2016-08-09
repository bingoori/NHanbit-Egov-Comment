<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<br>
<div>
	<div id="mygrade">
		<div class="mygradeTop">
			<h2 class="text-center">회원 성적 정보</h2>
		</div>
		<div class="joinCenter row">
			<form action="" name="mygradeForm" class="form-horizontal">
				<fieldset class="mygradeField">
					<div class="form-group">
						<label for="input_id" class="col-sm-4 control-label">Java</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id"
								value=" ${score.java}" readonly />

						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">Jsp</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="password"
								name="password" value="${score.jsp}" readonly />
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">Sql</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name"
								value="${score.sql}" readonly />
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">Spring</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr"
								value=" ${score.spring}" readonly />
						</div>
					</div>

				</fieldset>

			</form>

		</div>


	</div>

	<div class="input_button text-center">
		<form action="${context}/global/main.do">
			<input type="submit" value="홈으로" class="btn btn-primary"/>
		</form>
	</div>
	<jsp:include page="../global/footer.jsp" />
</div>