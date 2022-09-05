package com.tjoeun.genericTest2;

//	3D 프린터 재료 - Powder
public class Powder extends Material{

	@Override
	public String toString() {
		return "Powder";
	}

	@Override
	void doPrinting() {
		System.out.println("Powder 재료로 출력합니다.");
	}
	
}
