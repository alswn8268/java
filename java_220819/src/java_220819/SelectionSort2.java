package java_220819;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort2 {

	public static void main(String[] args) {
		
//		선택정렬(Selection Sort)
//		i번째 데이터를 선택해서 j번째 데이터와 비교한 후 앞의 데이터가 크면 두 기억장소에 저장된 값을 교환한다. -오름차순 정렬
		
/*
		i		j
		0		1	2	3	4
		1			2	3	4
		2				3	4
		3					4
*/		
		
		Random random = new Random();
		int n = random.nextInt(5)+2;
		int number[] = new int[n];
		
		for (int j = 0; j < number.length; j++) {
			int r = random.nextInt(50) + 1;
			number[j] = r;
		}
		System.out.println(Arrays.toString(number));
		System.out.println("========바꾸기 전 데이터========");
		
		
		for (int i = 0; i < number.length -1 ; i++) {		// 선택 위치, 회전수 제어
			System.out.println(i+1 + "회전");
			for (int j = i+1; j < number.length; j++) {		// 선택 위치의 데이터와 비교할 대상이 되는 데이터 위치
				if (number[i] > number[j]) {
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
				System.out.println(Arrays.toString(number));
			}
			
			
		}
		System.out.println("========바꾼 후 데이터========");
	}
	
}
