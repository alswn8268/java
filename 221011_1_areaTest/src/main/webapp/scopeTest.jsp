<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP의 시스템 영역</title>
</head>
<body>
	
	<%
		pageContext.setAttribute("var", "scopeTest.jsp의 pageContext 영역 변수");
		request.setAttribute("var", "scopeTest.jsp의 request 영역 변수");
		session.setAttribute("var", "scopeTest.jsp의 session 영역 변수");
		application.setAttribute("var", "scopeTest.jsp의 application 영역 변수");
	%>
	
	<!-- 
		영역 변수에 저장된 데이터를 얻어올 때 영역 변수 이름만 사용하면 EL은 pageContext => request => session => application 영역을 순서대로 검사해서 얻어오려는 변수가 존재하면 값을 얻어온다.
	 -->
	
	${var}

</body>
</html>






















