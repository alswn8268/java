import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("3과목 점수를 입력하세요: ");
		int java = scanner.nextInt();
		int jsp = scanner.nextInt();
		int spring = scanner.nextInt();
		int total = java + jsp + spring;
		double average = (double) total / 3;
		
		System.out.println("총점: " + total + "점, 평균: " + average);
		
//		key에는 정수를 기억하는 변수 또는 연산결과가 정수인 수식을 사용한다.
//		JDK 1.7 부터는 key에 문자열도 사용할 수 있다.
//		switch (key) {
//			case value: // ";"임에 주의한다. 
//				key와 value가 일치하면 실행할 문장;
//				...;
//				[break;] // 필요에 따라 생략 가능하다.
//			...
//			[default : // 기타 등등 케이스]
//				key와 일치하는 value가 없으면 실행할 문장;
//				...;
//				break;
//		}
		
		switch ((int) average / 10) {
			case 10:
				System.out.println("참잘했어요");
//				break는 제어문(if는 제외)의 {}블록을 탈출한다.
//				break;
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			case 6:
				System.out.println("D");
				break;
//			case 5: case 4: case 3: case 2: case 1: case 0:
			default:
				System.out.println("F");
		}
		
	}
	
}
