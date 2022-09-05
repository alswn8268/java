package com.tjoeun.genericTest2;

//	3D 프린터 재료 - Plastic
public class Plastic extends Material{

	@Override
	public String toString() {
		return "Plastic";
	}

	@Override
	void doPrinting() {
		System.out.println("Plastic 재료로 출력합니다.");
	}

	
	
}
