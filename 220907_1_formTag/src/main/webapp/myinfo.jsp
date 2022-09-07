<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- html 주석: 지정 => ctrl + shift + /, 해제 => ctrl + shift + \ -->
<%-- jsp 주석: jsp 요소는 html 주석으로 주석 설정이 되지 않는다. --%>
<%--
	<%@ ~ %>: 디렉티브 => 대부분 자동으로 입력된다. import 등 설정에 관련된 정보를 적는다.
	<%! ~ %>: 선언부 => 프로그램에서 사용할 변수나 메소드를 정의한다. => java 파일에서 뽑아내서 사용
	<%= ~ %>: 표현식 => 변수에 저장된 결과나 연산 결과를 출력한다. => EL(${ ~ })로 대체해서 사용한다.
	<%% ~ %>: 스트립트 릿 => 일반적인 jsp 코드를 적는다. => jstl로 대체해서 사용한다.
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀입니다</title>
</head>
<body>

	<!-- html은 spacebar를 여러 번 입력해도 1칸밖에 떨어지지 않고 enter 키를 여러 번 눌러도 줄이 변경되지 않는다.
		2칸 이상 연속해서 띄우려면 &nbsp;를 띄울 칸의 개수만큼 입력하고, 줄을 바꾸려면 <br>태그를 사용한다. -->
내용&nbsp;입니다.<br>안녕하세요?
<form action="myInfoOK.jsp">
	이름: <input type="text" name="name">
	<input type="submit" value="정보보기">
</form>

</body>
</html>