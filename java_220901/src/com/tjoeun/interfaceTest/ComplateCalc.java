package com.tjoeun.interfaceTest;

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

}
