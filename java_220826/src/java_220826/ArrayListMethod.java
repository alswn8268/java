package java_220826;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListMethod {

	public static void main(String[] args) {
		
//		배열은 한 번 선언하면 프로그램에서 크기를 변경할 수 없다.
		int[] data = new int[10];
		
		for (int i = 0; i < 10; i++) {
			data[i] = i + 1;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("data[" + i + "] = " + data[i]);
		}
		
//		배열은 인덱스가 범위를 벗어나면 ArrayIndexOutOfBoundsException이 발생된다.
//		for (int i = 0; i < 20; i++) {
//			data[i] = i + 1;
//		}
		
//		ArrayList는 데이터가 삽입되면 자동으로 크기가 커지고 제거되면 자동으로 크기가 작아진다.
//		중간에 데이터가 삽입되면 삽입되는 위치부터 모든 데이터가 뒤로 이동되고 중간의 데이터가 제거되면 제거된 다음 위치부터 모든 데이터가 앞으로 이동한다.
		
//		<E> => 제네릭이라 부르며 ArrayList에 저장할 데이터의 타입을 반드시 클래스로 적어야 한다.
//		=> 기본 자료형을 사용할 수 없다.
//		기본 자료형 데이터를 저장하는 ArrayList를 만들어야 할 경우 기본 자료형을 클래스화 시켜놓은 랩퍼 클래스를 사용해야 한다.
//		=> 랩퍼 클래스는 기본 자료형의 첫 문자만 대문자로 바꾸면 된다.
//		=> 단, char는 Character로, int는 Integer를 사용한다.
		
//		ArrayList list = new ArrayList();	// JDK 1.4 버전 이전
//		ArrayList<Integer> list = new ArrayList<Integer>();	// JDK 1.5 버전 이후
		ArrayList<Integer> list = new ArrayList<>(); //JDK 1.7 버전 이후
		
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("list.get(" + i + ") = " + list.get(i));
		}
		for (int i = 10; i < 20; i++) {
			list.add(i + 1);
		}
		for (int i = 10; i < 20; i++) {
			System.out.println("list.get(" + i + ") = " + list.get(i));
		}
		
	}
	
}

