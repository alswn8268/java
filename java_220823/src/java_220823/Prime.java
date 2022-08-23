package java_220823;

import java.util.Arrays;
import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("소인수분해할 숫자를 입력하세요.");
			int n = scanner.nextInt();
			if (n < 2) {
				break;
			}

//			소인수 분해
			int[] s = new int [20];
			int number = n;
			int c = 0; // s 배열의 인덱스, 소인수의 개수

			while (true) {
				int k = 2;

				while (true) {
					if (n % k == 0) { // 소인수분해가 되었는가?
						break;
					}
//					소인수 분해가 되지 않았다면 k를 1 증가시킨 후 다시 소인수 분해를 실행한다.
					k++;
				}

//				소인수 분해가 되었으면 s 배열에 소인수를 넣어준다.
				s[c++] = k;
//				다음 소인수를 얻기 위해 n에 n을 k로 나눈 수를 넣어준다.
				n = n / k;
				if (n == 1) {	// 	소인수분해가 끝났는가?
					break;
				}
			}

//			n이 소수면 소수라고 출력하고 소수가 아니면 분해된 소인수를 출력한다.
//			소인수의 개수(c)가 1개라면 자기 자신으로 나눠 떨어진 것을 의미하므로 소수이다.
			if (c == 1) {	// n이 소수인가?
				System.out.println(number + "는 소수입니다.");
			} else {
//				소인수를 출력한다.
				System.out.print(number + " = ");
				for (int y = 0; y < c - 1; y++) {
					System.out.print(s[y] + " * ");
				}
				System.out.println(s[c - 1]);
			}
		}
		System.out.println("프로그램 종료");
	}

}
