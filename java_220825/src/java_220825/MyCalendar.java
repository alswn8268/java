package java_220825;

//	달력 작업에 사용할 메소드를 모아놓은 클래스
public class MyCalendar {

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public static int lastDay(int y, int m) {
		int[] day = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		day[1] = isLeapYear(y) ? 29 : 28;
		return day[m - 1];
	}

	public static int totalDay(int y, int m, int d) {

		int sum = (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;

		for (int i = 1; i < m; i++) {
			sum += lastDay(y, i);
		}
		sum += d;

		return sum;

	}

	public static int weekDay(int y, int m, int d) {
		return totalDay(y, m, d) % 7;
	}
	
}
