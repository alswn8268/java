package java_220824;

import java.util.Arrays;
import java.util.Scanner;

public class RegistrationNumber4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요: ");
		String n = scanner.nextLine();

		String w = "234567892345";
		int sum = 0;

		for (int i = 0; i < 12; i++) {
			sum += ((int) n.charAt(i) - 48) * ((int) w.charAt(i) - 48);
		}

		int result = (11 - sum % 11) % 10;
		
		if (result == n.charAt(12) - 48) {
			System.out.println("정상");
		} else {
			System.out.println("오류");			
		}

	}

}
