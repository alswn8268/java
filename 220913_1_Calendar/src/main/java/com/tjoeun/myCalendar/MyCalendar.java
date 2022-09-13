package com.tjoeun.myCalendar;

//	달력 작업에 필요한 메소드를 모아놓은 클래스
public class MyCalendar {

//	연도를 인수로 넘겨받아 윤년, 평년을 판단해 윤년이면 true, 평년이면 false를 리턴하는 메소드
	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

//	연, 월을 인수로 넘겨받아 그 달의 마지막 날짜를 리턴하는 메소드
	public static int lastDay(int y, int m) {
		int[] day = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		day[1] = isLeapYear(y) ? 29 : 28;
		return day[m - 1];
	}

//	연, 월, 일을 인수로 넘겨받아 1년 1월 1일부터 지난 날짜를 계산해서 리턴하는 메소드
	public static int totalDay(int y, int m, int d) {
		int sum = (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;

		for (int i = 1; i < m; i++) {
			sum += lastDay(y, i);
		}
		sum += d;

		return sum;
	}

//	연, 월, 일을 인수로 넘겨받아 요일을 숫자로 계산해 리턴하는 메소드
//	일요일(0), 월요일(1), ... , 금요일(5), 토요일(6)
	public static int weekDay(int y, int m, int d) {
		return totalDay(y, m, d) % 7;
	}
	
}
