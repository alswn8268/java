<%@page import="com.tjoeun.service.selectService"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select by idx</title>
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
	
	<!-- 
		수정 또는 삭제할 글 1건을 얻어와서 request 영역에 저장한 후 수정 또는 삭제할 글을 브라우저에 표시하는 페이지(delete.jsp, update.jsp)로 넘겨준다.
	 -->
	<%
	// listView2.jsp 수정 또는 삭제 버튼을 클릭했을 때 넘어오는 데이터를 받는다.
	request.setCharacterEncoding("UTF-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	String job = request.getParameter("job");
	
	// 수정 또는 삭제할 글 1건을 얻어온다.
	GuestbookVO vo = selectService.getInstance().selectByIdx(idx);
	// out.println(vo);
	
	// 수정 또는 삭제할 글이 테이블에 존재하지 않으면 에러 메시지를 출력하고, list.jsp로 돌려보낸다.
	// 수정 또는 삭제할 글이 존재하면 수정 버튼이 클릭된 경우 수정할 글을 브라우저에 보여주는 페이지(update.jsp)로 보내고 삭제 버튼이 클릭된 경우 삭제할 글을 브라우저에 보여주는 페이지(delete.jsp)로 넘겨준다.
	
	if (vo == null) {
		out.println("<script>");
		out.println("alert('" + idx + "번 글이 존재하지 않습니다.')");
		out.println("</script>");
		out.println("location.href='list.jsp?currentPage=" + currentPage + "'");
	} else {
		// request 영역에 얻어온 글, 돌아갈 페이지 번호, 줄바꿈에 사용할 \r\n을 저장해서 넘겨준다.
		request.setAttribute("vo", vo);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("enter", "\r\n");
		
		pageContext.forward(job + ".jsp");			
	}	
	%>
	
</body>
</html>






















