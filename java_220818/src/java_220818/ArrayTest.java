package java_220818;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		
//		배열: 같은 이름으로 여러 개의 기억장소를 만든다. 기억장소 구분은 인덱스(첨자)를 이용한다.
		
//		배열을 선언만 한다.
//		자료형[] 배열이름 = new 자료형[첨자]; // 첨자로 지정한 크기만큼 배열을 만든다.
//		자료형 배열이름[] = new 자료형[첨자]; //
	
//		배열을 선언만 하면 기본 초기화가 실행된다.
//		숫자는 0, 문자는 공백, boolean은 false, 기본 자료형을 제외한 나머지(클래스로 만든 객체)는 null		
		
		int[] data = new int[5];
		System.out.println(Arrays.toString(data));
		
//		배열을 선언하고 초기치로 초기화한다.
//		자료형[] 배열이름 = {초기치}; // 초기치로 지정된 데이터의 개수만큼 배열을 선언하고 초기화시킨다.
//		자료형 배열이름[] = {초기치};
		
		String name[] = {"홍길동", "임꺽정", "장길산", "일지매", "손오공", "저팔계"};
		System.out.println(Arrays.toString(name));
		
//		장점: 다음 데이터로 접근이 빠르다.
//		단점: 삽입, 삭제가 발생할 때, 삽입 삭제를 하는 시간보다 데이터 이동에 시간이 더 걸린다.
//		-> 배열은 데이터에 변동이 거의 없는 경우 사용
		
		System.out.println(name[0]);
		System.out.println(name[1]);
		System.out.println(name[2]);
		System.out.println(name[3]);
		System.out.println("---------------------------");
		
		for (int i=0; i<4; i++) {
			System.out.println("name[" + i + "]=" + name[i]);
		}
	
//		배열이름.length: 배열의 크기를 얻어온다.
		System.out.println("배열의 크기: " + name.length);
		System.out.println("---------------------------");
		
		for (int i=0; i<name.length; i++) {
			System.out.println("name[" + i + "]=" + name[i]);
		}
		System.out.println("---------------------------");
		
//		향상된 for: 배열 전체를 대상으로 작업할 경우 사용하면 편리하다.
//		for (배열의자료형 변수이름 : 배열이름( {
//			반복할 문장;
//			...;
//		}
		
//		name 배열의 0번째 인덱스에 저장된 데이터가 str 변수에 저장된 후 반복을 시작하고
//		name 배열의 마지막 인덱스에 저장된 데이터를 str 변수에 저장한 후 처리하면 반복이 종료된다.
		for (String str : name) {
			System.out.println(str);
		}
//		전체 작업만 가능
		
	}
	
}

