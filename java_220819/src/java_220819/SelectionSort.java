package java_220819;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int data[] = {8, 3, 4, 9, 1};
		
		for (int i=0; i<4; i++) {		// 선택 위치, 회전수 제어
			for (int j=i+1; j<5; j++) {		// 선택 위치의 데이터와 비교할 대상이 되는 데이터 위치
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}	// 회전 종료
			System.out.println(i + 1 + "회전 결과: " + Arrays.toString(data));
		}	// 정렬 종료

	}
	
}
