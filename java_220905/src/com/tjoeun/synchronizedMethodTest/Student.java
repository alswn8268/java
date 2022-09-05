package com.tjoeun.synchronizedMethodTest;

public class Student extends Thread{

//	생성자를 통해서 스레드 이름(도서를 대여할 학생 이름)을 넣어준다.
	public Student() {	}
	public Student(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		try {
//			도서 대여
		String book = LibraryMain.library.lendBook();
		if (book == null) {
			return;
		}
			sleep(2500);	// 대여 기간
//			도서 반납
			LibraryMain.library.returnBook(book);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("책을 빌릴 수 없습니다.");
		}
	}

	
}
