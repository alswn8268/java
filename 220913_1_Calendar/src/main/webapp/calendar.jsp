<%@page import="java.util.Date"%>
<%@page import="com.tjoeun.myCalendar.MyCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년 달력</title>
<style type="text/css">
/* 	id->#(특정한 한 가지에만 적용하고 싶을 때), class->.(같은 속성을 가진 여러 개에 적용하고 싶을 때) */

	tr {
		height: 70px;
	}
	th {
		width: 100px;
		font-size: 20px;
	}			
	th#title {
		font-size: 26px;	/* 글꼴 크기 */
		font-weight: 700;
		height: 30px;
		color: white;	/* 글자 색 */
		background-color: lavender;	/* 글자 색 */
/*		font-family: D2coding; 글꼴 이름 */
/*		font-weight: 100; 글꼴 굵기 */	
	}
	th#sunday {
		color: orangered;
	}
	th#saturday {
		color: royalblue;
	}
	td {
		text-align: right;	/* 수평 정렬 */
		vertical-align: top;	/* 수직 정렬 */
	}
	td.sun {
		color: orangered;
	}
	td.sat {
		color: royalblue;
	}
	tr#weekday {
		height: 40px;
	}
	td.lastmonth {
		color: gray;
		font-size: 12px;
		background-color: lightyellow;
	}
	td#lastsun {
		color: orangered;
		font-size: 12px;
		background-color: lightyellow;
	}
	td.nextmonth {
		color: gray;
		font-size: 12px;
		background-color: lightyellow;
	}
	td#nextsat {
		color: royalblue;
		font-size: 12px;
		background-color: lightyellow;
	}

</style>
</head>
<body style="font-family: 나눔고딕;">

	<%
	// 달력 메소드 테스트
/* 		out.println(MyCalendar.isLeapYear(2022));
		out.println(MyCalendar.lastDay(2022, 9));
		out.println(MyCalendar.totalDay(2022, 9, 13));
		out.println(MyCalendar.weekDay(2022, 9, 13)); */
		
		// 컴퓨터 시스템의 연, 월을 얻어온다.
		Date date = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
	%>

<table width="700" border="2" align="center" cellpadding="5" cellspacing="0" style="border-color: aliceblue;">
	
	<tr>
		<th id="title" colspan="7">
			<%=year%>년 <%=month%>월
		</th>	
	</tr>
	<tr id="weekday">
		<th id="sunday">일</th>
		<th>월</th>
		<th>화</th>
		<th>수</th>
		<th>목</th>
		<th>금</th>
		<th id="saturday">토</th>		
	</tr>
		<!-- 달력에 날짜를 출력한다. -->
	<tr>
	
<%
//	1일이 출력될 위치(요일)을 맞추기 위해, 달력을 출력할 달 1일의 요일만큼 반복해서 빈칸을 출력한다.
/* 	for (int i = 0; i < MyCalendar.weekDay(year, month, 1); i++) {
		out.println("<td></td>");
	} */

//	1일이 출력될 위치(요일)을 맞추기 위해 전달 날짜를 출력한다.
 	int week = MyCalendar.weekDay(year, month, 1);
		int start = 0;
	for (int i = 0; i < MyCalendar.weekDay(year, month, 1); i++) {
		if (i == 0) {
			out.println("<td id='lastsun'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
		} else {
			out.println("<td class='lastmonth'>" + (month == 1 ? 12 : month - 1 ) + "/" + ++start + "</td>"); 
		}
	}
/*	int m = month - 1;
		if (month == 1) {
			start = 31 - week;
			m = 12;
		} else {
			start = MyCalendar.lastDay(year, month - 1) - week;
		}
		for (int i = 1; i <= week; i++) {
			out.println("<td class='lastmonth'>" + m + "/" + ++start + "</td>");
		} */


// 1일부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력한다.
	for (int i = 1; i <= MyCalendar.lastDay(year, month); i++) {
		//	<td> 태그에 요일에 따른 class 속성을 지정한다.
/*		if (MyCalendar.weekDay(year, month, i) == 0) {	// 일요일
			out.println("<td class='sun'>" + i + "</td>");
		} else if (MyCalendar.weekDay(year, month, i) == 6) {	// 토요일
			out.println("<td class='sat'>" + i + "</td>");			
		} else  {
			out.println("<td>" + i + "</td>");					
		}	*/
		switch (MyCalendar.weekDay(year, month, i)) {
			case 0: // 일요일
				out.println("<td class='sun'>" + i + "</td>");
			break;
			case 6: // 토요일
				out.println("<td class='sat'>" + i + "</td>");
			break;
			default:
				out.println("<td>" + i + "</td>");
				
		}

		// 출력한 날짜가 토요일이고 그 날의 마지막 날짜가 아니면 줄을 바꾼다.
		if (MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)) {
			out.println("</tr><tr>");					
		}
		
	}

		// 다음달 1일의 요일을 계산한다.
		if (month == 12) {
			week = MyCalendar.weekDay(year + 1, 1, 1);
		} else {
			week = MyCalendar.weekDay(year, month + 1 , 1);
		}
		
		// 다음 달 1일이 일요일이면 다음 달 날짜를 출력할 필요 없다.
		if (week != 0) {
			// 날짜를 다 출력하고 남은 빈칸에 다음 달 날짜를 다음 달 1일의 요일부터 토요일까지 반복하며 출력한다.
			start = 0;
			for (int i = week; i <= 6; i++) {
				if (i == 6) {
					out.println("<td id='nextsat'>" + (month == 12 ? 1 : month + 1) + "/" + ++start + "</td>");
				} else {
					out.println("<td class='nextmonth'>" + (month == 12 ? 1 : month + 1) + "/" + ++start + "</td>");				
				}
			}			
		}
		
		
/* 		int lastweekday = MyCalendar.weekDay(year, month, MyCalendar.lastDay(year, month));
		if (month == 12) {
			for (int i = 1; i <= 7 - lastweekday - 1; i++) {
				out.println("<td>" + "1/" + i +"</td>");				
			}
		} else {
			for (int i = 1; i <= 7 - lastweekday - 1; i++) {
				out.println( "<td>" + month + "/" + i +"</td>");				
			}			
		} */
%>
		
	</tr>

	
</table>

</body>
</html>