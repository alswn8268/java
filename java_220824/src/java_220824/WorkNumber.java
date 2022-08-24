package java_220824;

import java.util.Scanner;

public class WorkNumber {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("사업자등록번호를 입력하세요: ");
		String n = scanner.nextLine();

		int w[] = { 1, 3, 7, 1, 3, 7, 1, 3, 5 };
		char x[] = new char[10];

		for (int i = 0; i < 10; i++) {
			x[i] = n.charAt(i);
		}

		int sum = 0;
		for (int i = 0; i < 8; i++) {
			sum += (w[i] * ((int) x[i] - 48)) % 10;
		}
		int r = ((int) x[8] - 48) * w[8];
		sum += r / 10 + r % 10;

		System.out.println((sum + (x[9] - 48)) % 10 == 0 ? "정상" : "오류");

	}

}
