package java_220822;

import java.util.Scanner;

public class EuclideanAlgorithm2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 두 개를 입력하세요.");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int high = 0; int low = 0;
		int r = 1;
		
		if (a > b) {
			high = a; low = b;
		} else if (b > a) {
			low = a; high = b;
		}
		
		while (r > 0) {			
			r = high % low;
			high = low;
			low = r;			
		}
				
//		최대공약수와 최소공배수를 출력한다.
		System.out.println("최대공약수: " + high);
		System.out.println("최소공배수: " + a * b / high);
				
	}
}
