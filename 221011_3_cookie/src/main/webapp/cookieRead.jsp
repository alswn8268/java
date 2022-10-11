<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 읽기</title>
<style type="text/css">
* {
	font-family: "pretendard";
}
</style>
</head>
<body>
	
	<%
		// 쿠키를 읽어올 때는 여러 개를 한 번에 읽어와야 하기 때문에 배열로 받는다.
		Cookie[] cookies = request.getCookies();
		// out.println(cookies + "<br/>");
		//out.println(Arrays.toString(cookies) + "<br/>");
		
		for (Cookie cookie : cookies) {
			// getName(): 쿠키 이름을 얻어온다.
			// getValue(): 쿠키 내용을 얻어온다.
			// JSESSIONID는 jsp가 사용하는 시스템 쿠키로 접속한 컴퓨터를 식별하는 용도로 사용된다.
			
			// 8.0 버전이어도 읽어올 때는 인코딩을 하지 않아도 되지만, 인코딩 된 유니코드 자체를 가져오기 때문에 읽을 수 없다. => 디코딩을 해야 한다.
			out.println("쿠키 이름: " + cookie.getName() + ", 쿠키 내용: " + cookie.getValue() + "<br/>");
				URLDecoder.decode(cookie.getValue() + "<br/>");			
	
		}
	%>
	
	쿠키 읽기 완료
	
</body>
</html>











































