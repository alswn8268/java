package com.tjoeun.customer;

public class CustomerTest {

	public static void main(String[] args) {
		
//		일반 고객 객체 생성
		Customer customerLee = new Customer();
		customerLee.setCustomerID(1);
		customerLee.setCustomerName("이쫄깃");
		customerLee.setBonusPoint(500);
		
		System.out.println("회원 정보: " + customerLee.showCustomerInfo());
		System.out.println("보너스 포인트: " + customerLee.calcBonus(10000));
		System.out.println("누적 보너스 포인트: " + customerLee.calcPrice(10000));
		
		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerID(2);
		customerKim.setCustomerName("김말이");
		customerKim.setBonusPoint(2000);
		
		System.out.println("회원 정보: " + customerKim.showCustomerInfo());		
		System.out.println("보너스 포인트: " + customerKim.calcBonus(10000));
		System.out.println("누적 보너스 포인트: " + customerKim.calcPrice(10000));
		
	}
	
}
