package com.tjoeun.abstractClass;

import java.util.Scanner;

//	다형성(Polymorphism)이란 같은 메소드가 서로 다른 클래스에서 다양하게 실행되는 것을 말한다.
//	다형성을 구현하기 위해서는 다형성을 구현할 메소드가 포함된 모든 클래스가 같은 부모를 가져야 하고
//	부모와 자식 클래스에 같은 이름의 메소드가 있어야 하며 자식 클래스는 부모 클래스의 메소드를 반드시 Override 시켜서 사용해야 한다.
//	부모 클래스 타입의 객체에 자식 클래스 타입의 객체를 대입해서 다형성이 구현된 메소드를 실행한다.

abstract class Shape {
	int x, y;

	void move() {
	} // 일반 메소드

	abstract void draw(); // 추상 메소드 => 다형성을 구현할 메소드
}

// Shape 클래스를 상속받아 Point 클래스를 만든다.
class Point extends Shape {
	@Override
	void draw() {
		System.out.println("점을 찍는다.");
	}
}

//	Shape 클래스를 상속받아 Line 클래스를 만든다.
class Line extends Shape {
	@Override
	void draw() {
		System.out.println("선을 그린다.");
	}
}

//	Shape 클래스를 상속받아 Circle 클래스를 만든다.
class Circle extends Shape {
	@Override
	void draw() {
		System.out.println("원을 그린다.");
	}
}

//	Shape 클래스를 상속받아 Rectangle 클래스를 만든다.
class Rectangle extends Shape {
	@Override
	void draw() {
		System.out.println("사각형을 그린다.");
	}
}

class Triangle extends Shape {
	@Override
	void draw() {
		System.out.println("삼각형을 그린다.");
	}
}

public class PolymorphismTest {

	public static void main(String[] args) {
		
//		Shape shape = new Point();
//		shape.draw();
//		Shape shape2 = new Line();
//		shape2.draw();
//		Shape shape3 = new Circle();
//		shape3.draw();
//		Shape shape4 = new Rectangle();
//		shape4.draw();
//		Shape shape5 = new Triangle();
//		shape5.draw();
	
		Shape[] shapes =  {new Point(), new Line(), new Circle(), new Rectangle(), new Triangle()}; 
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 작업을 선택하세요: ");
		int menu = scanner.nextInt();

		shapes[menu - 1].draw();
		
		
	}
	
}
