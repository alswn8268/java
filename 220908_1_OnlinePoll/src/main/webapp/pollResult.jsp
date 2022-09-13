<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.tjoeun.onlinePoll.PollRead"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 일정 시간이 경과되면 특정 웹 사이트로 이동하기 -->
<!-- <meta http-equiv="refresh" content="0.5; url='naver.com'"> -->
<!-- 일정 시간이 경과되면 현재 페이지를 다시 호출하기 -->
<!-- <meta http-equiv="refresh" content="0.5; url='?'"> -->


<title>결과 페이지</title>
<link rel="icon" href="./favicon.png">
</head>
<body style="font-family: 나눔고딕">

<!-- 텍스트 파일에 저장된 투표 결과를 읽어와 브라우저에 표시한다. -->
<% 
//	투표 결과를 웹 브라우저에 출력하기 위해서 텍스트 파일을 읽어 투표 항목의 개수를 계산한다.
	String filepath = application.getRealPath("/") + "poll.txt";
	ArrayList<String> poll = PollRead.pollRead(filepath);
	int itemCount = (poll.size() - 1) / 2;

//	득표율을 계산하기 위해서 전체 투표수를 계산한다.
	int sum = 0;
	for (int i = itemCount + 1; i < poll.size(); i++) {
		sum += Integer.parseInt(poll.get(i));
	}
	
//	숫자 데이터 서식을 설정한다.
	DecimalFormat df1 = new DecimalFormat("#,##0표");
	DecimalFormat df2 = new DecimalFormat("0.00%");
	
%>

<table width="500" border="1" align="center" cellpadding="5" cellspacing="0"; style="border-color: aliceblue;">

	<tr style="font-size: 26px; font-style: bold;">
		<!-- colspan 속성으로 열 합치기를 할 수 있고 rowspan으로 행 합치기를 할 수 있다. -->
		<th colspan="2"><%=poll.get(0)%></th>
	</tr>
	<tr>
		<td colspan="2" align="right">
			총 <%=df1.format(sum)%>
		</td>
	</tr>
	<%
		for (int i = 1; i <= itemCount; i++) {
			int k = Integer.parseInt(poll.get(i + itemCount));
			double p = (double) k / sum;
	%>

	<tr>
		<td width = "200">
			<%=poll.get(i)%>(<%=df1.format(k)%>, <%=df2.format(p)%>)
		</td>
		<td width = "300">
			<hr color="darksalmon" size="10" width="<%=300*p%>" align="left">
		</td>
		
	<%
	}
	%>
	
	</tr>
	
	<tr>
		<td colspan="2" align = "center">
			<input type="button" value="투표하러 가기" onclick="location.href='pollRead.jsp'" style = "background-color: white; color: cadetblue; border-color: lightblue;">
		</td>
	</tr>
	
</table>

</body>
</html>