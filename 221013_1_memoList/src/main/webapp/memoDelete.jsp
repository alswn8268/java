<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.tjoeun.memoList.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제할 글 보기</title>
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
</style>
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8");
	// memoList4.jsp에서 넘어오는 삭제할 글번호(idx)와 삭제 후 돌아갈 페이지 번호(currentPage)를 받는다.
	String tempIdx = request.getParameter("idx");
	String tempCurrentPage = request.getParameter("currentPage");
	
	// 삭제할 글 번호와 삭제 후 돌아갈 페이지 번호가 모두 넘어왔는지 검사한다.
	if (tempIdx != null && tempCurrentPage != null && tempIdx.trim().length() != 0 && tempCurrentPage.trim().length() != 0) {
		// 삭제할 글 번호와 돌아갈 페이지 번호가 모두 숫자인지 검사한다.
		try {
			int idx = Integer.parseInt(tempIdx);
			int currentPage = Integer.parseInt(tempCurrentPage);		
			// 삭제할 글번호에 해당되는 글이 테이블에 존재하는지 검사하기 위해 글번호에 해당되는 글을 얻어온다.
			Connection conn = DBUtil.getMysqlConnection();
			String sql = "SELECT * FROM memolist WHERE idx = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			 
			// 삭제할 글이 테이블이 존재하는지 검사한다.
			if (rs.next()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) a hh:mm:ss");
				%>
				
				<!-- 삭제할 글이 테이블에 존재하므로 삭제할 글을 화면에 보여주고 비밀번호를 입력받는다. -->
				<form action="deleteOK.jsp" method="post">
					<table width="700" align="center" border="1" cellpadding="5" cellspacing="0">
						<tr>
							<th colspan="2">삭제할 글 확인</th>
						</tr>
						<tr>
							<td width="100">글번호</td>
							<td width="600"><%=rs.getInt("idx")%></td>
						</tr>
						<tr>
							<td width="100">이름</td>
							<td width="600"><%=rs.getString("name").replace("<", "&lt;").replace(">", "&gt;")%></td>
						</tr>
						<tr>
							<td width="100">작성일</td>
							<td width="600"><%=sdf.format(rs.getTimestamp("writeDate"))%></td>
						</tr>
						<tr>
							<td width="100">내용</td>
							<td width="600"><%=rs.getString("memo").replace("<", "&lt;").replace(">", "&gt;")%></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<label>
									비밀번호 <input type="password" name="password"/>
									<input class="button button1" type="submit" value="삭제">
									<input class="button button1" type="reset" value="리셋">
									<input class="button button1" type="button" value="돌아가기1" onclick="history.back()">
									<input class="button button1" type="button" value="돌아가기2" onclick="history.go(-1)"> 
									<input class="button button1" type="button" value="돌아가기3" onclick="location.href='memoList4.jsp?currentPage=<%=currentPage%>'"> 
								</label>
							</td>
						</tr>
					</table>
				
					<!-- 삭제할 글번호와 삭제 후 돌아갈 페이지 번호도 deleteOK.jsp로 넘겨줘야 한다. -->
					<input type="text" name="idx" value="<%=rs.getInt("idx")%>" hidden>
					<input type="text" name="currentPage" value="<%=currentPage%>" hidden>
					
					
				</form>
				
				<%
				DBUtil.close(conn);				
			} else {
				out.println("<script>");
				out.println("alert(idx + '번 글이 없습니다.')");		
				out.println("location.href='memoList4.jsp'");
				out.println("</script>");
			}
			
		} catch (NumberFormatException e) {
			out.println("<script>");
			out.println("alert('삭제할 글 번호 또는 돌아갈 페이지 번호가 숫자가 아닙니다.')");		
			out.println("location.href='memoList4.jsp'");
			out.println("</script>");
		}	
	} else {
		// 삭제할 글 번호와 돌아갈 페이지 번호가 모두 넘어오지 않아서 에러 메시지를 출력하고 memoList4.jsp의 1페이지로 돌려보냄
		out.println("<script>");
		out.println("alert('삭제할 글 번호 또는 돌아갈 페이지 번호가 없습니다.')");		
		out.println("location.href='memoList4.jsp'");
		out.println("</script>");
	}
	%>
	
</body>
</html>


































