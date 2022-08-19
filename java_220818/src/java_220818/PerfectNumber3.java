package java_220818;

import java.util.Scanner;

public class PerfectNumber3 {

	public static void main(String[] args) {
		
//		반복문이 중첩될 경우 외부 반복과 내부 반복을 제어하는 제어 변수 이름은 반드시 다른 이름을 사용한다.
//		변수는 변수가 선언된 {} 블록 안에서만 유효하고 {} 블록을 벗어나면 메모리에서 소멸된다.
		
//		for (int i=1; i<=3; i++) {
//			int j;
//			for (j=1; j<=5; j++) {
//				System.out.println("i = " + i + ", j = " + j);
//			}
//			System.out.println(j);
//		}
		
		int lm = 0;		//완전수의 개수를 기억할 변수
		
		for (int n = 4; n <= 10000; n++) {	// 완전수인가 판단할 수
			int sum = 0;
			int k = n /2;
			
			for (int j = 1; j <= k; j++) {
//				완전수인가 판단할 수(n)의 약수를 판단하기 위해 j로 나눈 나머지를 계산한다.
				int r = n % j;
				if (r == 0) {	// j가 n의 약수인가?
//					j가 n의 약수면 n의 약수의 합계를 계산한다.
					sum += j;
				}
			}
			
//			완전수인가 판단한다.
			if (n == sum) {	// n이 완전수인가?
				lm++;		//완전수의 개수를 1 증가시킨다
				System.out.printf("%d번째 완전수 => %4d\n", lm, n
						);
			}
			
		}
		
		System.out.printf("4 ~ 10000 사이의 완전수는 %d개 입니다.\n", lm);
		
		
	} 
	
}
