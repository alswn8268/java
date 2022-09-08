<%@page import="java.util.ArrayList"%>
<%@page import="com.tjoeun.onlinePoll.PollRead"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>

<!-- favicon: 인터넷 웹 브라우저의 주소창에 표시되는 웹 사이트를 대표하는 이미지 -->
<link rel="icon" href="./favicon.png">

</head>
<body style="font-family: 나눔고딕">

	<!-- 투표 항목이 저장된 텍스트 파일을 읽어서 웹브라우저에 출력한다. -->
	<%
	//	이클립스는 프로젝트를 실행하면 프로젝트를 이클립스가 내부적으로 사용하는 웹서버에 복사하고 실행한다.
	//	D:\web\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps => real path
	//	application.getRealPath("/") 메소드를 실행하면 프로젝트가 실행되는 실제 경로를 얻어온다.
	//	out.println(application.getRealPath("/") + "poll.txt"); // "/"는 web root(홈페이지의 최초 진입 경로)를 의미한다.
	String filepath = application.getRealPath("/") + "poll.txt";
	//	투표 내용이 저장된 텍스트 파일의 데이터를 읽어오는 메소드를 실행한다.
	ArrayList<String> poll = PollRead.pollRead(filepath);
	//	for (String str : poll) {
	//		out.println(str + "<br>");	
	//	}

	//	투표 항목의 개수
	int itemCount = (poll.size() - 1) / 2;
	//	out.println(itemCount);
	%>

	<form action="pollWrite.jsp" method="post">
	
	<!--cellpadding: 셀 안 여백, 셀을 구성하는 선과 셀 내부 문자와의 간격 
		cellspacing: 셀과 셀 사이의 간격-->
	
		<table width="500" border="1" align="center" cellpadding="5"
			cellspacing="0"; style="border-color: aliceblue;">
			<!-- 줄 만들기 -->
			<tr style="font-size: 26px; font-style: bold;">
				<!-- 줄 -->
				<th><%=poll.get(0)%></th>
				<!-- 칸, 표의 첫 줄을 구성하는 칸, 굵게 및 가운데 정렬되어 표시된다. -->
			</tr>

			<%
			// 투표 항목의 개수만큼 반복하며 radio와 투표 항목을 출력한다.
			for (int i = 1; i <= itemCount; i++) {
			%>
			<tr>
				<!-- 칸, 표의 첫 줄을 제외한 나머지를 구성하는 칸 -->
				<td><input type="radio" name="poll" value="<%=i%>"><%=poll.get(i)%></td>
			</tr>
			<%
			}
			%>

			<!-- 투표 버튼과 결과 버튼을 만든다.-->
			<tr>
				<td align="center">
				<input type="submit" value="투표" style="font-family: 나눔고딕; background-color: white; color: salmon; border-color: lightsalmon;">
				<input type="submit" value="결과" style="font-family: 나눔고딕; background-color: white; color: lightskyblue; border-color: skyblue">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>