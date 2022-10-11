<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP의 시스템 영역</title>
</head>
<body>
	
	requestTest.jsp 입니다.<br/>
	
	<%
	// var라는 일반 변수를 선언하지 않았으므로 에러가 발생된다. 
	// out.println("일반 변수: " + var + "<br/>");
	out.println("pageContext 영역 변수: " + pageContext.getAttribute("pageContextVariable") + "<br/>");	
	out.println("request 영역 변수: " + request.getAttribute("requestVariable") + "<br/>");	
	out.println("session 영역 변수: " + session.getAttribute("sessionVariable") + "<br/>");	
	out.println("application 영역 변수: " + application.getAttribute("applicationVariable") + "<br/>");	
	%>
	<hr/>
	
	<%--
	EL(Expression Language, 표현 언어) 내장 객체 => jsp에 표현식(<%= %>)을 대신해서 간단한 데이터 출력을 사용한다.
	EL 사용법 => ${변수이름} 또는 ${객체이름Scope.변수이름} => getter 메소드를 사용한 것과 같은 효과
	jsp의 println() 메소드를 사용해서 영역 변수에 저장된 내용을 출력할 때, 영역 변수에 저장된 데이터가 없으면 null을 출력하지만 EL은 아무것도 출력하지 않는다. 	
	
	영역 객체 이름은 영역 이름 뒤에 Scope를 붙인다.
	--%>

	requestTest.jsp 파일의 pageContext 영역 변수(println() 메소드): <%out.println(pageContext.getAttribute("pageContextVariable") + "<br/>"); %>
	requestTest.jsp 파일의 pageContext 영역 변수(jsp 표현식): <%=pageContext.getAttribute("pageContextVariable")%><br/>
	requestTest.jsp 파일의 pageContext 영역 변수(EL 표현식): ${pageContextScope.pageContextVariable}<br/>
	requestTest.jsp 파일의 pageContext 영역 변수(EL 표현식): ${pageContextVariable}<br/>

</body>
</html>






















