package java_220823;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("소수인가 판단할 숫자를 입력하세요: ");
		int n = scanner.nextInt();
		
//		모든 수는 1로 나눠 떨어지기 때문에 2부터 떨어질 때까지 나눈다.
		int i ;
		for (i = 2; i <= n; i++) {
			if (n % i == 0) {
//				나눠서 떨어지면 소수인가 판단하기 위해서 반복을 탈출한다.
				break;
			}
		}
		
//		소수인가 판단한다.
//		if (n == i) {
//			System.out.println(n + "은(는) 소수입니다.");
//		} else {
//			System.out.println(n + "은(는) 소수입니다.");	
//		}

		boolean isPrimeNumber = n == i;
		System.out.println(n + "은(는) 소수" + (isPrimeNumber ? "입니다." : "가 아닙니다."));
	}
	
}
