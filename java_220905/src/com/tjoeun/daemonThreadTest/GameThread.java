package com.tjoeun.daemonThreadTest;

public class GameThread {

	public static void main(String[] args) {
		
		BGMThread bgm = new BGMThread();
		
//		daemon 스레드는 다른 스레드가 모두 종료되면 같이 종료되는 스레드를 말한다.
		bgm.setDaemon(true);
		
		bgm.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("게임을 하는 중...");
			
			if (i == 7) {
				System.out.println("앗...");
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
