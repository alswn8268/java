package java_220818;

import java.util.Random;

public class DiceTest {

	public static void main(String[] args) {

//		주사위를 10번 굴려서 발생된 눈의 개수를 센다.
		Random random = new Random();
//		주사위의 눈의 개수를 기억할 변수를 선언한다.
		int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;

		for (int i = 0; i < 10; i++) {
//			주사위의 눈을 무작위로 발생시킨다.
//			System.out.println(random.nextInt(6)+1);
			int dice = random.nextInt(6) + 1;
			System.out.println(dice);

//			무작위로 발생된 주사위 눈의 개수를 센다.
			/*
			if (dice == 1) {
				num1++;
			} else if (dice == 2) {
				num2++;
			} else if (dice == 3) {
				num3++;
			} else if (dice == 4) {
				num4++;
			} else if (dice == 5) {
				num5++;
			} else {
				num6++;
			}
			*/

			switch (dice) {
			case 1:
				num1++; break;
			case 2:
				num2++; break;
			case 3:
				num3++; break;
			case 4:
				num4++; break;
			case 5:
				num5++; break;
			case 6:
				num6++; break;

			}

		}

		
//		주사위 눈의 개수를 출력한다.
			System.out.println(1 + "의 개수 : " + num1);
			System.out.println(2 + "의 개수 : " + num2);
			System.out.println(3 + "의 개수 : " + num3);
			System.out.println(4 + "의 개수 : " + num4);
			System.out.println(5 + "의 개수 : " + num5);
			System.out.println(6 + "의 개수 : " + num6);
		}
	}
