/**
 * member
 */

var member = {
	
		init : function(context) {
			$.getJSON(context+'/member/list',function(data) {
				var member_list = '<div id="content" class="container" style="width:1000px;height:450px; margin:0 auto;">'
				+'<table id="member_list" style="width:100%;margin-top: 30px">'
				+'<tr style="background-color: yellow;">'
				+'<th style="text-align: center;">아이디</th>'
				+'<th>이름</th>'
				+'<th>전공</th>'
				+'<th>수강과목</th>'
				+'<th>주소</th>'
				+'<th>생년월일</th>'
				+'</tr>';
				
		 		$.each(data.list, function(index,value) {
		 			
		 			member_list += 
		 			'<tr><td>'+this.id+'</td>'
					+'<td><a class="memberProfile" href="'+context+'/admin/member/profile/'+this.id+'">'+this.name+'</a></td>'
					+'<td>'+this.major+'</td>'
					+'<td>'+this.subject+'</td>'
					+'<td>'+this.addr+'</td>'
					+'<td>'+this.birth+'</td>'
					+'</tr>';
		 			
				}); 
		 		
		 		member_list += '</table></div>';
		 		$('#content').html(member_list);
		 		
		 		$('#member_list').css('border','1px solid black').css('width','100%').css('margin-top','100px');
		 		$('#member_list  th').css('border','1px solid black').css('text-align','center');
				$('#member_list  tr').css('border','1px solid black');
				$('#member_list  tr  td').css('border','1px solid black').css('text-align','center');
				
	
				$('.memberProfile').click(function(e) {
					e.preventDefault();
					alert('admin.js Access')
					admin.memberProfile($('.memberProfile').attr('href'));
				});
			});
		},
		updateForm : function(context) {
			alert('업데이트 폼으로 진입');
			$.getJSON(context+'/member/detail',function(member){
				var update_form = '<div id="detail">'
					+	'<div class="joinTop">'
					+		'<h2 class="text-center">수정정보</h2>'
					+	'</div>'
					+	'<div class="joinCenter row">'
					+		'<form class="form-horizontal" id="frm" action="'+context+'/member/update" method="post" enctype="multipart/form-data">'
					+			'<fieldset class="joinField">'
					+				'<div class="form-group">'
					+				 	'<label for="input_id" class="col-sm-4 control-label">프로필 이미지 등록</label>'
					+				 	'<div class="col-sm-2">'
					+						'<img src="'+context+'/resources/img/profile/'+member.profileImg+'" alt="" style="width:200px;height:230px"/>'
					+					'</div>'
					+				 	'<div class="col-sm-2">'
					+						'<input type="file" id="file" name="file" value="이미지변경"/>'
					+					'</div>'
					+				'</div>'
					+				'<div class="form-group">'
					+				 	'<label for="input_id" class="col-sm-4 control-label">아이디</label>'
					+					'<div class="col-sm-4">'
					+						'<input type="text" class="form-control" id="id" name="id" value="' + member.id + '" />'
					+					'</div>'
					+				'</div>'
					+				'<div class="form-group">'
					+					'<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>'
					+				 	'<div class="col-sm-4">'
					+						'<input type="password" class="form-control" id="password" name="password" value="' + member.password + '"/>'
					+					'</div>'
					+				'</div>'
					+				'<div class="form-group">'
					+					'<label for="input_name" class="col-sm-4 control-label">이름</label>'
					+				 	'<div class="col-sm-4">'
					+						'<input type="text" class="form-control" id="name" name="name" value="' + member.name + '" />'
					+					'</div>'
					+				'</div>'
					+				'<div class="form-group">'
					+					'<label for="input_name" class="col-sm-4 control-label">주소</label>'
					+				 	'<div class="col-sm-4">'
					+						'<input type="text" class="form-control" id="addr" name="addr" value="' + member.addr + '"/>'
					+					'</div>'
					+				'</div>'
					+				'<div class="form-group">'
					+					'<label for="input_name" class="col-sm-4 control-label">생년월일</label>'
					+				 	'<div class="col-sm-4">'
					+						'<input type="text" class="form-control" id="birth" name="birth" value="' + member.birth + '" />'
					+					'</div>'
					+				'</div>'
					+				'<div class="input_button text-center">'
					+					'<button id="updateBtn" class="btn btn-primary">수정</button>'
					+					'<button id="cancle" class="btn btn-primary">취소</button>'
					+				'</div>'		
					+			'</fieldset>'
					+		'</form>'
					+	'</div>'
					+'</div>';
				$('#content').html(update_form);
				$('#updateBtn').click(function(e) {
					e.preventDefault();
					alert('업데이트 클릭');
					var $frm = $('#frm');
					var postData = new FormData($('#frm')[0]);
					alert(postData);
					$.ajax({
						type: $frm.attr('method'),
					      url: $frm.attr('action'),
					      data: postData,
					      dataType : 'json',
					      mimeType: 'multipart/form-data',
					      contentType: false, 
					      processData : false,
						success : function(data) {				
							location.href = context+'/member/content/'+member.id;
						},
						error : function(xhr,status,msg) {
							alert('에러발생상태 :'+status+',내용 : '+msg);
						}
					});
					});
				});
		}
		,
		update : function(context) {
			//e.preventDefault();
			$.ajax({
				url : context+'/member/update',
				data : {
					id : $('#id').val(),
					password : $('#password').val(),
					addr : $('#addr').val(),
					profile_img : $('#profile_img').val()
				},
				async : true,
				/*보내는값 */
				dataType : 'json',
				type : 'post',
				/* 받는 값 */
				contentType : 'application/json',
				mimeType : 'application/json',
				success : function(data) {
					alert('수정 성공'+data.profileImg);
				},
				error : function(xhr,status,msg) {
					alert('에러발생상태 :'+status+',내용 : '+msg);
				}
			});
		}
		
		
};