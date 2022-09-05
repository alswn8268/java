package com.tjoeun.shareAreaTest;

//	연산 결과를 출력하는 스레드, 실행 시간이 짧은 스레드
public class PrintThread extends Thread {

//	공유 영역으로 사용할 클래스 객체를 필드로 선언한다.
	ShareArea shareArea;
	
	public PrintThread() {	}
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
		/*
//		CalculatorThread의 실행이 끝날 때(shareArea.ready에 true가 저장될 때)까지 대기시킨다.
		while (!shareArea.ready) {
//			스레드가 너무 빠르게 실행되면 정상적인 처리가 되지 않기 때문에 sleep() 메소드로 주기적으로 멈춰야 한다.
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	*/
		
//		위의 주석으로 처리한 부분은 스레드 사이에 불필요한 작업 전환이 이루어진다.
//		얼음(wait()), 땡(notify(), notifyAll())
//		wait() 메소드로 CalculatorThread의 스레드 실행이 끝날 때까지 대기한다.
//		wait() 메소드는 현재 스레드를 다른 스레드에서 깨울 때까지 멈춘다.
//		다시 실행되게 하려면 다른 스레드에서 notify(), notifyAll() 메소드를 실행한다.
//		notify() 메소드는 wait() 메소드로 일시 정지된 스레드를 임의의 순서대로 깨운다.
//		notifyAll() 메소드는 일시 정지된 모든 스레드를 일괄적으로 깨운다.
//		wait(), notify(), notifyAll() 메소드는 모두 동기화 블록 내부에 코딩해야 한다.
		
//		동기화 블록
//		동기화 블록의 인수는 여러 스레드가 같이 사용하는 공유 영역으로 사용되는 객체의 이름을 쓰면 된다.
		synchronized (shareArea) {
			try {
				shareArea.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
		
		System.out.println("원주율: " + shareArea.result);
	}	
	
}
