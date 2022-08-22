package java_220822;

import java.util.Scanner;

public class Convert2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("8진수로 변환할 10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		int oct[] = new int[8]; 
		int index = 0; 
		int number = dec;

		while (true) {
			int m = dec / 8;
			int r = dec % 8;
			oct[index++] = r;
			if (m == 0) {
				break;
			}
			dec = m;
		}	

		System.out.print("10진수 " + number + "을(를) 8진수로 변환하면 ");
		for (int j = index - 1; j >= 0; j--) {
			System.out.print(oct[j]);
		}
		System.out.print(" 입니다.");

	}

}
