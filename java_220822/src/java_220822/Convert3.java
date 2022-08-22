package java_220822;

import java.util.Scanner;

public class Convert3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("16진수로 변환할 10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		int hex[] = new int[16]; 
		int index = 0; 
		int number = dec;
		char[] ch = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		
		while (true) {
			int m = dec / 16;
			int r = dec % 16;
			hex[index++] = r;
			if (m == 0) {
				break;
			}
			dec = m;
		}	

		System.out.print("10진수 " + number + "을(를) 16진수로 변환하면 ");
		for (int j = index - 1; j >= 0; j--) {
			System.out.print(ch[hex[j]]);
		}
		System.out.print(" 입니다.");

	}

}
