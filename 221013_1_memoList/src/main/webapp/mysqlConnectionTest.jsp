<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mysql에 연결하기</title>
<style type="text/css">
	* {
		font-family: "pretendard";
	}
</style>
</head>
<body>

<%
	Connection conn = null;
	try {
		// mysql 드라이버 클래스를 읽어온다.
		Class.forName("com.mysql.jdbc.Driver"); // 5.x 사용자
		// Class.forName("com.mysql.cjjdbc.Driver"); // 8.x 사용자	
		
		// mysql에 연결한다.
		// DriverManager 클래스의 getConnection(url, user, password) 메소드로 mysql에 연결한다.
		// url: 사용할 mysql이 설치된 경로와 데이터베이스 이름을 적는다.
		String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8"; // 5.x 사용자
		// String url = "jdbc:mysql://localhost:3306/javaam?serverTimezone=UTC"; // 8.x 사용자
		// localhost는 mysql이 설치된 컴퓨터가 현재 사용중인 컴퓨터임을 의미한다.
		// localhost 대신 127.0.0.1을 사용해도 된다.
		// 3306은 mysql이 컴퓨터와 통신할 때 사용하는 포트 번호를 의미한다. (오라클은 1521)
		conn = DriverManager.getConnection(url, "root", "8268");
		
		out.println("연결 성공: " + conn);
		
	} catch (ClassNotFoundException e) {
		out.println("드라이버 클래스가 없거나 읽어올 수 없습니다."); 
	} catch (SQLException e) {
		out.println("데이터베이스 접속 정보가 올바르지 않습니다."); 		
	} finally {
		if (conn != null) {
			try {
				conn.close();			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	 
	
%>

</body>
</html>