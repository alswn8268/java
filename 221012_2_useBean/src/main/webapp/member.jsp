<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
<script type="text/javascript"src="./js/passwordCheck.js" defer></script>
</head>
<body>

	<form action="memberOK2.jsp" method="post" onsubmit="return passwordCheck(this)">
		<table width="500" border="1" align="center" cellpadding="5" cellspacing="0">
			<tr>
				<th colspan="2">회원 가입</th>
			</tr>
			<tr>
				<th width="150">아이디</th>
				<th width="350"><input class="input" type="text" name="id" placeholder="아이디를 입력하세요." /></th>
			</tr>

			<tr>
				<th>이름</th>
				<th><input class="input" type="text" name="name" placeholder="이름을 입력하세요." /></th>
			</tr>

			<tr>
				<th>비밀번호</th>
				<th><input class="input" type="password" name="password" placeholder="비밀번호를 입력하세요." /></th>
			</tr>

			<tr>
				<th>비밀번호 확인</th>
				<th><input class="input" type="password" name="repassword" placeholder="비밀번호를 한 번 더 입력하세요." /></th>
			</tr>

			<tr>
				<th>나이</th>
				<th><input class="input" type="number" name="age" placeholder="나이를 입력하세요." /></th>
			</tr>

			<tr>
				<th>성별</th>
				<th><input type="radio" name="gender" value="true" checked="checked"/>남자
				<input type="radio" name="gender" value="false" />여자</th>
			</tr>

			<tr>
				<td colspan="2" align="center"><input class="button button1" type="submit" value="회원가입" /> <input class="button button1" type="reset" value="다시 쓰기" /></td>
			</tr>

		</table>	
		<!-- getRemoteAddr() 메소드로 접속자 ip 주소를 얻어올 수 있다. -->
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>"/>		
	</form>

</body>
</html>






















