<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jatl을 사용하겠다고 알려준다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 서식 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- 함수 -->

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

</style>
</head>
<body>

	<!-- jstl을 사용하는 post 방식의 한글 깨짐 방지 -->
	<!-- request.setCharacterEncoding("UTF-8"); -->
	<fmt:requestEncoding value="UTF-8"/>
	
	<%--
		EL을 사용하면 request 영역에 저장된 데이터를 받는 처리없이 사용할 수 있다.
		GuestBookList guestBookList = (GuestBookList) request.getAttribute("guestbookList");
		out.println(guestBookList);
		위의 두 줄을 ${guestbookList}와 같이 사용할 수 있다.
		
		EL을 사용하면 객체 내부의 데이터를 ${객체이름.필드이름}의 형태로 얻어올 수 있다. => getter가 자동으로 실행된다.
		out.println(guestbookList.getList());
		위의 문장을 ${guestbookList.getList()}와 같이 사용할 수 있다.
	 
		c:set => jstl 대입문
		<c:set var="변수이름" value="변수에 저장할 데이터"></c:set>	 
		ArrayList<GuestbookVO> view = guestbookList.getList();
		위의 문장을 <c:set var="view" value="${guestbookList.list}"></c:set>와 같이 사용할 수 있다.	 
	 
		c:if => jstl if문 => else를 사용할 수 없다. => else 처리가 필요하면 조건을 반대로 해서 별도의 if를 만들어 사용한다.
		<c:if test="${조건식}">
			조건식이 참일 경우 실행할 문장
		</c:if>	 
		
		c:forEach => jstl for문
		일반 for: 초기값부터 최종값까지 증가값만큼 증가하며 반복한다. => 증가값을 생략하면 기본값 1이 사용된다.
			=> 증가치는 반드시 양수만 사용해야 한다.
		<c:forEach var="변수이름" begin="초기값" end="최종값" [step="증가치"]>
			반복할 문장
		</c:forEach>
		
		향상된 for: 객체저장된 내용이 변수에 처음부터 마지막까지 차례대로 대입되며 반복한다.
		<c:forEach var="변수이름" items=#{배열이나 List 형태의 객체}>
			반복할 문장
		</c:forEach>
		
		jstl 함수 사용하기
		${fn:함수이름(인수)}
		
		jstl 날짜 서식 => 날짜 서식을 지정하는 방법은 자바와 같다.
		<fmt:formatDate value=${날짜 데이터} pattern="날짜 서식"></fmt:formatDate>
		 --%>
	 
		<c:set var="view" value="${guestbookList.list}"></c:set>
		<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
			<tr>
				<th>방명록 보기</th>
			</tr>
	 		<tr>
				<td align="right">
					${guestbookList.totalCount}개 (${guestbookList.currentPage}/${guestbookList.totalPage})
				</td>
			</tr>
			<tr>
				<td>
					<!-- 테이블에 저장된 글이 없으면 없다고 출력한다. -->
					<c:if test="${view.size() == 0}">
						<h2> 테이블에 저장된 글이 없습니다.</h2>
					</c:if>
					
					<!-- 테이블에 저장된 글이 있으면 글 목록을 출력한다. -->
					<c:if test="${view.size() != 0}">
						<!-- useBean으로 컴퓨터 시스템의 날짜와 시간을 얻어온다. -->
						<%-- <jsp:useBean id="date" class="java.util.Date"/>
						${date}<br/> --%>
						
						<c:forEach var="vo" items="${view}">
							<table class="table" width="98%" align="center" border="1" cellpadding="5" cellspacing="1">
								<tr>
									<td>
										${vo.idx}. 
										
										<!-- 이름에 태그가 적용되지 않도록 replace 함수를 적용한다. -->
										<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"/>
										<c:set var="name" value="${fn:replace(vo.name, '>', '&gt;')}"/>
										${vo.name}
										
										(${vo.ip})님이 
										
										<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
										${vo.writeDate}에 남긴 글:<br/>
										<c:set var="memo" value="${fn:replace(vo.memo, '<', '&lt;')}"/>
										<c:set var="memo" value="${fn:replace(vo.memo, '>', '&gt;')}"/>
										<c:set var="memo" value="${fn:replace(vo.memo, enter, '<br/>')}"/>
										${vo.memo}
									</td>
								</tr>
							</table>				
						</c:forEach>
					</c:if>			
						
				</td>
			</tr>	 		
	 </table>
</body>
</html>






















