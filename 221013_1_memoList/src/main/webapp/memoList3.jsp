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
	int pageSize = 10; 
	int totalCount = 0;
	int totalPage = 0; 
	int currentPage = 1; 
	int startNo = 0; 
	int endNo = 0; 
	int startPage = 0; 
	int endPage = 0; 
	
	Connection conn = DBUtil.getMysqlConnection();
	
	String sql = "SELECT COUNT(*) FROM memolist";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	totalCount = rs.getInt(1);
	totalPage = (totalCount-1) / pageSize + 1;
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		currentPage = currentPage > totalPage ? totalPage : currentPage;
	} catch (NumberFormatException e) {
		
	}
	startNo = (currentPage - 1) * pageSize;
	endNo = startNo + pageSize - 1 > totalCount ? totalCount : startNo + pageSize - 1;
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
		
		<tr align="center">
			<td colspan="5">
			
			<%
			// 페이지 이동 버튼의 시작 페이지 번호와 마지막 페이지 번호를 계산한다.
			startPage = ((currentPage - 1) / 10) * 10 + 1 ;
			endPage = startPage + 9 > totalPage ? totalPage : startPage + 9;
			// 페이지 이동 버튼의 마지막 번호가 전체 페이지 수보다 커지면 존재하지 않는 페이지 번호가 표시되므로 마지막 페이지 번호를 전체 페이지 번호로 수정한다.
			
			// 처음으로: currentPage가 1보다 크다면 처음으로 이동할 수 있다.
			if (currentPage != 1) {
			%>
					<button class="button button1" title="첫 번째 페이지로 이동합니다." onclick="location.href='?currentPage=1'">≪</button>							
			<%	
			} else {
			%>	
					<button class="button button1" disabled title="첫 번째 페이지입니다.">≪</button>			
			<%	
			}
			
			// 10페이지 단위로 이동 버튼을 출력한다.
			// 10페이지 앞으로: startPage가 1보다 크다면 10페이지 앞으로 이동할 수 있다.
			if (startPage > 1) {
			%>
					<button class="button button1" title=" 10페이지 앞으로 이동합니다." onclick="location.href='?currentPage=<%=startPage-1%>'">＜</button>							
			<%	
			} else {
			%>	
					<button class="button button1" disabled title="첫 10페이지입니다.">＜</button>&nbsp;&nbsp;		
			<%	
			}
			
			for (int i = startPage; i <= endPage; i++) {
				if (currentPage == i) {	
			%>	
				<input class="button button1" type="button" value="<%=i%>" disabled/>					
			<%		
				} else {
			%>
				<input class="button button1" type="button" value="<%=i%>" onclick="location.href='?currentPage=<%=i%>'" value="<%=i%>"/>					
			<%			
				}
			}
			
			// 10페이지 뒤로: endPage가 totalPage보다 작으면 다음 10페이지로 이동할 수 있다.
			if (endPage < totalPage) {
			%>
					&nbsp;&nbsp;
					<button class="button button1" title=" 10페이지 뒤로 이동합니다." onclick="location.href='?currentPage=<%=endPage+1%>'">＞</button>							
			<%	
			} else {
			%>	
					<button class="button button1" disabled title="마지막 10페이지입니다.">＞</button>			
			<%	
			}
			
			// 마지막으로: currentPage가 totalPage보다 작다면 마지막으로 이동할 수 있다.
			if (currentPage < totalPage) {
			%>
					<button class="button button1" title="마지막 페이지로 이동합니다." onclick="location.href='?currentPage=<%=totalPage%>'">≫</button>							
			<%	
			} else {
			%>	
					<button class="button button1" disabled title="마지막 페이지입니다.">≫</button>			
			<%	
			}
			%>

			</td>		
		</tr>

	</table>

</body>
</html>





















