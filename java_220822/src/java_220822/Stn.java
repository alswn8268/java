package java_220822;

public class Stn {

	public static void main(String[] args) {
		
		int[] data = {4, 1, 3, 5, 2};
		
/*		
//		최대값을 기억할 기억장소는 아주 작은 값을, 최소값을 기억할 기억장소는 아주 큰 값을 초기치로 지정한다.
		int max = 0;
		int min = 100;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
			if (data[i] < min) {
				min = data[i];
			}
		}
*/
		
//		최대값과 최소값을 기억할 기억장소에 각각 데이터가 저장된 배열의 0번째 인덱스 요소를 초기치로 지정한다.
/*
		int max = data[0];
		int min = data[0];
		
//		i가 1부터 시작하는 이유는 최대값과 최소값을 기억할 변수에 배열의 0번째 인덱스의 값을 초기치로 지정했고, 자기 자신끼리 비교해봐야 최대값 최소값을 판별하는데 전혀 도움이 되지 않기 때문이다.
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			} else if (data[i] < min) {
				min = data[i];
			}		
		}		
 */
		for (int i = 0; i < data.length-1; i++) {	
			
			boolean flag = true;
			
			for (int j = 0; j < data.length-1-i; j++) {	
				if (data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
					flag = false;
				}
			}	
			if (flag) {
				break;
			}
			
		}	
		
//		최대값과 최소값을 제외한 나머지 데이터의 평균
//		데이터가 정렬이 안 된 경우: (전체 데이터의 합계 - 최대값 - 최소값) / (데이터의 개수 - 2)
//		데이터가 정렬된 경우: 0번째 인덱스와 마지막 인덱스를 제외한 데이터의 합계 / (데이터의 개수 - 2)
		
		int sum = 0;
		for (int i = 1; i < data.length-1; i++) {
			sum += data[i];
		}
		double avg = (double) sum/(data.length-2);
		System.out.println("최대값과 최소값을 제외한 데이터의 평균: " + avg);		// 산술 평균
		
//		분산 v = 시그마 (Xi - 평균)^2 / n
//		표준편차 = 루트 분산

		double w = 0;
		for (int i = 1; i < data.length - 1; i++) {
			w += Math.pow(data[i] - avg, 2);	//(data[i] - avg) * (data[i] - avg);			 
		}
		double v = w / (data.length - 2);
		System.out.println("분산: " + v);
		double stn = Math.sqrt(v);		//Math.pow(v, 0.5);
		System.out.println("표준편차: " + stn);
	}
		
}
