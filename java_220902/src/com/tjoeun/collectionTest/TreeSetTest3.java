package com.tjoeun.collectionTest;

import java.util.TreeSet;

public class TreeSetTest3 {

	public static void main(String[] args) {

		TreeSet<Person> tset = new TreeSet<>();

/*		Person person = new Person();
		Person person2 = new Person("홍길동", 20);
		
		tset.add(person2);
		System.out.println(tset.size() + ": " + tset);
//		(Hashcode가)같은 객체를 2번 이상 넣으면 중복되는 객체로 인식해서 저장하지 않는다.
		tset.add(person2);
		System.out.println(tset.size() + ": " + tset);	*/

//		new를 사용해서 객체를 생성하면 기존에 생성했던 객체와 내용이 같더라도 다른 Hashcode가 부여된다.
//		TreeSet과 TreeSet은 중복되는 데이터 판단을 Hashcode로 하기 때문에, 내용이 같더라도 다른 Hashcode를 가지면 내용이 같아도 다른 객체로 취급해서 내용이 같은 객체가 저장된다.
//		저장된 내용이 같은 객체를 같은 객체로 인식하게 하려면 Hashcode() 메소드를 Override해서 내용이 같은 객체는 같은 Hashcode를 가지게 하면 된다.
		
//		TreeSet은 HashSet과 달리 데이터를 정렬시켜야 한다.
//		TreeSet에 저장한 데이터가 단순 데이터인 경우 자바가 알아서 오름차순으로 정렬시켜 주지만, 클래스로 생성한 복합 데이터일 경우,
//		TreeSet에 저장된 클래스(Person 클래스)를 설계할 때 Comparable 인터페이스를 구현하고 compareTo() 메소드를 Override해서 정렬 기준으로 사용할 필드에 저장된 데이터를 비교한다.
		
		tset.add(new Person("홍길동", 20));
		System.out.println(tset.size() + ": " + tset);	
		tset.add(new Person("홍길동", 20));
		System.out.println(tset.size() + ": " + tset);	
		tset.add(new Person("홍길동", 35));
		System.out.println(tset.size() + ": " + tset);	
		tset.add(new Person("홍길동", 27));
		System.out.println(tset.size() + ": " + tset);	
		tset.add(new Person("임꺽정", 20));
		System.out.println(tset.size() + ": " + tset);	
		tset.add(new Person("장길산", 54));
		System.out.println(tset.size() + ": " + tset);	
		tset.add(new Person("일지매", 14));
		System.out.println(tset.size() + ": " + tset);	
		
		
		
	}
	
}
