package java_220824;

import java.util.Scanner;

public class RegistrationNumber2 {

	public static void main(String[] args) {
//		주민등록번호 13자리를 '-'없이 입력받아 성별 판단하기
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호 13자리를 '-'없이 입력하세요: ");
		String n = scanner.nextLine().trim();

//		8304221185600 => 둘리 주민등록번호
//		System.out.println(n.charAt(6)); // 1
//		System.out.println("%d\n", (int) n.charAt(6)); // 49

//		숫자와 문자는 표현 방법이 다르다.
//		문자 '1'(0110001 = 49)과 숫자 1(0000001)은 다른 데이터로 취급된다.

		/*
		 * if (((int) n.charAt(6) - 48) == 1 || ((int)n.charAt(6) - '0') == 3) {
		 * System.out.println("남자"); } else { System.out.println("여자"); }
		 * 
		 * if (n.charAt(6) == '1' || n.charAt(6) == '3') { System.out.println("남자"); }
		 * else { System.out.println("여자"); }
		 */

		if (n.charAt(6) % 2 == 1) {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}

		
	}

}
