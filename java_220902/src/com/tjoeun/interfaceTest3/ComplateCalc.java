package com.tjoeun.interfaceTest3;

public class ComplateCalc extends Calculator {

	@Override
	public int mul(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int div(int num1, int num2) {
		if (num2 == 0) {
			return ERROR;
		} else {
			return num1 / num2;			
		}
	}

	@Override
	public void description(int number) {
		System.out.println("Calc 인터페이스의 default 메소드를 Calculator 클래스에서 Override한 메소드를 상속받아 ComplateCalc 클래스에서 Override한 메소드");
	}
	
}
