<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 서식 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <!-- 함수 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제할 글 확인</title>
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

</style>
</head>
<body>
	
	<!-- 삭제할 글을 화면에 보여주고 비밀번호를 입력받아 실제로 글을 삭제하는 페이지로 넘겨준다. -->
	<fmt:requestEncoding value="UTF-8"/>
	
	<form action="deleteOK.jsp" method="post">
		<table class="table" width="98%" align="center" border="1" cellpadding="5" cellspacing="1">
			<tr>
				<th colspan="2">삭제할 글 확인</th>
			</tr>
			<tr>
				<th width="100">이름</th>
				<td width="500">
					<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"/>
					<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
					${vo.name}
				</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>
					<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E) HH:mm:ss"/>
				</td>
			</tr>
			<tr>
				<th>메모</th>
				<td>
					<c:set var="memo" value="${fn:replace(vo.memo, '<', '&lt;')}"/>
					<c:set var="memo" value="${fn:replace(memo, '>', '&gt;')}"/>
					<c:set var="memo" value="${fn:replace(memo, enter, '<br/>')}"/>
					${vo.memo}
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<label>
						비밀번호 <input type="password" name="password"/>
					</label>
					<input class="button button1" type="submit" value="삭제하기"/>
					<input class="button button1" type="reset" value="다시쓰기"/>
					<input class="button button1" type="button" value="돌아가기" onclick="history.back()"/>
				</td>
			</tr>
		</table>
		
		<!-- 삭제할 글 번호와 삭제 후 돌아갈 페이지 번호를 form에 hidden으로 저장해서 삭제하는 페이지로 넘겨준다. -->
		<input type="hidden" name="idx" value="${vo.idx}"/>
		<input type="hidden" name="currentPage" value="${currentPage}"/>
		
		
	</form>
	
</body>
</html>






















