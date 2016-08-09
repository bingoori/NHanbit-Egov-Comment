/**
 * 
 */
function Article() {
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
		<button type="submit" id="writeSubmit" class="btn btn-primary btn-lg btn-block">전 송</button>\
		</form>';
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
	Article.prototype.articleAll = function(context) {
				alert('전체 게시판 목록 진입');
	$.getJSON(context+'/article/list',function(article){

		var pageNation ='<nav><ul class="pagination" style="margin-left: 40%">'
			if(article.command.startPage != 0){
				pageNation += 
					 '<li class="disabled">\
					  <a href="'+context+'/article/page/'+(article.command.startPage -article.command.startPage.pageSize)+'" aria-label="Previous">\
					  	<span aria-hidden="true">&laquo;</span>\
					  </a>\
					  </li>';
			 }
			 for(i = article.command.startPage ; i <= article.command.endPage ; i++){
				 
				   		if( i == article.command.pageNO){
				   			pageNation +=  '<li class="active"><span>'+i+'<span class="sr-only">(current)</span></span></li>';
				   		}else{
				   			pageNation +=  '<li><span><a href="'+context+'/article/page/${page}">'+i+'</a></span></li>';
				   		 }
				   	} 
			if(article.command.startPage != 0){
				pageNation += 
					'<li class="disabled"><a href="'+context+'/article/page/'+article.command.startPage+article.command.pageSize+'" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>\
					</li>\
					</ul>\
				    </nav>';
				}
				
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
					  		<a class="searchId" onclick="return false;" href="'+context+'/article/search/'+value.articleId+'" >'+value.title+'</a>\
					  		</td>\
					  		<td>'+value.writerName+'</td>\
					  		<td>'+value.postingDate+'</td>\
					  		<td>'+value.readCount+'</td>\
					  	</tr>';

		 		});  
				article_list   += '</table>';
			}
				 		
			 article_list += pageNation;  
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
			 article_list += searchOption;
			$('#content').html(article_list);
			$('#writeBtn').click(function() {
				alert('글쓰기 버튼 클릭');
				$('#content').html(writeForm);
				$('#writeSubmit').click(function() { 
				$('form').attr('method','post').attr('action',article.getContext()+'/article/write').submit();
				});
			});
				
		});
	}
}
	var article = {
			
			
	
			context : '',
			setContext : function(context) {
				this.context = context;
			},
			getContext : function(){
				return this.context;
			},
			
			update : function(path) {
				$.ajax({
					url : path,
					data : {},
					async : true,
					dataType : 'json',
					success : function(data) {						
						data = data.info; 
						var searchResult = 
							'<form>'
							+'<div class="form-group">'
							+'<label for="articleId">글번호</label>'
							+'<input type="text" class="form-control" id="articleId" name="articleId" value="'+data.articleId+'" >'
							+'</div>'
							+'<div class="form-group">'
							+'<label for="boardTitle">제목</label>'
							+'<input type="text" class="form-control" id="title" name="title" value="'+data.title+'" >'
							+'</div>'
							+'<div class="form-group">'
							+'<label for="boardWriter">작성자</label>'
							+'<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.writerName+'" ></div>'
							+'<div class="form-group">'
							+'<label for="boardPassword">비밀번호</label>'
							+'<input type="password" id="password" class="form-control" name="password" value="'+data.password+'" ></div>'
							+'<div class="form-group">'
							+'<label for="boardContent">글내용</label>'
							+'<textarea id="content" name="content" class="form-control"  rows="5"  >'+data.content+'</textarea></div>'
							+'<button type="submit" id="updateSubmit" class="btn col-xs-6 btn-primary btn-lg ">수 정</button>'
							+'<button type="submit" id="deleteSubmit" class="btn col-xs-6 btn-danger btn-lg ">삭 제</button>'
							+'</form>';
						
						$('.container').html(searchResult);
						$('#updateSubmit').click(function(e) {
							e.preventDefault(); //기존의 submit을 무시
							$.ajax(article.getContext()+'/article/update',{
								data : {
									articleId : $('#articleId').val(),
									title : $('#title').val(),
									writerName : $('#writerName').val(),
									password : $('#password').val(),
									content : $('#content').val()
								},
								type : 'post',
								//생략가능
								/*	dataType : 'json',
									async : true,*/
								success : function(data) { 
									location.href= article.getContext()+"/article/list";
								},
								error : function(xhr,status,msg) {
									alert('에러발생상태 :'+status+',내용 : '+msg);
								}
							});
						});
						
					},
					error : function(xhr,status,msg) {
						alert('에러발생상태 :'+status+',내용 : '+msg);
					}
				});
			},
		 detail : function(path) {
			 alert(path+"asdf");
			$.ajax({
				url : path,
				data : {
					articleId : $('#articleId').val()
				},
				async : true,
				dataType : 'json',
				success : function(data) {	
					var replyResult = '';
					var replyAddTest ='<tr><td><div class="col-xs-2">'
					+'<img  style="width: 50px;" src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSRa1qiLVV1U3sNJdYS5zo9fml00_z8Seq_p2AoKicu76TOmxIr" />'
					+'</div>'
					+'<div class="col-xs-10">'
					+'<input type="text" class="form-control" id="replyContent" name="replyContent" placeholder="댓글을 입력한 후 확인버튼을 입력하세요" />'
					+'</div>'
					+'</td></tr>';
					var searchResult = 
						'<form>'
						+'<div class="form-group">'
						+'<label for="articleId">글번호</label>'
						+'<input type="text" class="form-control" id="articleId" name="articleId" value="'+data.info.articleId+'" >'
						+'</div>'
						+'<div class="form-group">'
						+'<label for="boardTitle">제목</label>'
						+'<input type="text" class="form-control" id="title" name="title" value="'+data.info.title+'" >'
						+'</div>'
						+'<div class="form-group">'
						+'<label for="boardWriter">작성자</label>'
						+'<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.info.writerName+'" ></div>'
						+'<div class="form-group">'
						+'<label for="boardPassword">비밀번호</label>'
						+'<input type="password" id="password" class="form-control" name="password" value="'+data.info.password+'" ></div>'
						+'<div class="form-group">'
						+'<label for="boardContent">글내용</label>'
						+'<textarea id="content" name="content" class="form-control"  rows="5"  >'+data.info.content+'</textarea>'
						+'<br/><button type="submit" id="updateForm" class="btn col-xs-4 btn-primary btn-lg ">수 정</button>'
						+'<button type="submit" id="deleteForm" class="btn col-xs-4 btn-danger btn-lg ">삭 제</button>'
						+'<input type="button" id="replyForm" value="댓글 달기" class="btn col-xs-4 btn-default btn-lg "><br/>'
						+'<div id="replyadd"  class="form-group">' 
						+'</div>'
						+'</form>'; 
					var replyWrite =  '<br/><br/><textarea id="reply" name="content" class="form-control"  rows="5"  ></textarea></div>'
					
					$('.container').html(searchResult).append(article.replyForm());
					
					$.each(data.comment, function(index,value) {
						replyResult += '<tr><td><div class="col-xs-2"><img  style="width: 50px;" src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSRa1qiLVV1U3sNJdYS5zo9fml00_z8Seq_p2AoKicu76TOmxIr" /></div><div class="col-xs-10"><p>'+'작성자 : 빙구리 &nbsp;&nbsp;'+value.reply+'</p>'+'작성 날짜 : 빙구리 &nbsp;&nbsp; 좋아연'+'</div></td></tr>';
						//<tr class="form-control"></tr>
			 		}); 
					//https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTkDmh38HrosY_noV4vqcU7Ful4MtGHUiw1sGz9KHhEH_hjWrMwvlQliW8
					$('#replyView').append(replyResult).append(replyAddTest);
					
					$('#updateForm').click(function(e) {
						e.preventDefault(); //기존의 submit을 무시
						$.ajax(article.getContext()+'/article/update',{
							data : {
								articleId : $('#articleId').val(),
								title : $('#title').val(),
								writerName : $('#writerName').val(),
								password : $('#password').val(),
								content : $('#content').val()
							},
							type : 'post',
							//생략가능
							/*	dataType : 'json',
								async : true,*/
							success : function(data) { 
								location.href= article.getContext()+"/article/list";
							},
							error : function(xhr,status,msg) {
								alert('에러발생상태 :'+status+',내용 : '+msg);
							}
						});
					});
					$('#deleteForm').click(function(e) {
						e.preventDefault();
						$.ajax(article.getContext()+'/article/delete',{
						data : {
							articleId : $('#articleId').val()
						},
						success : function(data) {
							alert(data.message);
							location.href= article.getContext()+'/article/list';
						},
						error : function(xhr,status,msg) {
							alert('에러발생상태 :'+status+',내용 : '+msg);
						}
						});
					});
					$(document).on("click","#replyForm",function(e){
						e.preventDefault();
						/*
						$('#replyadd').append(replyWrite);*/
						$('#replyContent').focus();
						/*$('#replyForm').attr("value","댓글 감추기").attr("id","replyForm2");*/
					});
/*					$(document).on("click","#replyForm2",function(e){
						e.preventDefault(); //기존의 submit을 무시
							$('.container').html(searchResult).append(article.replyForm());
							$('#replyView').append(replyResult);
							$('#replyForm2').attr("value","댓글 달기").attr("id","replyForm");
						});*/
					$(document).on("click","#acceptSubmit",function(e) {
						e.preventDefault(); //기존의 submit을 무시
							alert('acceptSubmit');
							alert($('#replyContent').val());
							$.ajax(article.getContext()+"/article/reply",{
								data : {
									articleId : $('#articleId').val(),
									reply : $('#replyContent').val()
								},
								type : 'post',
								
								//생략가능
								/*	dataType : 'json',
									async : true,*/
								success : function(data) {
									alert(data.reply);
									$('#replyView').empty();
									$('#replyView').append('<tr><td><div class="col-xs-2"><img  style="width: 50px;" src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSRa1qiLVV1U3sNJdYS5zo9fml00_z8Seq_p2AoKicu76TOmxIr" /></div><div class="col-xs-10"><p>'+'작성자 : 빙구리 &nbsp;&nbsp;'+data.reply+'</p>'+'작성 날짜 : 빙구리 &nbsp;&nbsp; 좋아연'+'</div></td></tr>').append(replyResult).append(replyAddTest);	
									$('#password').focus();
								},
								error : function(xhr,status,msg) {
									alert('에러발생상태 :'+status+',내용 : '+msg);
								}
							});
						});
					$('#replySubmit').click(function(e) {
						e.preventDefault(); //기존의 submit을 무시
						alert('replySubmit');
					});
					
				},
				error : function(xhr,status,msg) {
					alert('에러발생상태 :'+status+',내용 : '+msg);
				}
				});
			
		},
		replyForm : function() {

			var replyTag = '<form>'
				+'<div >'
				+'<label id="topfocus" for="boardContent">댓글</label>'
				+'<div class="form-group">'
				+'<table id="replyView" class="table table-condensed" >' 
				+'</table>'
				+'</div>'
				+'<button type="submit" id="acceptSubmit" class="btn col-xs-6 btn-success btn-lg ">확 인</button>'
				+'<button type="submit" id="replySubmit" class="btn col-xs-6 btn-warning btn-lg ">취 소</button>'
				+'</form>';
			
				return replyTag;
		} 
		};
