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
.button2 {
	background-color: lightgray;
	color: white;
	border: 2px solid gray;
	cursor: not-allowed;
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
	
	// 페이지 당 표시할 글의 개수를 받아 pageSize 변수에 저장한다.
	// 게시판이 최초로 실행될 때 이전 페이지가 없거나 보기 버튼 이외의 다른 버튼이 클릭되면 넘어오는 pageSize 값이 null이 된다. => 예외 처리
	try {
		pageSize = Integer.parseInt(request.getParameter("pageSize"));		
		// 화면에 표시할 글의 개수가 정상적으로 넘어왔으므로 화면에 표시할 글의 개수를 세션에 저장한다.
		session.setAttribute("pageSize", pageSize + "");
	} catch (NumberFormatException e) {
		// 보기 버튼을 제외한 나머지 버튼은 pageSize를 전달하는 기능이 없어서 NumberFormatException이 발생한다. 
		// 이전 페이지에서 넘어오는 pageSize가 null이면 세션에 저장해둔 pageSize를 얻어와 화면에 표시한다.
		// 브라우저가 최초로 실행될 때 세션이 만들어져서, 이전 페이지에서 넘어오는 pageSize와 세션에 저장된 pageSize가 null이다.
		String temp = (String) session.getAttribute("pageSize");
		if (temp != null ) {
			pageSize = Integer.parseInt(temp);			
		}
	}
	
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
	
	<table width="1300" align="center" border="1" cellpadding="5"
		cellspacing="0">
		<tr>
			<th width="80">글번호</th>
			<th width="80">이름</th>
			<th width="700">메모</th>
			<th width="200">작성일</th>
			<th width="100">아이피</th>
			<th width="100">&nbsp</th>
		</tr>
		
		<!-- 한 페이지에 표시할 글의 개수를 변경한다. -->
		<tr>
			<td colspan="3">
				<form action="" method="post">
					페이지당 표시할 글의 개수를 선택하세요: 
					<select name="pageSize" width="50px;">
						<option>3</option>
						<option>5</option>
						<option selected>10</option>
						<option>15</option>
						<option>20</option>
					</select>
					<input class="button button1" type="submit" value="보기">
				</form>
			</td>
			<td colspan="3" align="right">
				<%=totalCount%>개 (<%=currentPage%> / <%=totalPage%>)페이지
			</td>
		</tr>

		<%
		if (rs.next()) {
			do {
		%>

		<tr>
			<td><%=rs.getInt("idx")%></td>
			<td><%=rs.getString("name").replace("<", "&lt;").replace(">", "&gt;")%></td>
			<td><%=rs.getString("memo").replace("<", "&lt;").replace(">", "&gt;")%></td>
			<td><%=rs.getTimestamp("writeDate")%></td>
			<td><%=rs.getString("ip")%></td>
			
			<!-- 수정, 삭제 버튼 추가 -->
			<td align="center">
				<button class="button button1" type="button" onclick="location.href='memoUpdate.jsp?idx=<%=rs.getInt("idx")%>&currentPage=<%=currentPage%>'">수정</button>
				<button class="button button1" type="button" onclick="location.href='memoDelete.jsp?idx=<%=rs.getInt("idx")%>&currentPage=<%=currentPage%>'">삭제</button>
			</td>
			
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
			<td colspan="6">
			
			<%
			startPage = ((currentPage - 1) / 10) * 10 + 1 ;
			endPage = startPage + 9 > totalPage ? totalPage : startPage + 9;
			if (currentPage != 1) {
			%>
					<button class="button button1" title="첫 번째 페이지로 이동합니다." onclick="location.href='?currentPage=1'">≪</button>							
			<%	
			} else {
			%>	
					<button class="button button2" disabled title="첫 번째 페이지입니다.">≪</button>			
			<%	
			}
			
			if (startPage > 1) {
			%>
					<button class="button button1" title=" 10페이지 앞으로 이동합니다." onclick="location.href='?currentPage=<%=startPage-1%>'">＜</button>							
			<%	
			} else {
			%>	
					<button class="button button2" disabled title="첫 10페이지입니다.">＜</button>&nbsp;&nbsp;		
			<%	
			}
			
			for (int i = startPage; i <= endPage; i++) {
				if (currentPage == i) {	
			%>	
				<input class="button button2" type="button" value="<%=i%>" disabled/>					
			<%		
				} else {
			%>
				<input class="button button1" type="button" value="<%=i%>" onclick="location.href='?currentPage=<%=i%>'" value="<%=i%>"/>					
			<%			
				}
			}
			
			if (endPage < totalPage) {
			%>
					&nbsp;&nbsp;
					<button class="button button1" title=" 10페이지 뒤로 이동합니다." onclick="location.href='?currentPage=<%=endPage+1%>'">＞</button>							
			<%	
			} else {
			%>	
					<button class="button button2" disabled title="마지막 10페이지입니다.">＞</button>			
			<%	
			}
			
			if (currentPage < totalPage) {
			%>
					<button class="button button1" title="마지막 페이지로 이동합니다." onclick="location.href='?currentPage=<%=totalPage%>'">≫</button>							
			<%	
			} else {
			%>	
					<button class="button button2" disabled title="마지막 페이지입니다.">≫</button>			
			<%	
			}
			%>

			</td>		
		</tr>

	</table>

</body>
</html>





















