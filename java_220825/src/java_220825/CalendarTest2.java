package java_220825;

import java.util.Date;
import java.util.Scanner;

public class CalendarTest2 {

	public static void main(String[] args) {
		
//		MyCalendar myCalendar = new MyCalendar();
//		System.out.println(myCalendar.isLeapYear(2022));
//		System.out.println(MyCalendar.isLeapYear(2022));
		
		Scanner scanner = new Scanner(System.in);
		Date date = new Date();

		System.out.println("이번 달(1) or 특정 달(2)");
		int select = scanner.nextInt();
		int year, month;

		if (select == 1) {
			System.out.println(date.getYear() + 1900 + "년 " + (date.getMonth() + 1) + "월 " + date.getDate() + "일");

		} else if (select == 2) {

			System.out.println("달력을 출력할 연, 월을 입력해주세요.");
			year = scanner.nextInt();
			month = scanner.nextInt();

			System.out.println("============================");
			System.out.printf("         %4d년%2d월\n", year, month);
			System.out.println("============================");
			System.out.println(" 일  월  화  수  목  금  토 ");

			int week = CalendarTest.weekDay(year, month, 1);
			int start = 0;
			if (month == 1) {
				start = 31 - week;				
			} else {
				start = CalendarTest.lastDay(year, month - 1) - week;
			}
			for (int i = 1; i <= week; i++) {
				System.out.printf(" %2d ", ++start);
			}
			
			for (int i = 1; i <= CalendarTest.lastDay(year, month); i++) {
				System.out.printf(" %2d ", i);
				if (CalendarTest.weekDay(year, month, i) == 6 && i != CalendarTest.lastDay(year, month)) {
					System.out.println("");
				}
				if (i == CalendarTest.lastDay(year, month)) {
					for (int j = 1; j <= 7 - CalendarTest.weekDay(year, month, CalendarTest.lastDay(year, month)) - 1; j++) {
						System.out.printf(" %2d ", j);
					}

				}
			}
			
			
			System.out.println("\n============================");
		}
		
		
	}
	
}
