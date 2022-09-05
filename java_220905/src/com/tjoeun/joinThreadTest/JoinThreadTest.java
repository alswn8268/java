package com.tjoeun.joinThreadTest;

public class JoinThreadTest {

	public static void main(String[] args) {

		JoinThread jt1 = new JoinThread(1, 50);
		JoinThread jt2 = new JoinThread(51, 100);

		jt1.start();
		jt2.start();

		try {
//		join() 메소드는 동시에 2개 이상의 스레드가 실행될 때 다른 스레드의 결과를 참조해서 실행해야 할 경우 사용한다.
//		join() 메소드를 실행한 클래스가 끝나기를 기다렸다가 실행된다.
			jt1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("jt1.total: " + jt1.total);
		System.out.println("jt2.total: " + jt2.total);
		
		int lastTotal = jt1.total + jt2.total;
		System.out.println("lastTotal: " + lastTotal);

	}

}
