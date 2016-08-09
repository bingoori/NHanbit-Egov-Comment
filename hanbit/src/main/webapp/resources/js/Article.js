/**
 * 
 */
function Article() {
	var replyTag = '<form><div ><label id="topfocus" for="boardContent">댓글</label><div class="form-group"><table id="replyView" class="table table-condensed" >\
		</table>\
		</div>\
		<button type="submit" id="acceptSubmit" class="btn col-xs-6 btn-success btn-lg ">확 인</button>\
		<button type="submit" id="replySubmit" class="btn col-xs-6 btn-warning btn-lg ">취 소</button>\
		</form>';
	var writeForm = 
		'<form id="writeFrm">\
		<div class="form-group">\
		<label for="boardTitle">제목</label>\
		<input type="text" class="form-control" id="title" name="title" placeholder="제 목">\
		</div>\
		<div class="form-group">\
		<label for="boardWriter">작성자</label>\
		<input type="text" class="form-control" id="writerName" name="writerName" placeholder="작 성 자"></div>\
		<div class="form-group">\
		<label for="boardPassword">비밀번호</label>\
		<input type="password" id="password" class="form-control" name="password" placeholder="비 밀 번 호"></div>\
		<div class="form-group">\
		<label for="boardContent">글내용</label>\
		<textarea id="content" name="content" class="form-control"  rows="5" placeholder="글 내 용"></textarea></div>\
		<button  id="writeSubmit" class="btn btn-primary btn-lg btn-block">전 송</button>\
		</form>';
	
	Article.prototype.boardDetail = function(context,getArticle) {
		$.getJSON(context+'/article/detail/'+getArticle,function(data) {
			var replyResult = '';
			var replyAddTest ='<tr id = "replyAdd" ><td><div class="col-xs-2">\
				<img  style="width: 50px;" src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSRa1qiLVV1U3sNJdYS5zo9fml00_z8Seq_p2AoKicu76TOmxIr" />\
				</div>\
				<div class="col-xs-10">\
				<input type="text" class="form-control" id="replyContent" name="replyContent" placeholder="댓글을 입력한 후 확인버튼을 입력하세요" />\
				</div>\
				</td></tr>';
			var searchResult = 	'<form>\
				<div class="form-group">\
				<label for="articleId">글번호</label>\
				<input type="text" class="form-control" id="articleId" name="articleId" value="'+data.info.articleId+'" >\
				</div>\
				<div class="form-group">\
				<label for="boardTitle">제목</label>\
				<input type="text" class="form-control" id="title" name="title" value="'+data.info.title+'" >\
				</div>\
				<div class="form-group">\
				<label for="boardWriter">작성자</label>\
				<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.info.writerName+'" ></div>\
				<div class="form-group">\
				<label for="boardPassword">비밀번호</label>\
				<input type="password" id="password" class="form-control" name="password" value="'+data.info.password+'" ></div>\
				<div class="form-group">\
				<label for="boardContent">글내용</label>\
				<textarea id="content" name="content" class="form-control"  rows="5"  >'+data.info.content+'</textarea>\
				<br/>\
				<input type="button" id="updateForm" value="수 정" class="btn col-xs-4 btn-primary btn-lg ">\
				<button type="submit" id="deleteForm" class="btn col-xs-4 btn-danger btn-lg ">삭 제</button>\
				<input type="button" id="replyForm" value="댓글 달기" class="btn col-xs-4 btn-default btn-lg "><br/>\
				<div id="replyadd"  class="form-group">\
				</div>\
				</form>'; 
			
			var replyWrite =  '<br/><br/><textarea id="reply" name="content" class="form-control"  rows="5"  ></textarea></div>'
				
				$('.container').html(searchResult).append(replyTag);
			$.each(data.comment, function(index,value) {
				replyResult += '<tr><td><div class="col-xs-2"><img  style="width: 50px;" src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSRa1qiLVV1U3sNJdYS5zo9fml00_z8Seq_p2AoKicu76TOmxIr" /></div><div class="col-xs-10"><p>'+'작성자 : 빙구리 &nbsp;&nbsp;'+value.reply+'</p>'+'작성 날짜 : '+value.replyDate+' &nbsp;&nbsp; 좋아연'+'</div></td></tr>';
			});
				$('#replyView').append(replyResult).append(replyAddTest);

				$('#updateForm').click(function(e) {
					e.preventDefault(); //기존의 submit을 무시
					alert(context);
					alert('수정 시도');
					$.ajax(context+'/article/update',{
						data : {
							articleId : $('#articleId').val(),
							title : $('#title').val(),
							writerName : $('#writerName').val(),
							password : $('#password').val(),
							content : $('#content').val()
						}	,
						type : 'post',
						//생략가능
							dataType : 'json',
							async : true,
						success : function(data) { 
							alert('수정 성공');
							Article.prototype.articleAll(context,1);
						},
						error : function(xhr,status,msg) {
							alert('에러발생상태 :'+status+',내용 : '+msg);
						}
					});
				});
				$('#deleteForm').click(function(e) {
					e.preventDefault();
					alert('deleteForm');
					$.ajax(context+'/article/delete',{
					data : {
						articleId : $('#articleId').val()
					},
					success : function(data) {
						alert(data.message);
						Article.prototype.articleAll(context,1);
					},
					error : function(xhr,status,msg) {
						alert('에러발생상태 :'+status+',내용 : '+msg);
					}
					});
				});
				$(document).on("click","#replyForm",function(e){
					e.preventDefault();
					$('#replyContent').focus();
				});
				$(document).on("click","#acceptSubmit",function(e) {
					e.preventDefault(); //기존의 submit을 무시
						alert('acceptSubmit');
						alert($('#replyContent').val());
						$.ajax(context+"/article/reply",{
							data : {
								articleId : $('#articleId').val(),
								reply : $('#replyContent').val()
							},
							type : 'post',
							
							//생략가능
								dataType : 'json',
								async : true,
							success : function(data) {
								$('#replyAdd').remove();
								$('#replyView').append('<tr><td><div class="col-xs-2"><img  style="width: 50px;" src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSRa1qiLVV1U3sNJdYS5zo9fml00_z8Seq_p2AoKicu76TOmxIr" /></div><div class="col-xs-10"><p>'+'작성자 : 빙구리 &nbsp;&nbsp;'+data.reply+'</p>'+'작성 날짜 : '+data.comment+' &nbsp;&nbsp; 좋아연'+'</div></td></tr>');	
								$('#replyView').append(replyAddTest);
								$('#password').focus();
							},
							error : function(xhr,status,msg) {
								alert('에러발생상태 :'+status+',내용 : '+msg);
							}
						});
					});
 
	 		});
	
	}
	Article.prototype.myArticle = function(context) {
		alert('내가 쓴글 게시판 목록 진입');
	}
	Article.prototype.writeForm = function() { 
		alert('Article 의 WriteForm 함수 호출');
			$('.container').html(writeForm);
			$('#writeSubmit').click(function() { 
			$('form').attr('method','post').attr('action',article.getContext()+'/article/write').submit();
			});
	}
	Article.prototype.articleAll = function(context,pageNO) {
	$.getJSON(context+'/article/list/'+pageNO,function(article){
			
		var article_list = 
				'<style>\
				table th{background: yellow;text-align: center;}\
				</style>\
				<div class="container">\
				<span class="glyphicon glyphicon-pencil" id="writeBtn" style="cursor:pointer; float: right;margin : 0 50px 30px 0">글쓰기</span>\
				<table class="table table-condensed table-bordered table-striped" >';
				
			if(article.command.totalPages > 0){
article_list 	+= 	'<tr><td colspan="5"> [총 게시글 : '+article.command.count+']'+'</td>\
					</tr>\
					<tr>\
						<th>글 번호</th>\
						<th>제목</th>\
						<th>작성자</th>\
						<th>작성일</th>\
						<th>조회수</th>\
				    </tr>';
			}
			if(article.command.count == 0){
				article_list += '<tr>\
									<td colspan="5" style="text-align: center;">게시글이 없습니다.\
									</td>\
									</tr>';
				
			}else{
				$.each(article.list, function(index,value) {
	        article_list   +=	
		   				'<tr>\
					  		<td>'+value.articleId+'</td>\
					  		<td>\
					  		<a class="searchId" onclick="Article.prototype.boardDetail('+'\''+context+'\''+','+value.articleId+');" href="#" >'+value.title+'</a>\
					  		</td>\
					  		<td>'+value.writerName+'</td>\
					  		<td>'+value.postingDate+'</td>\
					  		<td>'+value.readCount+'</td>\
					  	</tr>';

		 		});  
				article_list   += '</table>';
			}
				 		
		
			var pageNation =
						'<nav><ul class="pagination" style="margin-left: 40%">\
						<li class="disabled">\
						<a href="'+context+'/article/page/'+(article.command.startPage -article.command.groupSize)+'" aria-label="Previous">\
						<span aria-hidden="true">&laquo;</span>\
						</a>\
						</li>';
			for(var i = article.command.startPage ; i <= article.command.endPage ; i++){
				if( i == article.command.pageNO){
					pageNation +=  '<li class="active"><span>'+i+'<span class="sr-only">(current)</span></span></li>';
				}else{
					pageNation +=  '<li><span><a class ="otherPage" onclick="Article.prototype.articleAll('+'\''+context+'\''+','+'\''+i+'\')" href="#">'+i+'</a></span></li>';
				}
			} 
			pageNation += '<li class="disabled"><a href="'+context+'/article/page/'+article.command.startPage+article.command.pageSize+'" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>\
					</li>\
					</ul>\
					</nav>';
			var searchOption = 
				'<div style="float:right;margin:0 50px 0 0">\
				<form>\
				<select name="keyField" id="keyField">\
				<option value="title" selected="selected">제목</option>\
				<option value="name" >이름</option>\
				</select>\
				<input type="text" name="keyword" id="keyword" />\
				<input type="submit" value="검색" id="searchBtn"/>\
				</form>\
				</div>';
			 article_list += pageNation;  
			 article_list += searchOption;
			$('#content').html(article_list);
			$('#writeBtn').click(function() {
				alert('글쓰기 버튼 클릭');
				$('#content').html(writeForm);
				$('#writeSubmit').click(function(e) { 
					e.preventDefault();
					alert('글쓰기 등록 버튼 클릭');
				$.ajax({
					url : context+'/article/write',
					data : {
						articleId : $('#articleId').val(),
						title : $('#title').val(),
						writerName : $('#writerName').val(),
						password : $('#password').val(),
						content : $('#content').val()
					},
					type : 'post',
					dataType : 'json',
					success : function(data) {				
						alert('글 등록 성공');
						Article.prototype.articleAll(context,1);
					},
					error : function(xhr,status,msg) {
						alert('에러발생상태 :'+status+',내용 : '+msg);
					}
				});
				});
			});
			
				
		});
	}
}