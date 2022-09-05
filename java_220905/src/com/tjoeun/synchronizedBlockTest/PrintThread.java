package com.tjoeun.synchronizedBlockTest;

//	잔액 출력 스레드
public class PrintThread extends Thread {
	ShareArea shareArea;  

	public PrintThread() { }
	public PrintThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	public ShareArea getShareArea() {
		return shareArea;
	}
	public void setShareArea(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	
	@Override
	public void run() {
		
		synchronized (shareArea) {
			for (int i = 0; i < 3; i++) {
				int sum = shareArea.lee.money + shareArea.kim.money;
				System.out.println("예금 합계: " + sum + "원");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		//		System.out.println(shareArea.kim.getName() + "님의 현재 잔액은 " + shareArea.kim.getMoney() + "원 입니다.");
	}
	
}
