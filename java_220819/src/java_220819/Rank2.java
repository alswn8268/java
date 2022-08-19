package java_220819;

public class Rank2 {
	public static void main(String[] args) {
			
			int score[] = {81, 100, 77, 100, 95};
			int rank[] = new int[score.length];
			for (int i = 0; i < rank.length; i++) {
				rank[i] = 1;
			}
			
			for (int i = 0; i < score.length-1; i++) {
				for (int j = i+1; j < score.length; j++) {
						if (score[i] > score[j]) {
							rank[j] += 1;					
					} else if (score[i] < score[j]) {
						rank[i] += 1;
					}
				}
			}
			for (int i = 0; i < score.length; i++) {
				System.out.printf("%3d점은 %d등입니다."	+ "", score[i], rank[i]);
				for (int j = 0; j < score[i]/10 ; j++) {
					System.out.print("★");
				}
				if (score[i] % 10 >=5) {
					System.out.print("☆");
				}
				System.out.println();
				
			}
			
		}
}
