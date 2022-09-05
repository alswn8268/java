package com.tjoeun.shareAreaTest;

import java.util.Date;

//	연산을 하는 클래스, 실행 시간이 긴 스레드
public class CalculatorThread extends Thread {

//	공유 영역으로 사용할 클래스 객체를 필드로 선언한다.
	ShareArea shareArea;
	
	public CalculatorThread() {	}
	public CalculatorThread(ShareArea shareArea) {
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
//		무한 급수를 이용한 원주율 계산 => 시간이 오래 걸린다.
		double total = 0.0;
		long start = System.currentTimeMillis();
		for (int i = 1; i < 1000000000; i += 2) {
			if (i / 2 % 2 == 0) {
				total += 1.0 / i;
			} else {
				total += -1.0 / i;
			}
		}
		long end = System.currentTimeMillis();
		
//		System.out.println("원주율: " + total * 4);
		System.out.println((end-start)/1000. + "초");
//		연산 결과를 공유 영역의 연산 결과를 기억하는 필드에 넣어준다.
		shareArea.result = total * 4;
		
//		계산이 완료되었음을 알려준다.
		shareArea.ready = true;
		
//		계산이 완료될 동안 멈춰있는 PrintThread를 notify(), notifyAll() 메소드로 깨운다.
		synchronized (shareArea) {
				shareArea.notify();
		}
	}	
	
}
