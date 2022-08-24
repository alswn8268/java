package java_220824;

import java.util.Arrays;
import java.util.Scanner;

public class RegistrationNumber5 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요: ");
		String n = scanner.nextLine().trim();

		int sum = 0;
		for (int i = 0; i < 12; i++) {
//			sum += Integer.parseInt(n.charAt(i) + "") * (i < 8 ? i + 2 : i - 6);
			sum += Integer.parseInt(n.charAt(i) + "") * (i % 8 + 2);
		}
		
		int result = (11 - sum % 11) % 10;
		System.out.println(result == n.charAt(12) - 48 ? "정상" : "오류");
		
	}

}
