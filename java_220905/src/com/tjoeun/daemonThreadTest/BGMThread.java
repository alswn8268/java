package com.tjoeun.daemonThreadTest;

public class BGMThread extends Thread{

	@Override
	public void run() {
			
		while (true) {
			System.out.println("배경 음악이 연주되는 중...");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
