package java_220819;

import java.util.Random;

public class PowerBall2 {

	public static void main(String[] args) {
		
		int white[] = new int[69];
		int red[] = new int[26];
		
		for (int i = 0; i < 69; i++) {
			white[i] = i+1;
		}
		for (int i = 0; i < 26; i++) {
			red[i] = i+1;
		}
		
		Random random = new Random();
		for (int k = 0; k < 10000; k++) {
			int rand = random.nextInt(69);
			int temp = white[0];
			white[0] = white[rand];
			white[rand] = temp;
		}
		
		for (int k = 0; k < 10000; k++) {
			int rand = random.nextInt(26);
			int temp = red[0];
			red[0] = red[rand];
			red[rand] = temp;
		}
		
		System.out.println("흰 공 번호: ");
		for (int i = 0; i < 5; i++) {
			System.out.printf("%02d ", white[i]);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("빨간 공 번호: " + red[0]);
		
	}
	
}
