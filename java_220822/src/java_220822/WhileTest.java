package java_220822;

public class WhileTest {

	public static void main(String[] args) {
		
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1 ~ 10의 합계: " + sum);
	
//		반복으로 최초 진입시 조건이 거짓이면 {} 블록을 한 번도 실행하지 않는다.
//		while (조건식) {
//			조건식의 결과가 참인 동안 반복할 문장;
//			...;
//		}
		
		sum = 0;
		int i = 1;
		while (i <= 10) {
			sum += i++;
		}
		System.out.println("1 ~ 10의 합계: " + sum);
		
//		반복으로 최초 진입시 조건이 거짓이더라도 {} 블록을 한 번은 실행한다.
//		do {
//			조건식의 결과가 참인 동안 반복할 문장;
//			...;
//		} while (조건식);		// ;을 빼먹으면 안 된다.
	
		sum = 0; i = 1; 		// sum = i = 0; (0을 i에 저장하고 i에 저장된 값을 sum에 저장한다. 변수 선언 시에는 사용할 수 없다.)
		do {
			sum += i++;
		} while (i <= 10);
		System.out.println("1 ~ 10의 합계: " + sum);
		
	}
	
}
