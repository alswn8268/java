<%@page import="com.tjoeun.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
<link rel="stylesheet" href="./css/css.css">
</head>
<body>
	
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	
	<jsp:useBean id="vo" class="com.tjoeun.vo.CategoryVO">
		<jsp:setProperty property="*" name="vo"/>
	</jsp:useBean>
	
	<%
	// category.jsp에서 넘겨받은 메인 카테고리를 테이블에 저장하는 메소드를 호출한다.
	CategoryService.getInstance().insert(vo);
	%>
	
</body>
</html>