package java_220822;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {

		// 숫자를 입력받아서 2진수로 바꾸기
		Scanner scanner = new Scanner(System.in);
		System.out.println("2진수로 변환할 10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		int bin[] = new int[8]; // 결과를 기억할 배열을 선언한다. 모두 0으로 자동 초기화 된다.
		int index = 0; // 배열의 인덱스로 사용할 변수
		int number = dec;

//		입력되는 10진수의 크기에 따라 반복횟수가 달라지므로 무한루프로 처리한다.
		while (true) {
//			몫
			int m = dec / 2;
//			나머지
			int r = dec % 2;
//			배열에 나머지를 넣어준다.
			bin[index++] = r;
//			dec에 저장된 10진수를 2로 나눈 몫이 0이 되면 무한루프를 탈출한다.
			if (m == 0) {
				break;
			}
//			이전 작업의 몫인 m이 다음 작업의 dec가 된다.
			dec = m;
		}

//		System.out.print("10진수 " + number +"을(를) 2진수로 변환하면 ");
//		for (int j = bin.length-1; j >= 0; j--) {
//			System.out.print(bin[j]);
//		}
//		System.out.print(" 입니다.");		

		System.out.print("10진수 " + number + "을(를) 2진수로 변환하면 ");
		for (int j = index - 1; j >= 0; j--) {
			System.out.print(bin[j]);
		}
		System.out.print(" 입니다.");

	}

}
