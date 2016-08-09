 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<c:set var="user" value="${sessionScope.user}" />
<c:out value="${user}"/>

<c:choose>
	<c:when test="${empty sessionScope.user} ||  ${empty sessionScope.admin}">
		<jsp:include page="../global/header.jsp"/>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${user.role eq 'admin'}">
				<jsp:include page="../admin/header.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="../global/header.jsp"/>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose> 




<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>성적관리</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type='text/javascript'>
/*<![CDATA[*/
(function($) {
	ids = ['#wikiSideMenu', '#project_etc', '#sub_menu'];
	wrap = ['#content_project_sub', '#content_wrap', '#snb'];

	function fix_height(wrap, ids) {
        
		for (var i = 0; i < wrap.length; i++) {
                        var height;
			if ($(wrap[i]).length > 0) {
                        /* removed document.all since it is not necessary to use in modern browser */
				height = $(wrap[i]).height();
				/* reset position:relative of the content_project_sub. See [#3822] */
				$(wrap[i]).css('position', 'static');
			
                        /* moved some codes to inside loop to make sure variable height 
                         * can be calculated
                         */
                        var del = 0;
                        for (var i = 0; i < ids.length; i++) {
                                if ($(ids[i]).length > 0) {
                                        var h = $(ids[i]).height();
                                        if (del == 0) del = h - height;
                                        $(ids[i]).height(height);
                                        fake_pad = parseInt($(ids[i]).css("padding-bottom")) + parseInt($(ids[i]).css("margin-bottom"));
                                        if (fake_pad > 0) {
                                                $(ids[i]).css("padding-bottom", fake_pad);
                                        } else {
                                                $(ids[i]).css("padding-bottom", "30px");
                                        }
                                        $(ids[i]).css("margin-bottom", 0);
                                }
                        }
                        
                        break;
			}
		}
		
	}
        var oldOnload = window.onload;
        if (typeof window.onload != 'function') {
                window.onload = function() {
			getGNB();
			fix_height(wrap, ids);
			fix_webkit();
                }
        } else {
                window.onload = function() {
                        oldOnload();
			getGNB();
			fix_height(wrap, ids);
			fix_webkit();
                }
        }
})(jQuery);
/*]]>*/
</script></head>
<body>
<jsp:include page="../global/default_header.jsp"/>
<c:choose>
	<c:when test="empty sessionScope.user || empty sessionScope.admin">
		<jsp:include page="../global/default_header.jsp"/>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${user.level eq 'admin'}">
				<jsp:include page="../admin/admin_header.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="../member/member_header.jsp"/>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose> --%>
