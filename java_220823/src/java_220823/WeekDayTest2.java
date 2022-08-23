package java_220823;

import java.util.Scanner;

public class WeekDayTest2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("요일을 계산할 연, 월, 일을 입력하세요: ");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		
		int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		
/*		for (int i = 1; i < month; i++) {
			switch (i) {
				case 2:
					sum += year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
					break;
				case 4:	case 6:	case 9:	case 11:
					sum += 30;
					break;
				default: 
					sum += 31;
					break;
			}
		}	*/
		
		int[] m = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		m[1] = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
		for (int i = 1; i < month; i++) {
			sum += m[i-1]; 
		}
		
//		전달까지 지난 날짜에 일을 더한다.
		sum += day;

//		요일을 출력한다.
/*		switch (sum % 7) {
		case 0: System.out.println("일요일"); break;
		case 1: System.out.println("월요일"); break;
		case 2: System.out.println("화요일"); break;
		case 3: System.out.println("수요일"); break;
		case 4: System.out.println("목요일"); break;
		case 5: System.out.println("금요일"); break;
		case 6: System.out.println("토요일"); break;		
		}	*/		
		
		char[] wd = {'일', '월', '화', '수', '목', '금', '토'};
		System.out.println(year + "년 " + month + "월 " + day + "일은 " + wd[sum % 7] + "요일입니다.");		
	}
	
}
