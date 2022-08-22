package java_220822;

import java.util.Arrays;

public class BubbleSort_EarlyStop {

	public static void main(String[] args) {
		
		int data[] = {9, 1, 3, 4, 8};
		
		for (int i = 0; i < data.length-1; i++) {	
			
//			적당한 이름의 변수를 만들어 true로 초기화한다.
			boolean flag = true;
			
			for (int j = 0; j < data.length-1-i; j++) {	
				if (data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
//					값 교환이 이루어지면 flag 변수에 false를 저장한다.
					flag = false;
				}
			}	
//			정렬이 완료된 상태면 더 이상 회전할 필요가 없으므로 i반복을 탈출시킨다.
			if (flag /*== true*/) {
				break;
			}
			System.out.println((i+1) + "회전 결과: "+Arrays.toString(data));
		}	
		
	}
	
}
