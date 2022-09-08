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
<body style="font-family: 나눔고딕">

<!-- html은 spacebar를 여러 번 입력해도 1칸밖에 떨어지지 않고 enter 키를 여러 번 눌러도 줄이 변경되지 않는다.
		2칸 이상 연속해서 띄우려면 &nbsp;를 띄울 칸의 개수만큼 입력하고, 줄을 바꾸려면 <br>태그를 사용한다. -->
		
내용&nbsp;입니다.<br>안녕하세요?

<!-- 현재 페이지에 입력한 데이터를 특정 페이지로 전송하려면, 전송할 데이터를 입력하는 코드를 <form> ~ </form> 사이에 작성해야 한다.
	action 속성은 전송(type="submit") 버튼이 클릭되면 form에 입력한 데이터를 가지고 넘어갈 jsp 페이지 이름을 쓴다.
	method 속성은 action 페이지로 데이터가 전송될 때 정보가 url(주소) 창에 표시되는 여부를 지정한다.
	action 속성의 기본 값은 "get"이고 전송되는 데이터가 url 창에 표시되고 "post"로 변경하면 url 창에 표시되지 않는다.-->

<form action="myInfoOK.jsp" method="post">
	<label>이름: <input type="text" name="name"> </label> <br>
	<label>아이디: <input type="text" name="id"> </label> <br>
<!-- type="password"일 경우 한글을 타이핑해서 넣을 수 없다. -->
	<label>비밀번호: <input type="password" name="password"> </label> <br>
	<label>나이: <input type="text" name="age"> </label> <br><br>
	
	<!-- radio와 checkbox는 같은 그룹끼리 반드시 같은 이름의 name 속성을 지정해서 그룹으로 묶어야 한다.
	checked="checked" 속성을 지정하면 브라우저에 표시될 때 기본값으로 선택 여부를 지정할 수 있다.
	radio와 checkbox는 컨트롤을 화면에 표시하는 기능밖에 없기 때문에, 선택했을 때 다음 페이지로 넘겨줄 데이를 value 속성을 사용해서 넣어주어야 한다.
	value 속성을 지정하지 않으면 선택한 경우 "on"이, 선택하지 않으면 null이 다음 페이지로 넘어간다.-->
	
	<fieldset style="font-style: italic; width: 150px; font-size: 20px; color: salmon; font-family: 나눔고딕">
		<legend>성별</legend>
		<input type="radio" name="gender" checked="checked" value="true"> 여자<br>
		<input type="radio" name="gender" value="false"> 남자
	</fieldset>
	
	<fieldset style="font-style: italic; width: 150px; font-size: 20px; color: deepskyblue; font-family: 나눔고딕">
		<legend>취미</legend>
		<input type="checkbox" name="hobbies" value="차"> 차 <br>
		<input type="checkbox" name="hobbies" value="게임"> 게임 <br>
		<input type="checkbox" name="hobbies" value="독서"> 독서	
	</fieldset> <br>

<!--콤보상자나 목록상자는 별도의 스타일을 지정하지 않으면 option 태그에 입력한 문자열 중 가장 긴 문자열 길이에 맞춰서 콤보상자나 목록상자의 크기가 결정된다.
	콤보상자나 목록상자에 selected="selected" 속성을 지정하면 기본값으로 선택되게 할 수 있다.-->
<!-- 콤보상자 만들기 -->
	
	<select name="trip" style="width: 200px; color: green; height: 30px; font-family: 나눔고딕;" >
		<option>집</option>
		<option>대만</option>
		<option selected="selected">후쿠오카</option>
		<option>홍콩</option>
		<option>베이징</option>
		<option>도쿄</option>
	</select> <br>


<!-- 목록상자 만들기 -->
<!-- select 태그에 multiple="multiple" 속성을 지정하면 목록상자가 만들어진다. -->
<!-- 목록상자에 표시되는 아이템의 개수는 4개가 기본이고 size 속성을 지정하면 지정한 만큼 표시된다. -->

	<select name="travel" style="width: 200px; color: violet; font-family: 나눔고딕;" multiple="multiple" size="8">
		<option>집</option>
		<option selected="selected">대만</option>
		<option>후쿠오카</option>
		<option>홍콩</option>
		<option>베이징</option>
		<option>도쿄</option>
	</select> <br><br>
	
	<!-- textarea는 value 속성이 없다. <textarea> ~ </textarea> 사이를 value로 취급한다. -->
	메모<br>
	<textarea rows="10" cols="60" name="content" style="resize: none;"></textarea> <br><br>
	
	<input type="submit" value="정보보기"> 
	<input type="reset" value="다시쓰기">
	<input type="button" value="버튼"><br>
	<button type="submit">정보보기?</button>
	<button type="reset">다시쓰기?</button>
	<button type="button">버튼?</button>
	
</form>

</body>
</html>