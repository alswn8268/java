package java_220824;

import java.util.Scanner;

public class WorkNumber2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("사업자등록번호를 입력하세요: ");
		String n = scanner.nextLine().trim();

		String check = "137137135";
		int sum = 0;
//		사업자등록번호의 9번째 자리까지 각 자리의 숫자와 가중치를 곱한 결과의 일의 자리의 합계를 계산한다.
		for (int i = 0; i < 9; i++) {
			sum += (Integer.parseInt(n.charAt(i) + "") * Integer.parseInt(check.charAt(i) + "")) % 10;
		}
//		사업자등록번호의 9번째 자리와 가중치를 곱한 결과의 십의 자리를 더한다.
		sum += (Integer.parseInt(n.charAt(8) + "") * Integer.parseInt(check.charAt(8) + "")) /  10;
//		System.out.println(sum);
//		사업자등록번호와 가중치의 9번째 자리까지 연산 결과에 사업자등록번호의 십의 자리를 더한다.
		sum += n.charAt(9) - 48;
		System.out.println(sum % 10 == 0 ? "정상" : "오류");
		
	}

}
