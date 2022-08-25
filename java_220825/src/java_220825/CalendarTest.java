package java_220825;

import java.util.Date;
import java.util.Scanner;

public class CalendarTest {

//	메소드의 형식, []로 묶는 내용은 생략이 가능하다.
//	[접근 권한 지정자] [static] 리턴타입 메소드이름 ([인수, ...]) { //메소드의 머리
//		메소드가 실행할 문장;
//		...;
//		[return 값;]
//	}	// {} 블록을 메소드의 몸통이라 한다.

//	접근 권한 지정자
//	private: 현재 클래스 외부에서 접근할 수 없다.
//	protected: 현재 클래스와 현재 클래스를 상속받은 자식 클래스에서만 접근할 수 있다.
//	package: 접근 권한 지정자 생략시, 같은 패키지에서는 public처럼 사용되고 다른 패키지에서는 private처럼 사용된다.
//	public: 현재 클래스 내부, 외부 어디에서나 자유롭게 접근할 수 있다.

//	static(정적) 메소드는 메소드를 작성한 클래스의 객체를 생성하지 않고 클래스 이름에 "."을 찍어서 실행할 수 있다.
//	=> 자주 사용하는 메소드들은 정적 메소드로 만들어 사용하면 편리하다.

//	리턴 타입은 메소드가 실행되고 난 후 결과를 되돌려줄 때 결과의 자료형을 적어준다.
//	메소드를 실행한 후 결과를 되돌려줄 필요가 없으면 return을 생략할 수 있고 return을 생략하면 리턴 타입에는 "void"라고 적어준다.

//	연도를 인수로 넘겨받아 윤년, 평년을 판단해 윤년이면 true, 평년이면 false를 리턴하는 메소드
//	논리값을 기억하는 변수나 논리값을 리턴하는 메소드의 이름은 "is"로 시작하는 것이 관행이다.
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
		/*
		 * int year = (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400; int[]
		 * month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		 * 
		 * int leapMonth = 0; for (int i = 0; i <= m - 2; i++) { leapMonth += month[i];
		 * } if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) { leapMonth++; }
		 * 
		 * int date = (year + leapMonth + d) % 7; return date;
		 */

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

//	static은 자바 프로그램이 실행하기 전에 static으로 선언된 함수(메소드)나 변수를 첫 단계로 메모리에 올린다.

//	main 메소드가 실행되기 위해서는 메모리에 적재되어야 한다.
//	main 메소드가 메모리에 적재되어있지 않으면 프로그램의 시작점인 main() 메소드를 호출할 때 메모리에 main 메소드가 없으므로 실행을 할 수 없다.
//	그래서 main() 메소드는 누군가가 호출하기 전에 자바 가상머신이 메모리에 적재시킨다.
	public static void main(String[] args) {

//		static 메소드는 static 메소드에만 접근할 수 있다.		
		/*
		 * System.out.println(isLeapYear(2022)); System.out.println(lastDay(2022, 8) +
		 * "일"); System.out.println(totalDay(2022, 8, 25));
		 * System.out.println(weekDay(2022, 8, 25));
		 */

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

			// 1일이 출력될 위치를 맞추기 위해 1일의 요일만큼 반복하며 전달 날짜를 출력한다.
			int week = weekDay(year, month, 1);
			int start = 0;
			if (month == 1) {
				start = 31 - week;				
			} else {
				start = lastDay(year, month - 1) - week;
			}
			for (int i = 1; i <= week; i++) {
				System.out.printf(" %2d ", ++start);
			}
			

			// 1일부터 날짜를 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력한다.

			for (int i = 1; i <= lastDay(year, month); i++) {
				System.out.printf(" %2d ", i);
				// 출력한 날짜(i)가 토요일이고 그 달의 마지막 날짜가 아니면 줄을 바꾼다.
				if (weekDay(year, month, i) == 6 && i != lastDay(year, month)) {
					System.out.println("");
				}
				if (i == lastDay(year, month)) {
					for (int j = 1; j <= 7 - weekDay(year, month, lastDay(year, month)) - 1; j++) {
						System.out.printf(" %2d ", j);
					}

				}
			}
			
			/*
			 if (month == 12) {
			 	week = weekDay(year + 1, 1, 1);
			 } else {
			 	week = weekDay(year, month + 1, 1);
			 }
			 if (week != 0) {
			 	start = 0;
			 	for (int i = week; i <= 6; i++) {
			 		System.out.printf(" %2d ", ++start);
			 	}
			 }
			 */
			
			/*
			 week = weekDay(year, month, lastDay(year, month)) + 1;
			 start = 0;
			 for (int i = week; i <= 6; i++) {
			 	System.out.printf(" %2d ", ++start);
			 }
			 */
			
			
			System.out.println("\n============================");
		}

	}

}
