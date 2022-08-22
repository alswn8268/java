package java_220822;

import java.util.Scanner;

public class EuclideanAlgorithm {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 두 개를 입력하세요.");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int max = 0; int min = 0;
		
		if (a > b) {
			max = a; min = b;
		} else if (b > a) {
			min = a; max = b;
		}
		
		while (true) {			
			
			// 큰 수를 작은 수로 나눈 나머지를 계산한다.
			int r = max % min;
			// 큰 수를 작은 수로 나눠 떨어지면 무한루프를 탈출한다.
			if (r == 0) {
				break;
			}
			// 큰 수를 작은 수로 나눠 떨어지지 않았으면 큰 수를 기억하던 기억장소에는 작은 수를,
			// 작은 수를 기억하던 기억장소에는 나머지를 넣어준다.
			max = min;
			min = r;			
		}
				
//		최대공약수와 최소공배수를 출력한다.
		System.out.println("최대공약수: " + min);
		System.out.println("최소공배수: " + a * b / min);
				
	}
}
