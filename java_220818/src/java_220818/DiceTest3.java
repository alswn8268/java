package java_220818;

import java.util.Random;

public class DiceTest3 {

	public static void main(String[] args) {
		Random random = new Random();
		int[] num = new int[6];

		for (int i = 0; i < 10; i++) {
//			int dice = random.nextInt(6) + 1;
			num[random.nextInt(6)]++;
		}

		for (int i=0; i<num.length; i++) {
			System.out.println((i+1) + "의 개수 : " + num[i]);
		}
	}

}
