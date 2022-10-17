<%@page import="com.tjoeun.service.InsertService"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert OK</title>
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
	/*
	// insert.jsp에서 넘어오는 데이터를 받는다.
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String memo = request.getParameter("memo");
	String ip = request.getParameter("ip");
	
	// out.println("name: " + name + ", password: " + password + ", memo: " + memo + ", ip: " + ip);
	GuestbookVO vo = new GuestbookVO();
	vo.setName(name);	
	vo.setPassword(password);
	vo.setMemo(memo);
	vo.setIp(ip);
	out.println(vo);
	*/
	%>
	
	<!-- insert.jsp에서 넘어오는 데이터를 받는다. -->
	<!-- 이전 페이지에서 넘어오는 데이터가 VO 클래스의 필드로 존재하면 useBean 액션 태그를 이용해서 받는다. -->
	<jsp:useBean id="vo" class="com.tjoeun.vo.GuestbookVO">
		<jsp:setProperty property="*" name="vo"/>
	</jsp:useBean>
	${vo}
	
	<%
	// VO 클래스 => 글 1건을 기억하는 클래스
	// List 클래스 => 1페이지 분량의 글 목록과 페이징에 사용할 8개의 변수를 저장하는 클래스
	// Service 클래스 => sql 명령을 실행하기 전에 전처리 작업을 수행하는 클래스, 비즈니스 로직을 작성하는 클래스
	// DAO(Date Access Object) => 데이터베이스에 접속해서 sql 명령을 실행하는 클래스	
	
	// insert.jsp에서 넘어온 데이터를 guestbook 테이블에 저장한다.
	// 데이터가 저장된 객체(vo)를, 전처리 작업을 위해 Service 클래스로 넘겨서 DAO 클래스에서 sql 명령을 실행하기 전에 필요한 작업이 있으면 실행한다. 
	InsertService.getInstance().insert(vo);
	
	// 테이블에 글 1건을 저장했으면 테이블에 저장된 글을 브라우저에 출력하기 위해서 1페이지 분량의 글 목록을 얻어오는 페이지(list.jsp)로 넘겨준다.
	response.sendRedirect("list.jsp");
	%>	
	
</body>
</html>






















