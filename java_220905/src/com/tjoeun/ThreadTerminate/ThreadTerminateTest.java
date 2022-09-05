package com.tjoeun.ThreadTerminate;

import java.util.Scanner;

public class ThreadTerminateTest {

	public static void main(String[] args) {
		
		ThreadTerminate terminateA = new ThreadTerminate("A");
		System.out.println(terminateA.getName());
		ThreadTerminate terminateB = new ThreadTerminate("B");
		ThreadTerminate terminateC  = new ThreadTerminate("C");
		
		terminateA.start();
		terminateB.start();
		terminateC.start();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("스레드 종료하기");

		while (true) {
			char ch = scanner.nextLine().charAt(0);
			if (ch == 'A') {
				terminateA.setFlag(false);
			} else if (ch == 'B') {
				terminateB.setFlag(false);				
			} else if (ch == 'C') {
				terminateC.setFlag(false);
			} else if (ch == 'M') {
				terminateA.setFlag(false);
				terminateB.setFlag(false);				
				terminateC.setFlag(false);
				break;
			}
		}
		
	}
	
}

