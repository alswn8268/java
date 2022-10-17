<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
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
		currentPage를 넘겨 받아 currentPage에 해당되는 1페이지 분량의 글 목록을 데이터베이스 테이블에서 얻어와, request 영역에 저장한 후 1페이지 분량의 글을 출력하는 페이지(listView.jsp)로 넘겨준다.		
	 -->
	 
	 <%
	 request.setCharacterEncoding("UTF-8");
	 // 이전 페이지에서 넘어오는 화면에 표시할 페이지 번호(currentPage)를 받는다.
	 // 게시판이 최초로 실행될 때 또는 insertOK.jsp에서 호출될 때, list.jsp로 currentPage가 넘어오지 않아 NumberFormatException이 발생하므로 예외 처리를 해야 한다.
	 // 이전 페이지에서 넘어오는 currentPage가 없으면 currentPage를 1로 초기화하고, 있으면 currentPage 값을 그대로 사용한다.
	
	 int currentPage = 1;
	 try {
	 	 currentPage = Integer.parseInt(request.getParameter("currentPage")); 
	 } catch (NumberFormatException e) {
		 
	 }
	 
	 // 카테고리와 검색어를 받는다.
	 
	 
	 
	 %>
	
</body>
</html>






















