<%@page import="java.util.Date"%>
<%@page import="com.tjoeun.usebean.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버OK2</title>
<style type="text/css">
* {
	font-family: "pretendard"
}
</style>
<script type="text/javascript" src="./js/passwordCheck.js" defer="defer"></script>
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8");	
	// Date date = new Date();
	%>
	
	<!-- 
	useBean 액션 태그로 new를 사용하지 않고 객체를 만들 수 있다. 
	id 속성에는 만들 객체의 이름을 쓴다.
	class 속성에는 객체를 만들 클래스의 이름을 풀 패키지 이름으로 쓴다.
	액션 태그는 xml 문법을 따르기 때문에, <tag>와 </tag> 사이에 아무런 내용이 없을 경우 생략할 수 있지만 <tag>의 끝에 "/"를 입력해서 <tag/>의 형태로 만든다.	
	-->

	<%-- <jsp:useBean id="date" class="java.util.Date"></jsp:useBean> --%>
	<jsp:useBean id="date" class="java.util.Date"/>
	${date}<br/>

	<!-- useBean을 이용해서 MemberVO 객체를 만든다. -->
	<jsp:useBean id="vo" class="com.tjoeun.usebean.MemberVO">
		<!-- 
			setProperty 액션 태그는 지정한 필드의 setter 메소드를 실행한다.
			property 속성에는 setter 메소드를 실행할 필드 이름을 쓴다.		 
			name 속성에는 setter 메소드를 실행할 필드가 정의된 객체 이름을 쓴다.	
			useBean 액션 태그를 사용하면 이전 페이지에서 넘어온 데이터를 받는 동작을 자동으로 실행한다.	 
		 -->	
		 
		<%-- <jsp:setProperty property="id" name="vo"/>
		<jsp:setProperty property="name" name="vo"/>
		<jsp:setProperty property="password" name="vo"/>
		<jsp:setProperty property="age" name="vo"/>
		<jsp:setProperty property="gender" name="vo"/>
		<jsp:setProperty property="ip" name="vo"/> --%>
		
		<!-- 
			property 속성에 "*"을 입력하면 모든 필드에 setter 메소드가 실행된다.
			단, form의 name 속성의 속성값과 같은 이름을 가지는 필드의 setter 메소드만 실행된다.
		 -->
		
		<jsp:setProperty property="*" name="vo"/>
		
	</jsp:useBean>
	
	${vo};

</body>
</html>






















