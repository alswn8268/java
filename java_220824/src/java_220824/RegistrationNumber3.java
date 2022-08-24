package java_220824;

import java.util.Date;
import java.util.Scanner;

public class RegistrationNumber3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요: ");
		String n = scanner.nextLine().trim();

//		8304221185600
//		컴퓨터의 날짜 데이터를 얻어와서 연도만 꺼낸다.
		Date date = new Date();
		
//		int year = (n.charAt(0) - 48) * 10 + (n.charAt(1) - 48);	
		int year = Integer.parseInt(n.substring(0 , 2));
		if (n.charAt(6) < '3') {
			year += 1900;
		} else {
			year += 2000 ;
		}
		
//		Integer.parseInt(): 인수로 지정된 문자열을 정수로 변환한다. (문자가 끼어있거나 null은 안 됨)
//		Double.parseDouble(): 인수로 지정된 문자열을 실수로 변환한다.
//		Boolean.parseBoolean(): 인수로 지정된 문자열을 논리값(true, false)으로 변환한다.
		
		
		int month = (n.charAt(2) - 48) * 10 + (n.charAt(3) - 48);
		int day = (n.charAt(4) - 48) * 10 + (n.charAt(5) - 48);

		System.out.println(year + "년 " + month + "월 " + day + "일");
		System.out.print(date.getYear() + 1900 - year + 1 + "세 (");

		if (date.getMonth() >= month && date.getDate() >= day) {
			System.out.println("만 " + (date.getYear() + 1900 - year) + "세)");
		} else {
			System.out.println("만 " + (date.getYear() + 1900 - year - 1) + "세)");
		}

	}

}
