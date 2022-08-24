package java_220824;

public class StringBuilderTest {

	public static void main(String[] args) {

		String java = new String("java");
		String jsp = new String("java");

		System.out.println(java);
		System.out.println(System.identityHashCode(java));
		System.out.println(jsp);
		System.out.println(System.identityHashCode(jsp));

//		String을 연결하면 기존의 String에 연결되는 것이 아니고 새로운 문자열이 생성된다.
		java = java + jsp;
		System.out.println(java);
		System.out.println(System.identityHashCode(java));

//		concat("문자열"): 문자열에 인수로 지정한 문자열을 이어 붙인다.
		java = java.concat(jsp);
		System.out.println(java);
		System.out.println(System.identityHashCode(java));
		System.out.println("====================");

		String html = new String("html");
		String css = new String("css");

//		stringBuilder 클래스는 내부적으로 가변적인 char[] 배열을 멤버 변수로 가진다.
//		문자열을 연결할 때 String 클래스처럼 문자열을 새로 만들지 않고 char[] 배열을 변경한다.
		StringBuilder builder = new StringBuilder(html);
		System.out.println(builder);
		System.out.println(System.identityHashCode(builder));

//		append() 메소드로 StringBuilder 클래스 객체에 문자열을 연결한다.
		builder.append(css);
		System.out.println(builder);
		System.out.println(System.identityHashCode(builder));
		System.out.println("====================");

		String str = "";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			str += "꽝";
		}
		System.out.println("실행 시간: " + (System.currentTimeMillis() - start) / 1000. + "초");
		System.out.println("String을 이용해서 꽝 10만번");

		StringBuilder str2 = new StringBuilder("");
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			str2.append("꽝");
		}
		System.out.println("실행 시간: " + (System.currentTimeMillis() - start) / 1000. + "초");
		System.out.println("StringBuilder을 이용해서 꽝 10만번");

//		StringBuffer 멀티 스레드 프로그램에서 동기화(순서를 정한다.)를 보장하므로 멀티 스레드 프로그램은 StringBuffer를 사용하고
//		싱글(단일) 스레드 프로그램은 StringBuilder를 사용하는 것을 권장한다.

		StringBuffer str3 = new StringBuffer("");
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			str3.append("꽝");
		}
		System.out.println("실행 시간: " + (System.currentTimeMillis() - start) / 1000. + "초");
		System.out.println("StringBuffer을 이용해서 꽝 10만번");

		String str4 = "개울가에 올챙이 한마리 꼬물꼬물 헤엄치다";
		System.out.println(str4);
		
//		text block => JDK 13에서 추가됨
//		문자열을 """와 """ 사이에 입력해서 \n을 사용하지 않고도 줄바꿈되는 여러 줄 문자열을 만들 수 있다.
		String strBlock = """
				개울가에
				올챙이 한마리
				꼬물꼬물 헤엄치다
				""";
		System.out.println(strBlock);
		

	}

}
