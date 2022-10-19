<%@page import="com.tjoeun.service.UpdateService"%>
<%@page import="com.tjoeun.service.selectService"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update OK</title>
<style type="text/css">
* {
	font-family: "pretendard"
}
.button {
	background-color: palevioletred;
	border: none;
	color: white;
	padding: 4px 4px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	margin: 4px 4px;
	transition-duration: 0.4s;
	cursor: pointer;
	border-radius: 10px;
}

.button1 {
	background-color: white;
	color: black;
	border: 2px solid palevioletred;
}

.button1:hover {
	background-color: palevioletred;
	color: white;
}
table {
	border-color: palevioletred;
}
</style>
</head>
<body>
	
	<%
	request.setCharacterEncoding("UTF-8");
	/* update.jsp에서 넘어오는 데이터를 받는다. */
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	%>
	
	<jsp:useBean id="vo" class="com.tjoeun.vo.GuestbookVO">
		<jsp:setProperty property="*" name="vo"/>
	</jsp:useBean>
	
	<%
	// 수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교하기 위해 수정할 글을 얻어온다.
	GuestbookVO original = selectService.getInstance().selectByIdx(vo.getIdx());

	out.println("<script>");
	if (original.getPassword().trim().equals(vo.getPassword())) {
		
		// 비밀번호가 일치하면 글을 수정하는 메소드를 실행한다.
		UpdateService.getInstance().update(vo);
		
		out.println("alert('" + original.getIdx() + "번 글을 수정했습니다.')");		
	} else {
		// 비밀번호가 일치하지 않으면 오류 메시지를 출력한다.
		out.println("alert('비밀번호가 일치하지 않습니다.')");
	}
	out.println("location.href='list.jsp?currentPage=" + currentPage + "'");
	out.println("</script>");
	%>	
	
</body>
</html>






















