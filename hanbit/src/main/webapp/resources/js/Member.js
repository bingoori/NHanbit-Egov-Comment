/**
 * member
 */

function Member(){}	
/*var inputbox = '';
var passwordBox = '';
var loginDiv = '';
var loginImgButtonTag ='';
var context1 = context;
console.log(context1+'@@@');
loginDiv += '<br/><br/><img id = "loginform_image" src="../resources/img/member/loginform_image.jpg" />';
inputbox += '<input placeholder="아이디를 입력하세요" type = "text" name ="id" class="form-control"/>';
passwordBox += '<input placeholder="비밀번호를 입력하세요" id="input_pw" type ="password" name ="password" class="form-control"/><br/>';
loginImgButtonTag += '<img id = "loginImgButton" alt="" src="../resources/img/main/button.png" /><br/>';
$('#loginDiv1').append(loginDiv);
$('#input1').append(inputbox);
$('#input1').append(passwordBox);
$('#loginButton').append(loginImgButtonTag);

$('#loginform_image').css('border','0').css('width','160px').css('height','160px');
$('#loginImgButton').css('width','160px');
$('#loginButton').addClass('text-center');
$('#loginButton').css('margin-left','1%');
$('#loginImgButton').click(function() {
$('form').attr('action',context1+'/member/login').attr('method','post').submit();*/
Member.prototype.loginForm = function() {
	alert('로그인폼 이동 한데');
}
Member.prototype.joinForm = function(context) {
	var joinForm = '<div id="join">\
		<div class="joinTop">\
			<h2 class="text-center">회원가입</h2>\
		</div>\
		<div class="joinCenter row">\
			<form class="form-horizontal">\
				<fieldset class="joinField">\
					<div class="form-group">\
						<label for="input_cate" class="col-sm-4 control-label">회원등급</label>\
					 	<div class="col-sm-4">\
							<input type="radio" name="cate" id="cate" value="1" checked /> 관리자\
							<input type="radio" name="cate" id="cate" value="2" checked /> 교수\
							<input type="radio" name="cate" id="cate" value="3" checked /> 학생\
						</div>\
					</div>\
					<div class="form-group">\
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>\
					 	<div class="col-sm-4">\
							<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>\
					 	<div class="col-sm-4">\
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_pw_check" class="col-sm-4 control-label">비밀번호 확인</label>\
						<div class="col-sm-4">\
							<input type="password" class="form-control" name="passwordCheck" id="passwordCheck" placeholder="비밀번호를 확인하세요"/>\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_name" class="col-sm-4 control-label">이름</label>\
					 	<div class="col-sm-4">\
							<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요"/>\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_name" class="col-sm-4 control-label">주소</label>\
					 	<div class="col-sm-4">\
							<input type="radio" name="addr" id="addr" value="서울" checked /> 서울\
							<input type="radio" name="addr" id="addr" value="인천" checked /> 인천\
							<input type="radio" name="addr" id="addr" value="경기" checked /> 경기\
							<input type="radio" name="addr" id="addr" value="부산" checked /> 부산\
							<input type="radio" name="addr" id="addr" value="대전" checked /> 대전\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>\
					 	<div class="col-sm-4">\
							<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일을 입력하세요"/>\
						</div>\
					</div>\
					\
					<div class="input_button text-center">\
						<button id="joinBtn">회원가입</button>\
						<button id="cancleBtn">취소</button>\
					</div>\
						\
				</fieldset>\
			</form>\
		</div>\
	</div>';
	$('#content').html(joinForm);
	$('#joinBtn').click(function(e) {
		e.preventDefault();
		alert('회원가입 버튼 클릭');
		var memberJoin = {
				cate : $('#cate').val(),
				id : $('#id').val(),
				password : $('#password').val(),
				name : $('#name').val(),
				addr : $('#addr').val(),
				birth : $('#birth').val()
				
			};
		$.ajax({
			url : context+'/member/join',
			data : JSON.stringify(memberJoin),
			dataType : 'json',
			type : 'post',
			contentType : 'application/json',
			mimeType : 'application/json',
			success : function(data) {
				alert('회원가입성공');
				alert(data);
				alert(data.id);
				if(data != null){
					alert(data.name+'님 회원가입으로 등록되었습니다.');
					location.href= context+'/member/login';
				}else{
					alert('회원가입 중 오류가 발생했습니다');
					return false;
				}
			},
			error : function(xhr,status,msg) {
				alert('에러발생상태 :'+status+',내용 : '+msg);
			}
			
		});
	});

}