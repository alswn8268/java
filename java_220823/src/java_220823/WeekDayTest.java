package java_220823;

import java.util.Scanner;

public class WeekDayTest {

	public static void main(String[] args) {
		
//		요일을 계산할 연, 월, 일을 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("요일을 계산할 연, 월, 일을 입력하세요: ");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		
//		System.out.println(year + " " + month + " " + day);
		
//		서기 1년 1월 1일부터 요일을 계산하기 위해 입력한 날짜까지 지난 날짜 수를 계산한다.
//		계산된 날짜를 7로 나눈 나머지가 0이면 일요일, 1이면 월요일, ... 6이면 토요일
		
//		서기 1년 1월 1일부터 입력한 날짜의 전년도 12월 31일까지 지난 날짜를 계산한다.
		
/*		int sum = (year - 1)* 365;
		for (int i = 1; i < year; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				sum += 1;
			}
		} */
		int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		
		int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int leapMonth = 0;
		for (int i = 0; i <= month - 2; i++) {
			leapMonth += m[i]; 
		}
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			leapMonth++;
		} 

		char[] wd = {'일', '월', '화', '수', '목', '금', '토'};
		int date = (sum + leapMonth + day) % 7;
		System.out.println(year + "년 " + month + "월 " + day + "일은 " + wd[date] + "요일입니다.");
		
	}
	
}
