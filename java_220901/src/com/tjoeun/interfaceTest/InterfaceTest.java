package com.tjoeun.interfaceTest;

class Point {
	int x, y;

	void move() {
	}
}

class Shape {

//	final을 필드 선언시 앞에 붙여주면 그 필드는 프로그램에서 값을 변경할 수 없다. => 상수 
//	상수는 다른 변수와 구분하기 위해서 일반적으로 대문자로 만들어서 사용한다.
//	final을 메소드 선언시 앞에 붙여주면 그 메소드는 Override 시켜서 사용할 수 없다.
//	final을 클래스 선언시 앞에 붙여주면 그 클래스를 상속시켜 사용할 수 없다.

	public static final double PI = 3.141592; // 정적 필드

}
	
//class Line extends Point {
//	
//}

//	자바는 다중 상속을 지원하지 않기 때문에 아래와 같이 상속하면 에러가 발생된다.
//	class Line extends Point, Shape { }	// 에러

//	interface는 class의 특별한 형태로 무조건 상수(public static final)와 추상 메소드(public abstract)로만 구성된다.
interface Draw {
	double PI = 3.141592; 
//	인터페이스는 필드 선언시 앞의 내용을 생략하면 public static final을 자동으로 붙여준다.
	int LIMIT = 12412412;
	
//	인터페이스는 무조건 추상 메소드만 가질 수 있기 때문에 일반 메소드를 선언하면 에러가 발생한다.
//	public void rotate() {}	// 에러
	public abstract void movemove();	// 추상 메소드
//	인터페이스는 메소드 선언시 앞의 내용을 생략하면 public abstract를 자동으로 붙여준다.
	void erase();
}

interface Graphic {
	void rotate();
	void resize();
}

//	클래스는 인터페이스를 상속받을 수 없기 때문에 에러가 발생한다.
//	class Line extends Graphic { }

//	인터페이스는 클래스를 상속받을 수 없기 때문에 에러가 발생한다.
//	interface Graphics extends Point { } 

//	클래스는 클래스끼리, 인터페이스는 인터페이스끼리 상속을 시켜야 한다.
//	클래스는 다중 상속을 허용하지 않지만 인터페이스는 다중 상속을 허용한다.

interface Graphics extends Draw, Graphic {
//	아무런 내용을 가지지 않는 인터페이스를 표시(Marker) 인터페이스라 부른다.
}

//	클래스에 클래스를 붙여서 사용하려면 extends 예약어를 붙여 사용해서 상속을 시키고, 클래스에 인터페이스를 붙여서 사용하려면 implements 예약어를 사용해서 구현시켜 사용한다.
//	Line 클래스는 Point 클래스를 상속받고 Draw, Graphic 인터페이스를 구현받아 만든다.
class Line extends Point implements Draw, Graphic {

	@Override
	public void rotate() {
		
	}
	@Override
	public void resize() {
		
	}
	@Override
	public void movemove() {}
	@Override
	public void erase() {
		
	}
	
}

public class InterfaceTest {

	public static void main(String[] args) {

		Shape shape = new Shape();
		System.out.println("shape.PI: " + shape.PI);
//		static으로 선언한 필드나 메소드는 생성하지 않고 클래스 이름에 "."을 찍어서 접근할 수 있다.
		System.out.println("Shape.PI: " + Shape.PI);
//		Shape.PI = 1.23456;	// 에러
		
		System.out.println("Draw.PI: "+ Draw.PI);
		System.out.println("Draw.LIMIT: "+ Draw.LIMIT);
	}

}
