<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지 삽입</title>
<style type="text/css">
* {
	font-family: "pretendard"
}

.button {
	background-color: cornflowerblue;
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
	border: 2px solid cornflowerblue;
}

.button1:hover {
	background-color: cornflowerblue;
	color: white;
}
</style>
</head>
<body>

	<!-- include 디렉티브를 사용해서 중복되는 jsp 코드 삽입하기 -->
	<%@include file="/loginTest.jsp" %>
	<hr/>
	
	<!-- include 액션 태그를 사용해서 중복되는 jsp 코드 삽입하기-->
	<jsp:include page="./loginTest.jsp"></jsp:include>

</body>
</html>





























