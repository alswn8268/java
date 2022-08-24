package java_220824;

import java.util.Arrays;
import java.util.Scanner;

public class RegistrationNumber {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요: ");
		String n = scanner.nextLine();

		int w[] = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		char x[] = new char[13];

		for (int i = 0; i < 13; i++) {
			x[i] = n.charAt(i);
		}

		int sum = 0;
		for (int i = 0; i < 12; i++) {
			sum += w[i] * ((int) x[i] - 48);
		}

		int r = sum % 11;
		int s = 11 - r;
		int t = s >= 10 ? s % 10 : s;

		System.out.println("마지막 자리는 " + t + "입니다.");
		System.out.println("마지막 자리가 결과와 일치" + ((t == (int) n.charAt(12) - 48) ? "합니다." : "하지 않습니다."));

		/*
		 * if (t == (int) n.charAt(12) - 48) { System.out.println("마지막 자리가 결과와 일치합니다.");
		 * } else { System.out.println("마지막 자리가 결과와 일치하지 않습니다."); }
		 */

	}

}
