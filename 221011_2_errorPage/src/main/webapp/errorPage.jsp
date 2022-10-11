<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error Page</title>
<style type="text/css">
	* {
		font-family: "pretendard"
	}
</style>
</head>
<body>

	<a href="pageOK.jsp">클릭click</a>

	<%
		// int i = 10 / 0;
		// int j = Integer.parseInt("배고파");	
		ArrayList<String> list = null;
		out.println(list.get(0));
	%>

</body>
</html>




































