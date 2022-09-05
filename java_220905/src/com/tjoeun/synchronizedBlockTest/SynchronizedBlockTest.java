package com.tjoeun.synchronizedBlockTest;

public class SynchronizedBlockTest {

	public static void main(String[] args) {
		
		ShareArea shareArea = new ShareArea();
		
		TransferThread transfer = new TransferThread(shareArea);
		PrintThread print = new PrintThread(shareArea);
	
		transfer.start();
		print.start();
		
	}
	
}
