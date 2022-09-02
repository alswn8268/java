package com.tjoeun.genericTest;

public class ThreeDPrinterTest {

	public static void main(String[] args) {
		
		ThreeDPrinterPowder powderprinter = new ThreeDPrinterPowder();
		Powder powder = new Powder();
		powderprinter.setMaterial(powder);
		powder = powderprinter.getMaterial();
		
		ThreeDPrinterPlastic plasticprinter = new ThreeDPrinterPlastic();
		Plastic plastic = new Plastic();
		plasticprinter.setMaterial(plastic);
		plastic = plasticprinter.getMaterial();
		
		ThreeDPrinter printer = new ThreeDPrinter();
		
		printer.setMaterial(powder);
		System.out.println(printer.getMaterial());
//		자식 객체를 부모 객체에 넣을 때(upcasting)는 별다른 문제가 발생되지 않지만 부모 객체에 저장된 자식 객체를 자식 객체에 넣을 때(downcasting)는 반드시 형변환해야 한다.
		powder = (Powder) printer.getMaterial();
		
		printer.setMaterial(plastic);
		System.out.println(printer.getMaterial());
		plastic = (Plastic) printer.getMaterial();
		
		GenericPrinter<Powder> genericPrinter = new GenericPrinter<>();
		genericPrinter.setMaterial(powder);
		System.out.println(genericPrinter.getMaterial());
		powder = genericPrinter.getMaterial();
		
		GenericPrinter<Plastic> genericPrinter2 = new GenericPrinter<>();
		genericPrinter2.setMaterial(plastic);
		plastic = genericPrinter2.getMaterial();
		System.out.println(genericPrinter2.getMaterial());
		
	}
	
}
