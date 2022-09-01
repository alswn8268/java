package com.tjoeun.abstractClass;

abstract class Car {

//	자식 클래스에서 다르게 구현되어야 하는 부분은 추상 클래스에서 추상 메소드로 선언한다.
//	다형성을 구현할 메소드는 추상 메소드로 선언한다.
	public abstract void drive();

	public abstract void stop();

//	자식 클래스에서 공통적으로 실행될 부분은 추상 클래스에서 일반 메소드로 선언한다.
	public void turnOn() {
		System.out.println("시동을 켭니다.");
	}

	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}

//	템플릿 메소드: 추상 메소드나 내용이 구현된 일반 메소드를 사용해서 코드의 흐름(시나리오)을 정의하는 메소드로, 프레임워크에서 많이 사용하는 설계 패턴
//	추상 클래스로 선언된 부모 클래스에서 템플릿 메소드를 활용해서 전체적인 흐름을 정의하고 자식 클래스에서 다르게 구현되어야 하는 부분은 추상 메소드로 선언해서 자식 클래스에서 Override해서 구현한다.

//	final로 선언해서 자식 클래스에서 Override할 수 없게 만든다.
	final public void run() {
		turnOn();
		drive();
		stop();
		turnOff();
	}

}

// AICar 클래스는 Car 클래스를 상속받아 만든다.

class AICar extends Car {

	@Override
	public void drive() {
		System.out.println("자동차가 스스로 주행합니다.");
		System.out.println("자동차가 스스로 방향을 변경합니다.");
	}

	@Override
	public void stop() {
		System.out.println("자동차가 스스로 정지합니다.");
	}

//	부모 클래스에서 final로 선언된 메소드는 자식 클래스에서 Override를 시도하면 에러가 발생된다.
//	public void run() { }

}

class ManualCar extends Car {

	@Override
	public void drive() {
		System.out.println("사람이 자동차를 운전합니다.");
		System.out.println("사람이 방향을 변경합니다.");
	}

	@Override
	public void stop() {
		System.out.println("사람이 자동차를 정지시킵니다.");
	}

}

public class TemplateMethodTest {

	public static void main(String[] args) {

		Car manualCar = new ManualCar();
		manualCar.run();
		System.out.println("===========================");
		Car aiCar = new AICar();
		aiCar.run();

	}

}
