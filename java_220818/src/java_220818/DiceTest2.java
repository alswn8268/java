package java_220818;

import java.util.Random;

public class DiceTest2 {

	public static void main(String[] args) {
		Random random = new Random();
//		주사위 눈의 개수를 기억할 배열을 선언만 한다. => 모두 0으로 자동 초기화된다.
//		num[n] => n+1의 개수
		int[] num = new int[6];

		for (int i = 0; i < 10; i++) {
			int dice = random.nextInt(6) + 1;
			System.out.println(dice);

//			switch (dice) {
//			case 1:
//				num[0]++; break;
//			case 2:
//				num[1]++; break;
//			case 3:
//				num[2]++; break;
//			case 4:
//				num[3]++; break;
//			case 5:
//				num[4]++; break;
//			case 6:
//				num[5]++; break;
//			}
			num[dice - 1]++;
			
		}

		for (int i=0; i<num.length; i++) {
			System.out.println((i+1) + "의 개수 : " + num[i]);
		}
	}

}
