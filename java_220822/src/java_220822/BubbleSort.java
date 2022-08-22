package java_220822;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
//		버블정렬(Bubble Sort)
//		j번째 인덱스의 데이터를 선택해서 j+1번째 인덱스의 데이터와 비교하며 앞의 값이 크면 데이터를 교환한다. -오름차순
//		i: 회전수, j: 비교 위치
		
/*		i		j
 		0		0	1	2	3
		1		0	1	2
		2		0	1
		3		0				*/

		int data[] = {8, 3, 4, 9, 1};
		
		for (int i = 0; i < data.length-1; i++) {		// 회전수 제어
			for (int j = 0; j < data.length-1-i; j++) {	// 비교 위치 설정
//				System.out.printf("i = %d, j = %d\n", i, j);
				if (data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
				System.out.println(Arrays.toString(data));
			}	// 회전 종료
			System.out.println((i+1) + "회전 완료======");
		}	// 정렬 종료
		System.out.println("===정렬 결과===\n" + Arrays.toString(data));
		
		
	}
	
}
