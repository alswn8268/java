<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 / 로그아웃</title>
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

<%
// post 방식으로 전송되는 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
// 로그인 버튼이 클릭되면 넘어오는 데이터(id, password)를 받는다.
// request.getParameter(): 이전 페이지에서 넘어오는 데이터를 받는다. 넘어오는 데이터가 없으면 null이다.
	String id = "";
	String password = "";
	try {
		id = request.getParameter("id").trim();
		password = request.getParameter("password").trim();
	} catch (NullPointerException e) {
		// catch 블록을 비워두면 예외를 무시한다.
	}
	// out.println("id: " + id + ", password: " + password);
	
	// id가 "hong"이고 password가 "123456"이면 로그인 처리한다.
	if ((id + password).length() != 0) {
		out.println("<script>");
		if (id.equals("hong")&& password.equals("123456")) {
			// 로그인 처리, 로그인 정보를 세션에 저장한다.
			session.setAttribute("id", id);
			session.setAttribute("name", "관리자");
			session.setAttribute("login", "yes");
			out.println("alert('" + session.getAttribute("name") + "님 어서오세요!')");
		} else {
			// 로그인 에러 처리
			out.println("<script>alert('아이디 또는 비밀번호가 올바르지 않습니다.')</script>");
		}
		out.println("</script>");
	}
	
	// 로그아웃 버튼이 클릭되면 넘어오는 데이터(logout)를 받는다.
	String logout = request.getParameter("logout");
	
	// 로그아웃 정보가 넘어왔으면 로그아웃 처리를 한다.
	if (logout != null && logout.equals("yes")) {
		out.println("<script>");
		out.println("alert('" + session.getAttribute("name") + "님 안녕히가세요!')");
		out.println("</script>");		
		// 로그아웃 되었으므로 세션에서 로그인 정보를 제거한다.
		// removeAttribute(): 영역 변수에 저장된 데이터를 제거한다.
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("login");
	}
	
	// 세션에서 로그인 정보를 읽어와서 로그인 상태, 로그아웃 상태의 화면을 브라우저에 출력한다.
	String login = (String) session.getAttribute("login");
	// out.println(login);
	if (login != null && login.equals("yes")) {
%>
		<!-- 로그인 상태일 경우 브라우저에 표시될 내용 -->
		<h2>로그인 성공</h2>
		<%=session.getAttribute("id") %>님 안녕하세요?<br/>
		${id}님 안녕하세요?<br/><br/>
		<input class="button button1" type="button" value="로그아웃" onclick="location.href='?logout=yes'"/>
		
<%		
	} else {
%>		
		<!-- 로그아웃 상태일 경우 브라우저에 표시될 내용 -->
		<form action="?" method="post">
			<table width="300" border="1" cellpadding="5" cellspacing="0">
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id" id="id"/></td>
				</tr>
				<tr>
					<th><label for="password">비밀번호</label></th>
					<td><input type="password" name="password" id="password"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input class="button button1" type="submit" value="login"/>
					</td>
				</tr>
			</table>
		</form>
			
<%		
	}
%>


</body>
</html>