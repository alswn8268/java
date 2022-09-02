package com.tjoeun.genericTest;

//	재료로 Powder와 Plastic을 모두 사용하는 3D 프린터, 겸용 프린터 => Generic 사용
//	Generic은 자료형 변수로 데이터가 아니라 데이터의 타입을 받는다.
//	클래스를 사용하는 시점에 실제로 사용할 자료형을 지정한다. 
//	static에는 사용할 수없다.
//	E: Element, K: Key, V: Value, T: Template 등 여러 알파벳을 의미에 따라 사용할 수 있다.

public class GenericPrinter<M> {
	
	private M material;

	public M getMaterial() {
		return material;
	}
	public void setMaterial(M material) {
		this.material = material;
	}
	
}
