package java_220826;

import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n;
		while (true) {
			System.out.print("마방진을 출력할 행렬의 차수를 3이상인 홀수로 입력하세요: ");
			n = scanner.nextInt();
			if (n >= 3 && n % 2 == 1) {
				break;
			}
			System.out.println("3이상인 홀수를 입력하세요.");
		}
		
//		n행 n열인 2차원 배열을 선언한다.
		int[][] a = new int[n][n];
		int i = 0;
		int j = n / 2;

		for (int q = 1; q <= n * n; q++) {
			a[i][j] = q;
			if (q % n == 0) {
				i++;
			} else {
				if (--i == -1) {
					i = n - 1;
				}
				if (++j == n) {
					j = 0;
				}
			}

		}
		for (i = 0; i < n; i++) {
			for (j = 0; j < a[i].length; j++) {
				System.out.printf(" %3d ", a[i][j]);
			}
			System.out.println();
		}

	}

}
