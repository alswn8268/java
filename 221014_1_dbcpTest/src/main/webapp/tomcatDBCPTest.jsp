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
	// lib 폴더에 tomcat-dbcp.jar 파일을 복사해 넣는다. => tomcatDBCP 드라이버
	// META-INF 폴더에 context.xml 파일을 만든다.
	// web.xml 파일에 다음 내용을 코딩한다.
/* 		<!-- tomcatDBCP 사용 설정 -->
	<resource-ref>
		<description>tomcat DBCP mysql Connection</description>
		<res-ref-name>jdbc/TestDB</res-ref-name>
		<res-type>javax.sql.DataSource</res-type>
		<res-auth>Container</res-auth>
	</resource-ref> */
	
	Connection conn = null;
	try {
		Context initContext = new InitialContext();
		// Context envContext = (Context) initContext.lookup("java:/comp/env");
		// DataSource dataSource = (DataSource) envContext.lookup("jdbc/TestDB");
		// 위 2줄을 tomcat server 7.0부터는 아래와 같이 적는다.
		DataSource dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/TestDB");
	
		conn = dataSource.getConnection();
		
		out.println("연결 성공: " + conn);
	} catch (Exception e){
		e.printStackTrace();
	}
	
	
	
	
	%>

</body>
</html>











