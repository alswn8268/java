<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tjoeun.service.selectService"%>
<%@page import="com.tjoeun.vo.GuestBookList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>
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
.table:nth-child(2n) {
	background-color: lavenderblush;
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
#btn {
	background-color: white;
}
</style>
</head>
<body>

	 <%
	 request.setCharacterEncoding("UTF-8");
	 // list.jsp에서 1페이지 분량의 글 목록과 페이징 작업에 사용할 변수를 저장해서 request 영역에 저장한 GuestbookList 클래스 객체를 받는다.
	 // request 영역에 저장되는 데이터 타입은 Object 타입이므로 반드시 형변환 시켜야 한다.
	 GuestBookList guestBookList = (GuestBookList) request.getAttribute("guestbookList");
	 // out.println(guestBookList);
	 
	 // 브라우저에 출력할 1페이지 분량의 글 목록(guestBookList.getList())만 꺼내 별도의 ArrayList를 만들어 사용한다.
	 ArrayList<GuestbookVO> view = guestBookList.getList();
/* 	 for (GuestbookVO vo : view) {
		 out.println(vo + "<br/>");
	 } */
	 %>

		<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>방명록 보기</th>
		</tr>
		<tr>
			<td align="right">
				<%=guestBookList.getTotalCount()%>개 (<%=guestBookList.getCurrentPage()%> / <%=guestBookList.getTotalPage()%>)
			</td>
		</tr>
		<tr>
			<td>
				<%
				
				if (view.size() == 0) {
					out.println("<h2> 테이블에 저장된 글이 없습니다.</h2>");
				} else {
					// 컴퓨터 시스템의 날짜와 시간을 얻어온다.
					Date date = new Date();
					// 날짜, 시간 서식을 만든다.
					SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)");
					
					for (GuestbookVO vo : view) {
						
						%>
						
						<table class="table" width="98%" align="center" border="1" cellpadding="5" cellspacing="1">
							<tr>
								<td>
									<%=vo.getIdx()%>. <%=vo.getName().replace("<", "&lt").replace(">", "&gt")%>(<%=vo.getIp()%>)님이 
									
									<%
									
									// 오늘 입력된 글은 시간만 표시하고 어제 이전에 입력된 글은 날짜만 표시한다.
									/*
									if (vo.getWriteDate().getDate() == date.getDate() && vo.getWriteDate().getYear() == date.getYear() && vo.getWriteDate().getMonth() == date.getMonth()) {
										out.println(sdf1.format(vo.getWriteDate()));
									} else {
										out.println(sdf2.format(vo.getWriteDate()));										
									}*/
									
									if (sdf2.format(date).equals(sdf2.format(vo.getWriteDate()))) {
										out.println(sdf1.format(vo.getWriteDate()));
									} else {
										out.println(sdf2.format(vo.getWriteDate()));	
									}
									
									%>
								
									에 남긴 글
									
									<!-- 수정 삭제 버튼 추가 -->
									<input class="button button1" type="button" value="수정" onclick="location.href='selectByIdx.jsp?idx=<%=vo.getIdx()%>&currentPage=<%=guestBookList.getCurrentPage()%>&job=update'"/>
									<input class="button button1" type="button" value="삭제" onclick="location.href='selectByIdx.jsp?idx=<%=vo.getIdx()%>&currentPage=<%=guestBookList.getCurrentPage()%>&job=delete'"/>

									
									<br/>
									<%=vo.getMemo().replace("<", "&lt").replace(">", "&gt").replace("\r\n","<br/>")%>				
																		
								</td>
							</tr>
							
							<%
					}
							%>
							
							<tr align="center" id="btn">
								<td>
								
								<%
								if (guestBookList.getCurrentPage() != 1) {
								%>
										<button class="button button1" title="첫 번째 페이지로 이동합니다." onclick="location.href='?currentPage=1'">≪</button>							
								<%	
								} else {
								%>	
										<button class="button button2" disabled title="첫 번째 페이지입니다.">≪</button>			
								<%	
								}
								
								if (guestBookList.getStartPage() > 1) {
								%>
										<button class="button button1" title=" 10페이지 앞으로 이동합니다." onclick="location.href='?currentPage=<%=guestBookList.getStartPage()-1%>'">＜</button>							
								<%	
								} else {
								%>	
										<button class="button button2" disabled title="첫 10페이지입니다.">＜</button>&nbsp;&nbsp;		
								<%	
								}
								
								for (int i = guestBookList.getStartPage(); i <= guestBookList.getEndPage(); i++) {
									if (guestBookList.getCurrentPage() == i) {	
								%>	
									<input class="button button2" type="button" value="<%=i%>" disabled/>					
								<%		
									} else {
								%>
									<input class="button button1" type="button" value="<%=i%>" onclick="location.href='?currentPage=<%=i%>'" value="<%=i%>"/>					
								<%			
									}
								}
								
								if (guestBookList.getEndPage() < guestBookList.getTotalPage()) {
								%>
										&nbsp;&nbsp;
										<button class="button button1" title=" 10페이지 뒤로 이동합니다." onclick="location.href='?currentPage=<%=guestBookList.getEndPage()+1%>'">＞</button>							
								<%	
								} else {
								%>	
										<button class="button button2" disabled title="마지막 10페이지입니다.">＞</button>			
								<%	
								}
								
								if (guestBookList.getCurrentPage() < guestBookList.getTotalPage()) {
								%>
										<button class="button button1" title="마지막 페이지로 이동합니다." onclick="location.href='?currentPage=<%=guestBookList.getTotalPage()%>'">≫</button>							
								<%	
								} else {
								%>	
										<button class="button button2" disabled title="마지막 페이지입니다.">≫</button>			
								<%	
								}
								%>
								
								
								</td>		
							</tr>
							
							<!-- 글쓰기 버튼 -->
							<tr>
								<td align="right">
									<input class="button button1" type="button" value="글 작성" onclick="location.href='insert.jsp'"/>
								</td>
							</tr>
							
						</table>	
						
						<%

				}
				
				%>
			</td>
		</tr>
	</table>
	

</body>
</html>






















