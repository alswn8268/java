package com.tjoeun.abstractClass;

import java.util.ArrayList;

abstract class Animal {
//	public void move() {
//		System.out.println("동물이 움직입니다.");
//	}
	public abstract void move(); // 추상 메소드

	public void eating() { // 일반 메소드

	}

}

//	Human 클래스는 Animal 클래스를 상속받아 만든다.
class Human extends Animal {

	@Override
	public void move() {
		System.out.println("사람이 두 발로 걷습니다.");
	}

	public void readBooks() {
		System.out.println("사람이 책을 읽습니다.");
	}

}

//	Dog 클래스는 Animal 클래스를 상속받아 만든다.
class Dog extends Animal {

	@Override
	public void move() {
		System.out.println("강아지가 네 발로 걷습니다.");
	}

	public void smell() {
		System.out.println("강아지가 냄새를 맡습니다.");
	}
}

//	Ingeo 클래스는 Animal 클래스를 상속받아 만든다.
class Ingeo extends Animal {

	@Override
	public void move() {
		System.out.println("잉어가 헤엄칩니다.");
	}

	public void ing() {
		System.out.println("잉어가...");
	}

}

public class InstanceofTest {

	public static void main(String[] args) {

//		Animal animals[] = {new Human(), new Dog(), new Ingeo()};
//		animals[0].move();
//		animals[1].move();
//		animals[2].move();

		Animal hAnimal = new Human(); // upcasting, 자식 => 부모
		Animal dAnimal = new Dog(); // upcasting, 자식 => 부모
		Animal IAnimal = new Ingeo(); // upcasting, 자식 => 부모

//		main()이라는 static 메소드에서 moveAnimal 메소드를 바로 실행하기 때문에 moveAnimal() 메소드는 반드시 static으로 선언된 메소드이어야 한다.
		moveAnimal(hAnimal);
		moveAnimal(dAnimal);
		moveAnimal(IAnimal);
		System.out.println("==================================");
//		현재 클래스 자신의 객체를 생성하서 moveAnimal2() 메소드를 실행하게 되면 static 메소드로 만들지 않고도 실행할 수 있다.
//		private void moveAnimal2 (Animal animal) { }
		InstanceofTest test = new InstanceofTest(); // 자신의 클래스 객체를 만든다.
		test.moveAnimal2(hAnimal);
		test.moveAnimal2(dAnimal);
		test.moveAnimal2(IAnimal);
		System.out.println("==================================");

		ArrayList<Animal> animalList = new ArrayList<>();
		animalList.add(hAnimal);
		animalList.add(dAnimal);
		animalList.add(IAnimal);

		for (Animal animal : animalList) {
			animal.move();
		}
		System.out.println("==================================");

		for (int i = 0; i < animalList.size(); i++) {
			Animal animal = animalList.get(i);
//			downcasting: upcasting된 클래스를 다시 원래의 타입으로 형변환시킨다.
//			instanceof 연산자를 사용하여 형변환이 가능한지 확인한 후 downcasting을 실행한다.
			if (animal instanceof Human) {
				Human human = (Human) animal; // downcasting, 부모에 저장된 자식 객체 => 자식
				human.readBooks();
			} else if (animal instanceof Dog) {
				Dog dog = (Dog) animal;
				dog.smell();
			} else if (animal instanceof Ingeo) {
				Ingeo ingeo = (Ingeo) animal;
				ingeo.ing();
			} else {
				System.out.println("downcasting 불가능");
			}
		}

	}

	private static void moveAnimal(Animal animal) {
		animal.move();
	}

	private void moveAnimal2(Animal animal) {
		animal.move();
	}

}
