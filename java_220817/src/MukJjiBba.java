import java.util.Random;
import java.util.Scanner;

public class MukJjiBba {
	
	public static void main(String[] args) {
		
//		가위(1), 바위(2), 보(3)
		Random random = new Random();
		int cpu = random.nextInt(3) + 1;
//		System.out.println("cpu: " + cpu);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위(1), 바위(2), 보(3)");
		int user = scanner.nextInt();
	
//		이기는 경우 cpu가 1이고 user가 2 또는 cpu가 2고 user가 3 또는 cpu가 3이고 user가 1
//		지는 경우 cpu가 1이고 user가 3 또는 cpu가 2고 user가 1 또는 cpu가 3이고 user가 2
//		이기는 경우와 지는 경우를 제외한 나머지 경우가 비기는 경우가 된다. cpu와 user가 같을 경우

//		if ((cpu == 1 && user == 2) || (cpu == 2 && user == 3) ||(cpu == 3 && user == 1)) {
//			System.out.println("이겼습니다.");
//		} else if ((cpu == 1 && user == 3) || (cpu == 2 && user == 1) ||(cpu == 3 && user == 2)) {
//			System.out.println("졌습니다.");
//		} else {
//			System.out.println("비겼습니다.");
//		}
		
		if (cpu == user) {
			System.out.println("비겼습니다.");
		} else if ((cpu == 1 && user == 3) || (cpu == 2 && user == 1) ||(cpu == 3 && user == 2)) {
			System.out.println("졌습니다.");
		} else {
			System.out.println("이겼습니다.");
		}
			
	}
	
}
