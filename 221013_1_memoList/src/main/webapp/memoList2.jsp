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
a {
	color: black;
	text-decoration: none;
}
a:visited {
	color: darkgray;
}
a:hover {
	color: palevioletred;
}
span {
	background-color: palevioletred;
	color: white;
}
</style>
</head>
<body>

	<form action="memoInsert.jsp" method="post">
		<table width="1000" align="center" border="1" cellpadding="5"
			cellspacing="0">
			<tr>
				<th colspan="3">출석 체크 게시판</th>
			</tr>
			<tr>
				<th width="100">이름</th>
				<th width="100">비밀번호</th>
				<th width="800">메모</th>
			</tr>
			<tr>
				<td><input type="text" name="name" style="width: 90%; height: 25px;" /></td>
				<td><input type="password" name="password" style="width: 90%; height: 25px;" /></td>
				<td><input type="text" name="memo" style="width: 92%; height: 25px;" /> <input class="button button1" type="submit" value="확인" /></td>
			</tr>
		</table>
	</form>

	<br />
	<hr size="3" color="palevioletred" />
	<br />

	<%
	// 페이징 작업에 사용할 8개의 변수를 선언한다. => 계산에 의해 값을 가져야하는 변수는 0으로 초기화한다.
	int pageSize = 10; // 1페이지에 표시하려는 글의 개수
	int totalCount = 0; // 테이블에 저장된 전체 글의 개수
	int totalPage = 0; // 전체 페이지 개수
	int currentPage = 1; // 현재 브라우저에 표시되는 페이지 번호
	int startNo = 0; // 현재 브라우저에 표시되는 글의 시작 인덱스 번호. mysql은 인덱스가 0부터 시작된다.
	int endNo = 0; // 현재 브라우저에 표시되는 글의 마지막 인덱스 번호. mysql에서는 사용하지 않는다.
	int startPage = 0; // 페이지 이동 하이퍼링크 또는 버튼에 표시될 시작 페이지 번호
	int endPage = 0; // 페이지 이동 하이퍼링크 또는 버튼에 표시될 마지막 페이지 번호
	
	Connection conn = DBUtil.getMysqlConnection();
	
	// totalCount 변수에 테이블에 저장된 전체 글의 개수를 얻어와서 저장한다.
	String sql = "SELECT COUNT(*) FROM memolist";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	// 테이블에 저장된 글이 있으면 글의 개수를 얻어와서 ResultSet 객체에 저장하고, 테이블에 저장된 글이 없으면 0을 ResultSet 객체에 저장하므로 물어보는 동작을 할 필요가 없다.
	rs.next();
	totalCount = rs.getInt(1);
	// out.println("테이블에 저장된 전체 글의 개수: " + totalCount + "개<br/>");
	
	// totalPage 변수에 전체 페이지 개수를 계산해 저장한다.
	totalPage = (totalCount-1) / pageSize + 1;
	// out.println("전체 페이지 수: " + totalPage + "개<br/>");
	
	// 이전 페이지에서 넘어온 브라우저에 표시할 페이지 번호를 받는다.
	// 이전 페이지에서 currentPage가 넘어오지 않으면 null값을 갖는다.(NumberFormatException) => 예외 처리
	// currentPage가 정상적으로 넘어오면 정수로 바꿔서 저장하고, 그렇지 않으면 초기값 1이 유지되게 한다.
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		// 현재 화면에 표시할 페이지 번호는 전체 페이지 수보다 클 수 없으므로, 이보다 큰 값이 넘어왔다면 전체 페이지 수로 수정한다.
		currentPage = currentPage > totalPage ? totalPage : currentPage;
	} catch (NumberFormatException e) {
		
	}
	// out.println("현재 화면에 표시되는 페이지 번호: " + currentPage + "<br/>");
	
	// startNo 변수에 현재 화면에 표시할 글 목록의 시작 인덱스 번호를 계산한다.
	// mysql은 select sql 명령을 실행했을 때 맨 처음 나오는 글의 인덱스가 0부터 시작되고, oracle은 1부터 시작된다.
	startNo = (currentPage - 1) * pageSize;
	endNo = startNo + pageSize - 1 > totalCount ? totalCount : startNo + pageSize - 1;
	// mysql은 limit을 사용하기 때문에 endNo를 계산할 필요가 없다.
	// 마지막 페이지에 표시되는 글의 개수는 반드시 화면에 표시할 글의 개수(pagrSize)만큼 표시되는 게 아니다.
	// 한 페이지에 표시될 마지막 글의 인덱스는 전체 글의 개수보다 커지면 안 되므로, 이보다 큰 값이 넘어왔다면 전체 글의 개수로 수정한다.
	// out.println("현재 화면에 표시되는 글 목록의 시작 인덱스 번호: " + startNo + "<br/>");

	// memoList.jsp에서 사용했던 select sql 명령을 limit를 사용해 현재 페이지에 출력할 내용만 얻어오게 수정한다.
	
	// sql = "SELECT * FROM memolist ORDER BY idx DESC";
	sql = "SELECT * FROM memolist ORDER BY idx DESC limit ?, ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, startNo);
	pstmt.setInt(2, pageSize);
	rs = pstmt.executeQuery();
	%>
	
	<table width="1200" align="center" border="1" cellpadding="5"
		cellspacing="0">
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
		
	<!-- 첫 페이지부터 마지막 페이지까지 이동할 수 있는 하이퍼링크 또는 버튼을 만든다. -->
		<tr align="center">
			<td colspan="5">
			
			<%
				for (int i = 1; i < totalPage; i++) {
					if (currentPage == i) {
						
			%>		
				<%-- <a href="?currentPage=<%=i%>">[<%=i%>]</a>	 --%>
				<input class="button button1" type="button" value="<%=i%>" disabled/>					
			<%		
					} else {
			%>
				<input class="button button1" type="button" value="<%=i%>" onclick="location.href='?currentPage=<%=i%>'" value="<%=i%>"/>					
			<%			
					}
				}
			%>
			
			</td>		
		</tr>
	
			<tr align="center">
			<td colspan="5">
			
			<%
				for (int i = 1; i < totalPage; i++) {
					if (currentPage == i) {
						out.println("<button class='button button1' type='button'>" + i + "</button>");	
					} else {
						out.println("<button class='button button1' type='button' onclick='location.href=\"?currentpage=" + i + "\"'>" + i + "</button>");		
					}
				}
			%>
			
			</td>		
		</tr>
	</table>

</body>
</html>





















