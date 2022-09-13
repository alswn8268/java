<%@page import="com.tjoeun.onlinePoll.PollWrite"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tjoeun.onlinePoll.PollRead"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 데이터</title>
</head>
<body>

	<!-- pollRead.jsp에서 넘어오는 투표했던 항목을 받아서 득표수를 증가시켜 텍스트 파일에 저장한다. -->
	<%
	//	post 방식으로 데이터가 넘어올 때 한글 깨짐을 방지한다.
	request.setCharacterEncoding("UTF-8");
	//	pollRead.jsp에서 넘어오는 투표 데이터를 받는다.
	String temp = request.getParameter("poll");

	//	에러체크
	//	투표 데이터가 넘어왔는지(null 또는 공백이 아닌가) 확인한다. => 반드시 null 검사를 먼저 한다.
	if (temp != null && temp.trim().length() != 0) {

		// 넘어온 투표 데이터가 숫자인가 검사한다.
		try {
			int result = Integer.parseInt(temp);

			// 텍스트 파일을 읽어서 투표 항목의 개수를 계산한다.
			String filepath = application.getRealPath("/") + "poll.txt";
			ArrayList<String> poll = PollRead.pollRead(filepath);
			int itemCount = (poll.size() - 1) / 2;

			// 넘어온 투표 데이터가 숫자인 경우 정상적인 투표 범위의 데이터인가 검사한다.
			if (result >= 1 && result <= itemCount) {
				// 투표한 항목의 데이터를 증가시켜 텍스트 파일에 저장한다.
				
				// 득표수를 1 증가시킬 위치를 계산한다.
				int index =  result + itemCount;
				// 득표수를 1 증가시킨다. => poll ArrayList의 index번째 데이터를 1 증가시킨다.
				result = Integer.parseInt(poll.get(index)) + 1;
				
				// 1증가된 득표수를 다시 ArrayList에 index번째 위치에 넣어준다.
				// poll.set(index, String.valueOf(result));
				// poll.set(index, String.format("%s", result));
				// poll.set(index, Integer.toString(result));
				poll.set(index, result + "");
				
				// poll ArrayList의 데이터를 텍스트 파일에 저장하는 메소드를 실행한다.
				PollWrite.pollWrite(filepath, poll);
				
				// 투표 결과보기 페이지로 넘겨준다.
				response.sendRedirect("pollResult.jsp");
				
			} else {
		// 넘어온 투표 데이터가 정상적인 투표 범위의 숫자가 아니므로 pollRead.jsp로 돌려보낸다.				
		out.println("<script>");
		out.println("alert('투표 데이터가 정상 투표 범위가 아닙니다.')");
		out.println("location.href='pollRead.jsp'");
		out.println("location.href='pollRead.jsp'");
		out.println("</script>");
			}
		} catch (NumberFormatException e) {
			// 넘어온 투표 데이터가 숫자가 아니므로 오류 메시지를 출력하고 pollRead.jsp로 돌려보낸다.				
			out.println("<script>");
			out.println("alert('투표 데이터가 숫자가 아닙니다.')");
			out.println("location.href='pollRead.jsp'");
			out.println("</script>");
		}

	} else {
		// 투표 데이터가 넘어오지 않았으므로 오류 메시지를 출력하고 pollRead.jsp로 돌려보낸다.
		out.println("<script>");
		out.println("alert('투표를 하지 않았습니다.')");
		out.println("location.href='pollRead.jsp'");
		out.println("</script>");

		//		하나의 jsp 파일에 서버용 스크립트(jsp)와 클라이언트용 스크립트(javascript)를 모두 사용한 경우, 코딩 순서와는 무관하게 서버용 스크립트가 먼저 다 실행되고 난 후 클라이언트용 스크립트가 실행된다.
		//		response.sendRedirect() 메소드는 인수로 지정된 페이지로 넘겨준다.
		//		response.sendRedirect("pollRead.jsp");
	}
	%>

</body>
</html>