import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
//		Math.random(): 0 이상이고 1 미만인 무작위 수를 발생시킨다.
		System.out.println((int) (Math.random() * 6 + 1));
		
//		Random 클래스
		Random random = new Random();
		System.out.println(random.nextDouble());
		System.out.println(random.nextInt(45) + 1); // 0 ~ 44 (+1) 사이의 난수를 발생시킨다.
		
	}
	
}

