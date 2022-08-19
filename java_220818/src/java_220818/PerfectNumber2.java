package java_220818;

import java.util.Scanner;

public class PerfectNumber2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("몇 이하의 완전수를 찾을까요?");
		int k = scanner.nextInt(); //k 이하의 완전수를 찾는다.
		
		for (int number = 4; number <= k; number++) {   //4부터 입력한 숫자(k)까지의 약수를 찾는다.

			int sum = 0; 

			for (int i = 1; i < number / 2 + 1; i++) {
				if (number % i == 0) {
					sum += i;
				}
			} 		//입력한 숫자(k)의 약수를 찾고, 자신 외의 모든 약수를 더한다.
			
			if (number == sum) {
				System.out.println(number + "은(는) 완전수입니다.");
			}

		}   		
		
	}
	
}
