<%@page import="com.tjoeun.dbcpTest.DBUtil"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat DBCP 연결하기</title>
<style type="text/css">
* {
	font-family: "pretendard";
}
</style>
</head>
<body>

	<%
	Connection conn = DBUtil.getTomcatDBCPConnection();
	out.println("연결 성공: " + conn);
	DBUtil.close(conn);
	%>

</body>
</html>











