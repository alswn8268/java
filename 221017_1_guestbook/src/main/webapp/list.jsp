<%@page import="com.tjoeun.service.selectService"%>
<%@page import="com.tjoeun.vo.GuestBookList"%>
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
	 String category = request.getParameter("category");
	 String item = request.getParameter("item");
	 
	 // 넘어온 검색어가 있으면 카테고리와 검색어를 세션에 저장하고, 넘어온 검색어가 없으면 세션이 저장된 카테고리와 검색어를 읽어온다.
	 GuestBookList guestbookList = selectService.getInstance().selectList(currentPage);
	 if (item != null && item.trim().length() != 0) {
		 session.setAttribute("category", category);
		 item = item.trim().length() == 0 ? "" : item;
		 session.setAttribute("item", item);
	 } else {
		 category = (String) session.getAttribute("category");
		 item = (String) session.getAttribute("item");
	 }
	 
	 // 브라우저 화면에 표시할 한 페이지 분량의 글 목록을 얻어 온다.
	 // 검색어가 넘어온 경우(내용, 이름, 내용+이름)와 넘어오지 않은 경우에 각각 메소드를 실행한다. 	 
	 selectService service = selectService.getInstance();
	 GuestBookList guestbookList = null;
	 
	 // 검색어가 없는 경우와 검색어가 내용, 이름, 내용+이름인 경우를 각각 메소드로 구현한다.
	 if (item == null && item.trim().length() == 0) {
		 // 검색어가 입력되지 않은 경우		 
		 guestbookList = service.selectList(currentPage);
	 } else if (category.equals("내용")) {
		 // 검색어가 입력되고 카테고리가 '내용'인 경우
		 guestbookList = service.selectListMemo(currentPage, item);
	 } else if (category.equals("이름")) {
		 // 검색어가 입력되고 카테고리가 '이름'인 경우
	 } else {	 
		 // 검색어가 입력되고 카테고리가 '내용 + 이름'인 경우
	 }
	 
	 
	 // 한 페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수가 초기화된 객체를 request 영역에 저장한다.
	 request.setAttribute("guestbookList", guestbookList);
	 // 글을 입력할 때 엔터를 눌러 줄을 바꿔 입력한 경우 브라우저에 <br/> 태그로 바꿔 출력하기 위해, request 영역에 "\r\n"을 저장한다.
	 request.setAttribute("enter", "\r\n");
	 
	 // request 영역에 저장된 글 목록을 브라우저에 출력하는 페이지(listView)로 넘긴다.
	 pageContext.forward("listView2.jsp");
	 %>
	
</body>
</html>






















