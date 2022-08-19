package java_220819;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		
//		추첨기를 만든다.
		int lotto[] = new int[45];
		
//		추첨기에 공을 넣는다.
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i+1;
		}
		
		show(lotto);
		System.out.println("\n===========섞기 전===========\n");
		
//		섞는다.
		Random random = new Random();
		for (int k = 0; k < 10000; k++) {
			int rand = random.nextInt(45);
			int temp = lotto[0];
			lotto[0] = lotto[rand];
			lotto[rand] = temp;
		}
		
		show(lotto);
		System.out.println("\n===========섞은 후===========\n");

		//		1등 번호를 출력한다.
		System.out.println("1등 번호: ");
		for (int i = 0; i < 6; i++) {
			System.out.printf("%02d ", lotto[i]);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("보너스: " + lotto[6]);
		
	}

	private static void show(int[] lotto) {
		for (int j = 0; j < lotto.length; j++) {
			System.out.printf("%02d ", lotto[j]);
			if ((j + 1) % 10 == 0) {
			System.out.println();
			}
		}
	}
	
}
