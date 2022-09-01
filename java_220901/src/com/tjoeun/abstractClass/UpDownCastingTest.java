package com.tjoeun.abstractClass;

class Base {
//	package 접근 권한은 같은 package에서는 public처럼 사용되고 다른 package에서는 private처럼 사용된다.
	String name;	// 접근 권한을 생략하면 package 권한을 의미한다.
	void say() {
		System.out.println(name + "님 안녕하세요?");
	}
}

class Sub extends Base {
	int age;

	@Override
	void say() {
		System.out.println(name + "님은 " + age + "세 입니다.");
	} 
	
}

public class UpDownCastingTest {

	public static void main(String[] args) {
		
//		부모 클래스 타입으로 부모 클래스 타입의 객체를 만들어 사용하면 아무 문제없이 처리된다.
		Base base = new Base();
		base.name = "홍길동";
		base.say();
		System.out.println("-------------------------------------");
		
//		자식 클래스 타입으로 자식 클래스 타입의 객체를 만들어 사용하면 아무 문제없이 처리된다.
		Sub sub = new Sub();
		sub.name = "임꺽정";
		sub.age = 20;
		sub.say();
		System.out.println("-------------------------------------");
		
//		결론 => 부모 클래스가 자식 클래스를 제어할 수 있지만 자식 클래스가 부모 클래스를 제어할 수 없다.
//		부모 클래스 타입에 자식 클래스 타입의 객체가 생성된 주소를 대입하면 아무런 문제 없이 처리된다.
//		Base b = new Sub();	// 정상 실행
//		자식 클래스 타입에 부모 클래스 타입의 객체가 생성된 주소를 대입하면 애러가 발생한다.
//		Sub s = new Base(); // 에러 발생
		
//		부모 클래스 타입의 객체에 자식 클래스 타입의 객체가 생성된 주소를 대입한다. => upcasting
//		downcasting은 부모 클래스 타입으로 upcasting된 자식 클래스를 다시 자식 클래스 타입으로 변환하는 것을 말한다.
		Base b = sub;	
//		b는 부모 클래스 타입의 객체지만 자식 클래스 타입의 객체가 생성된 주소를 대입했으므로 say() 메소드를 실행하면 자식 클래스의 say() 메소드가 실행된다.
		b.say();
		System.out.println("-------------------------------------");

//		자식 클래스 타입에 부모 클래스 타입의 객체가 생성된 주소를 대입한다.
//		Sub s = base;	// 에러 발생
//		자식 클래스 타입에 부모 클래스 타입의 객체가 생성된 주소를 대입해서 에러가 발생할 때, casting 시켜서 대입하면 대입은 가능하다.
//		이 경우 프로그램 실행 단계에서 ClassCastException이 발생된다.
//		Sub s = (Sub) base;	// casting 시키면 문법적인 에러는 발생되지 않는다.

//		instanceof 연산자는 객체가 instanceof 뒤에 지정한 클래스 타입으로 안전하게 형변환이 가능한지 검사한다.
		if (sub instanceof Base) {
			System.out.println("가능한");
			Base base2 = (Base) sub;
			base2.say();
		} else {
			System.out.println("불가능한");
		}
	
		if (base instanceof Sub) {
			System.out.println("가능한");
			Sub sub2 = (Sub) base;
			sub2.say();
		} else {
			System.out.println("불가능한");
		}
		
		try {
			Sub sub2 = (Sub) base;
			sub2.say();
		} catch (ClassCastException e) {
			System.out.println("불가능한");
		}
		
	}
	
}
