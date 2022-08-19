package java_220819;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lotto2 {

	public static void main(String[] args) {
		
		int lotto[] = new int[45];

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i+1;
			
		}
		
//		넣을 금액
		Scanner scanner = new Scanner(System.in);
		System.out.println("몇 원을 넣겠습니까?");
		int money = scanner.nextInt();
		
//		입력 금액만큼 반복하며 자동 번호 생성
		Random random = new Random();
		for (int j = 0; j < money/1000; j++) {
			System.out.print("자동 번호: ");
			for (int k = 0; k < 10000; k++) {
				int rand = random.nextInt(45);
				int temp = lotto[0];
				lotto[0] = lotto[rand];
				lotto[rand] = temp;
		}
			
//			정렬한다.
			int[] lottoNumber = new int[6];
			for (int j1=0; j1<6; j1++) {
				lottoNumber[j1] = lotto[j1];
			}
//			Arrays.sort(lottoNumber);
			for (int i=0; i<money/1000; i++) {		// 선택 위치, 회전수 제어
				for (int l=i+1; l<6; l++) {		// 선택 위치의 데이터와 비교할 대상이 되는 데이터 위치
					if (lottoNumber[i] > lottoNumber[l]) {
						int temp = lottoNumber[i];
						lottoNumber[i] = lottoNumber[l];
						lottoNumber[l] = temp;
					}
				}	// 회전 종료
			}

			
			
		//	번호를 출력한다.
			for (int i = 0; i < 6; i++) {
				System.out.printf("%02d ", lottoNumber[i]);
				if (i == 5 ) {
					System.out.println("");
				}
			}	
		}
			
	}
	
}
