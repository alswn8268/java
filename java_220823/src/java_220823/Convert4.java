package java_220823;

import java.util.Scanner;

public class Convert4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("n진수로 변환할 10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		System.out.println("변환할 진법을 입력하세요: ");
		int n = scanner.nextInt();
		
		int hex[] = new int[n]; 
		int index = 0; 
		int number = dec;
//		char[] ch = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		
		while (true) {
			int m = dec / n;
			int r = dec % n;
			hex[index++] = r;
			if (m == 0) {
				break;
			}
			dec = m;
		}	

		System.out.print("10진수 " + number + "을(를) " + n + "진수로 변환하면 ");
		for (int j = index - 1; j >= 0; j--) {
//			System.out.print(ch[hex[j]]);
			if (hex[j] < 10) {
//				hex 배열 요소에 저장된 값이 10 미만이면 저장된 값을 그대로 출력한다.
				System.out.print(hex[j]);
			} else {
//				hex 배열 요소에 저장된 값이 10 이상이면 영문자로 변환해서 출력한다.
				System.out.print((char)(hex[j] + 55));
//				System.out.printf("%c", hex[j] + 55);
			}
		}
		System.out.print(" 입니다.");

	}

}
