<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주민등록번호 유효성 검사</title>
<style type="text/css">
* {
	font-family: "pretendard";
}
.button {
	background-color:  cornflowerblue; 
	border: none;
	color: white;
	padding: 4px 4px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
	border-radius: 10px;
}	

.button1 {
	background-color: white; 
	color: black; 
	border: 2px solid  cornflowerblue;
	}

.button1:hover {
	background-color: cornflowerblue;
	color: white;
}
</style>

<script type="text/javascript" src="./js/juminForm.js" defer="defer"></script>

</head>
<body>
	
	<!--
		onsubmit 이벤트는 form의 submit 버튼이 클릭되면 실행하는 이벤트이다.
		form check는 submit 버튼이 클릭되면 javascript 함수를 실행해서 form에 입력된 데이터가 정상적인 데이터인가 유효성을 검사해서 true/false를 리턴하게 만든다.
		onsubmit="return javascript함수(this)" 형태로 작성하고, return 값이 true면 action 속성으로 지정한 페이지로 넘겨주고 false면 현재 페이지에 그대로 있는다. 
	 -->
	
	<form action="juminFormOK.jsp" method="post" name="juminForm" onsubmit="return formCheck(this)">
		
		<!-- 
			onkeypress => 키보드를 누르고 있을 때 실행되는 이벤트
			onkeydown  => 키보드를 누르는 순간 실행되는 이벤트
			              누른 키보드에 해당되는 문자가 입력되기 전에 실행된다.
			onkeyup    => 키보드를 눌렀다가 손가락이 떨어지는 순간 실행되는 이벤트
                          누른 키보드에 해당되는 문자가 입력된 후 실행된다.		  
		 -->
	
		<input type="text" name="j1" maxlength="6" placeholder="주민등록번호 앞자리" onkeyup="moveNext(this, 6, document.juminForm.j2)"/>		
		<input type="password" name="j2" maxlength="7" placeholder="주민등록번호 뒷자리" onkeyup="moveNext(this, 7, document.juminForm.sendBtn)"/>
		<input class="button button1" type="submit" value="검사" name="sendBtn">	
	</form>
	
</body>
</html>










