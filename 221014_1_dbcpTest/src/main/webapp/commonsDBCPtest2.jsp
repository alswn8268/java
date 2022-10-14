<%@page import="com.tjoeun.dbcpTest.DBUtil"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commons DBCP 연결하기</title>
<style type="text/css">
	* {
		font-family: "pretendard";
	}
</style>
</head>

<body>

	<%
	Connection conn = DBUtil.getCommonsDBCPConnection();
	out.println("연결 성공: " + conn + "<br/>");
	DBUtil.close(conn);
	%> 

</body>
</html>