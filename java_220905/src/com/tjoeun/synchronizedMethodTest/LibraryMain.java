package com.tjoeun.synchronizedMethodTest;

public class LibraryMain {

	public static Library library = new Library();
	
	public static void main(String[] args) {
		
		Library library = new Library();
		/*
		System.out.println(library.bookList);
		
//		ArrayList의 remove(index) 메소드를 실행하면 지정된 index의 데이터를 삭제하기 전에 변수에 저장한다.
		String book = library.bookList.remove(0);
		System.out.println(library.bookList);
		System.out.println(book);	*/

		Student student1 = new Student("홍길동");
		Student student2 = new Student("임꺽정");
		Student student3 = new Student("장길산");
		Student student4 = new Student("일지매");
		Student student5 = new Student("이몽룡");
		Student student6 = new Student("성춘향");
		
		student1.start();
		student2.start();
		student3.start();
		student4.start();
		student5.start();
		student6.start();
		
	}
	
}
