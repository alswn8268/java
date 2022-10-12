<%@page import="com.tjoeun.usebean.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버OK</title>
<style type="text/css">
* {
	font-family: "pretendard"
}

table {
	border-color: palevioletred;
}

.input {
	width: 96%;
	padding: 5px;
}

.button {
	background-color: palevioletred;
	border: none;
	color: white;
	padding: 4px 6px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	margin: 4px 4px;
	transition-duration: 0.4s;
	cursor: pointer;
	border-radius: 10px;
	border: none;
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
</style>
<script type="text/javascript" src="./js/passwordCheck.js" defer="defer"></script>
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8");

	// member.jsp에서 넘어오는 데이터를 받는다.
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	int age = Integer.parseInt(request.getParameter("age"));
	boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

	// form에 저장되어 전송되는 ip 주소를 받는다.
	String ip = request.getParameter("ip");

	// MembeVO 클래스 객체를 만들고, member.jsp에서 넘겨받은 데이터를 넣어준다.
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setName(name);
	vo.setPassword(password);
	vo.setAge(age);
	vo.setGender(gender);
	vo.setIp(ip);

	out.println(vo + "</br>");
	%>

</body>
</html>






















