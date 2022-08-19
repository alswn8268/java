import java.util.Scanner;

public class ScoreTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
//		System.out.println("java 점수: ");
//		int java = scanner.nextInt();
//		System.out.println("jsp 점수: ");
//		int jsp = scanner.nextInt();
//		System.out.println("spring 점수: ");
//		int spring = scanner.nextInt();
		
		System.out.println("3과목 점수를 입력하세요: ");
		int java = scanner.nextInt();
		int jsp = scanner.nextInt();
		int spring = scanner.nextInt();
		
		int total = java + jsp + spring;
		double average = (double) total / 3;
		
//		System.out.println("총점: " + total + "점, 평균: " + average);
		System.out.printf("총점: %3d점, 평균: %6.2f\n", total, average);
		
//		평균 점수가 90점 이상이면 A
		if (average >= 90) {
			System.out.println("A");
		}
//		평균 점수가 90점 미만이고 80점 이상이면 B
		if (average < 90 && average >= 80) {
			System.out.println("B");
		}
//		평균 점수가 80점 미만이고 70점 이상이면 C
		if (average < 80 && average >= 70) {
			System.out.println("C");
		}
//		평균 점수가 70점 미만이고 60점 이상이면 D
		if (average < 70 && average >= 60) {
			System.out.println("D");
		}
//		평균 점수가 60점 이상이면 F
		if (average <60 ) {
			System.out.println("F");
		}
	
//		else ~ if
		if (average >= 90) {
			System.out.println("A");
		} else if (average < 90 && average >= 80) {
			System.out.println("B");
		} else if (average < 80 && average >= 70) {
			System.out.println("C");
		} else if (average < 70 && average >= 60) {
			System.out.println("D");
		} else if (average <60 ) {
			System.out.println("F");
		}
		
		
		if (average >= 90) {
			System.out.println("A");
		} else if (average >= 80) {
			System.out.println("B");
		} else if (average >= 70) {
			System.out.println("C");
		} else if (average >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
	}
	
}          
