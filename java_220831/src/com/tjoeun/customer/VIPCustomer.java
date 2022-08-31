package com.tjoeun.customer;

//	우수 고객 정보를 기억하는 클래스
//	이미 Customer 클래스에서 구현한 내용이 중복되므로 Customer 클래스를 상속받아 만든다.
public class VIPCustomer extends Customer {

//	일반 고객 정보에는 없고 우수 고객 정보에만 있을 필드를 선언한다.
//	1 : 1 담당 상담원이 배정된다.
	private int agentID;	// 담당 상담원 ID
//	제품을 살 때 가격의 10%를 할인해주고 보너스 포인트는 5%를 적립한다.
	private double salesRatio;	// 추가 할인 비율
	
	public VIPCustomer() {
//		부모 클래스에서 private 권한으로 선언된 필드에 접근하면 에러가 발생된다.
//		private 권한의 필드는 접근할 수 없으므로 setter를 실행해서 VIP 고객 정보를 넣어준다.
		setCustomerGrade("VIP");
		setBonusRatio(0.05);
		salesRatio = 0.1;
	}
	
//	실제 구매 금액을 계산해서 리턴하는 메소드
	public int calcSales(int price) {
		return (int) (price * (1 - salesRatio));
	}

	
//	Customer 클래스에서 상속받은 calcBonus() 메소드는 구매 금액에 대한 보너스 포인트를 계산하기 때문에 VIP 고객의 할인율이 적용된 금액에 대한 보너스 포인트는 계산할 수 없다.
//	Customer 클래스에서 상속받은 calcBonus() 메소드를 Override 해서 구현한다.
	
//	구매 금액을 넘겨받아 실구매 금액에 따른 보너스 포인트를 계산하는 메소드
	@Override
	public int calcBonus(int price) {
		return (int) (calcSales(price) * getBonusRatio());
	}

	
}
