package com.tjoeun.synchronizedBlockTest;

//	입출금을 실행하는 스레드와 잔액을 출력하는 스레드가 공유해서 사용할 클래스
public class ShareArea {

	Account lee = new Account("1234567890", "이몽룡", 10000000);
	Account kim = new Account("0987654321", "김쫄깃", 10000000);
	
}
