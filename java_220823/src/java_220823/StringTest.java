package java_220823;

public class StringTest {

	public static void main(String[] args) {

//		자바는 기본 자료형(boolean, byte, char, short, int, long, float, double)으로 만든 변수는 일반 변수로 취급하고,
//		클래스로 만든 변수(객체)는 참조 변수(데이터를 기억하는 변수가 아니고 데이터가 저장된 메모리의 주소를 기억하는 변수)로 취급한다.

//		문자열 "AAA"가 처음 사용되므로 메모리 어딘가에 "AAA"를 만들고 시작 주소를 str1에 저장한다.
		String str1 = "AAA";
//		문자열 "AAA"가 이미 메모리에 생성되어 있는 상태이므로 이미 생선되어 있는 "AAA"의 시작 주소를 str2에 저장한다.
		String str2 = "AAA";

		if (str1 == str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

//		아래와 같이 new를 사용해서 "AAA"를 만들면 메모리에 "AAA"의 존재 여부와 관계 없이 무조건 다시 만들어서 시작 주소를 str3에 저장한다.
		String str3 = new String("AAA");
		
		if (str1 == str3) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
//		결론: 기본 자료형과 null을 제외한 클래스로 생성한 모든 객체는 "=="을 사용해서 비교하지 않는다.
//		클래스로 생성한 객체는 "=="가 아니고 equals() 메소드를 사용해서 비교해야 한다.
//		클래스로 생성한 객체는 "=="로 비교하면 객체의 저장된 내용을 비교하는 것이 아니고 객체가 메모리에 생성된 주소를 비교한다.
	
		if (str1.equals(str3)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		
	}

}
