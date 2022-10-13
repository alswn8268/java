<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.tjoeun.memoList.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출석 체크 게시판</title>
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

	<!-- 입력 화면 설계 -->
	<form action="memoInsert.jsp" method="post">
		<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
			<tr>
				<th colspan="3">출석 체크 게시판</th>
			</tr>
			<tr>
				<th width="100">이름</th>
				<th width="100">비밀번호</th>
				<th width="800">메모</th>
			</tr>
			<tr>
				<td>
					<input type="text" name="name" style="width: 90%; height: 25px;"/>
				</td>
				<td>
					<input type="password" name="password" style="width: 90%; height: 25px;"/>
				</td>
				<td>
					<input type="text" name="memo"style="width: 92%; height: 25px;"/>
					<input class="button button1" type="submit" value="확인"/>
				</td>
			</tr>
		</table>
	</form>

	<br/>
	<hr size="3" color="palevioletred"/>
	<br/>
	
	<!-- 테이블에 저장된 글 목록 전체를 글번호(idx)의 내림차순(최신순)으로 얻어온다. -->
	<%
		Connection conn = DBUtil.getMysqlConnection();
		String sql = "SELECT * FROM memolist ORDER BY idx DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// ResultSet 객체에 다음 데이터가 없을 때까지 반복하며 얻어온 글 목록을 출력한다.
		// next(): ResultSet 객체에 저장된 다음 데이터로 접근한다. => 다음 데이터가 있으면 true, 없으면 false를 리턴한다.
	/*	if (rs.next()) {

			do {
				out.println(rs.getInt("idx") + ", " + rs.getString("name") + ", " + rs.getString("password") + ", " + rs.getString("memo") + ", " + rs.getString("ip") + ", " + rs.getTimestamp("writeDate") + "<br/>");
			} while (rs.next());
			
		} else {
			// 테이블에 저장된 글이 없는 경우
			out.println("테이블에 저장된 글이 없습니다.<br/>");
		} */
	
	
		
	%>
	
	<!-- 테이블에서 얻어온 글 목록을 출력한다. -->
	<table width="1200" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th width="80">글번호</th>
			<th width="80">이름</th>
			<th width="700">메모</th>
			<th width="200">작성일</th>
			<th width="100">아이피</th>
		</tr>
		
		<%
			if (rs.next()) {
				do {
		%>			
			
			<tr>
				<td><%=rs.getInt("idx")%></td>
				<td><%=rs.getString("name")%></td>
				<td><%=rs.getString("memo")%></td>
				<td><%=rs.getTimestamp("writeDate")%></td>
				<td><%=rs.getString("ip")%></td>
			</tr>
					
		<%		
				} while (rs.next());
					
			} else {
		%>		
			
			<tr>
				<td colspan="5">
					<h2>테이블에 저장된 글이 없습니다.</h2>
				</td>
			</tr>
				
		<%		
			}
		%>
			
	</table>
	
</body>
</html>
	




















