package java_220819;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("피보나치 수열의 합계를 계산할 항수를 입력하세요: ");
		int n = scanner.nextInt();
		
//		입력받은 피보나치 수열의 합계를 계산할 항의 개수만큼 배열을 만든다.
		int[] fibo = new int[n];
		
//		배열의 1번째, 2번째 요소를 각각 1로 초기화 시킨다.
		fibo[0] = 1;	// n-2번째 항
		fibo[1] = 1;	// n-1번째 항
		int y = 2;
		
//		피보나치 수열의 각 항 값으로 배열을 채우고 피보나치 수열의 합계를 계산한다.
		for (int k = 3; k <= n; k++) {
			fibo[k-1] = fibo[k-3] + fibo[k-2];
			y += fibo[k-1];
		}
		System.out.println(Arrays.toString(fibo));
		
		System.out.printf("피보나치 수열의 %d번째 항 까지의 합계: %d = ",n, y);
		
		for (int j = 0; j <= n-1; j++) {
			System.out.print(fibo[j]);
			if (j != n-1) {
			System.out.print(" + ");
			} else {
				break;
			}
		}
		
		/*
		for (int i = 0; i < n - 1; i++) {
			System.out.println(fibo[i] + " + ");
		}
		System.out.println(fibo[n - 1]);
		*/
		
		/*
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				System.out.println("+");
			}
			System.out.println(fibo[i]);
			}
		*/
		
		
	}
	
}
