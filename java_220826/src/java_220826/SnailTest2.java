package java_220826;

import java.util.Scanner;

public class SnailTest2 {

	public static void main(String[] args) {

		int[][] a = new int[5][5];
		int n = 1; // 배열에 채워질 숫자를 1씩 증가시킬 변수
		int s = 1; // 행과 열이 1 또는 -1씩 증가 및 감소 처리에 사용할 변수
		int i = a.length / 2; // 행
		int j = a.length / 2; // 열
		int k = 0; // 반복문의 반복 횟수 제어에 사용하는 변수
		a[i][j] = n;
		boolean flag = false;

		while (true) {
			k++;	// 3시 방향부터 채우기
			for (int p = 1; p <= k; p++) {
				n++;
				j += s;
				if (n > 25) {
					flag = true;
					break;
				}
				a[i][j] = n;
			}

			if (flag) {
				break;
			}

			for (int p = 1; p <= k; p++) {
				n++;
				i += s;
				a[i][j] = n;
			}
			s *= -1;
		}

		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[i].length; j++) {
				System.out.printf(" %2d ", a[i][j]);
			}
			System.out.println();
		}

	}

}
