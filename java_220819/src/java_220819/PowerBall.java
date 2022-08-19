package java_220819;

import java.util.Random;

public class PowerBall {

	public static void main(String[] args) {
		
		int[] powerball = new int[69];
		for (int i=0; i<powerball.length; i++) {
			powerball[i] = i + 1;
		}
		Random random = new Random();
		for (int i=0; i<10000; i++) {
			int r = random.nextInt(68) + 1;
			int temp = powerball[0];
			powerball[0] = powerball[r];
			powerball[r] = temp;
		}
		System.out.println("흰공: ");
		for (int i=0; i<5; i++) {
			System.out.printf("%02d ", powerball[i]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println("powerball: " + (random.nextInt(26)+1));			
	}
	
}
