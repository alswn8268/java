<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 쓰기</title>
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
	
	<form action="insertOK.jsp" method="post">
		<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
			<tr>
				<th colspan="2">방명록 쓰기</th>		
			</tr>
			<tr>
				<th width="100">
					<label for="name">이름</label>
				</th>
				<td width="500">
					<input id="name" type="text" name="name"/>
				</td> 
			</tr>
			<tr>
				<th>
					<label for="password">비밀번호</label>
				</th>
				<td >
					<input id="password" type="password" name="password"/>
				</td> 
			</tr>
			<tr>
				<th>
					<label for="memo">내용</label>
				</th>
				<td>
					<textarea rows="10" id="memo" name="memo" style="resize: none; width: 98.5%;"></textarea>
				</td> 
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input class="button button1" type="submit" value="입력하기"/>
					<input class="button button1" type="reset" value="다시쓰기"/>
					<input class="button button1" type="button" value="돌아가기" onclick="history.back()"/>
				</td>
			</tr>
		</table>
		
		<!-- 글 작성자 ip 주소를 hidden으로 넘겨준다. -->
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>>">
		
		
	</form>
	
</body>
</html>






















