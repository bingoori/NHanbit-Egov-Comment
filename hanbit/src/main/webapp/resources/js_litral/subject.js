/**
 * Subject
 */
var subject = { 
		init : function(context) {
		 
			$.getJSON(context+'/subject/list',function(data) {
				var subject_list = '<div id="content" class="container" style="width:1000px;height:450px; margin:0 auto;">'
				+'<table id="subject_list" style="width:100%;margin-top: 30px">'
				+'<tr style="background-color: yellow;">'
				+'<th style="text-align: center;">NO</th>'
				+'<th>과목명</th>'
				+'<th>담당교수</th>'
				+'</tr>';
				
		 		$.each(data.list, function(index,value) {
					subject_list += '<tr><td>'+value.subjSeq+'</td>'
					+'<td><a href="'+context+'/subject/'+value.subjseq+'">'+value.subjName+'</a></td>' 
					+'<td><a href="'+context+'/subject/'+this.profId+'">'+this.profName+'</a></td>'
					+'</tr>';
				}); 
		 		
				subject_list += '</table></div>';
		 		$('#content').html(subject_list);
		 		
		 		$('#subject_list').css('border','1px solid black').css('width','100%').css('margin-top','100px');
		 		$('#subject_list  th').css('border','1px solid black').css('text-align','center');
				$('#subject_list  tr').css('border','1px solid black');
				$('#subject_list  tr  td').css('border','1px solid black').css('text-align','center');
	/* 			+'<c:forEach var="subject" items="${list}">'
				+'<tr>'
				+'<td>${subject.subjSeq}</td>'
				+'<td><a href="${context}/subject/${subject.subjseq}">${subject.subjName}</a></td>'
				+'<td><a href="${context}/subject/${subject.profId}">${subject.profName}</a></td>'
				+'</tr>'
				+'</c:forEach>'; */
				
			});
		}
		
		
};