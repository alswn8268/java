package com.tjoeun.synchronizedBlockTest;

public class Account {

	String accountNo;	// 계좌 번호
	String name;	// 고객 이름
	int money;	// 잔고
	
	public Account() { }
	public Account(String accountNo, String name, int money) {
		this.accountNo = accountNo;
		this.name = name;
		this.money = money;
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
		
//	입금 메소드
	public void deposit(int amount) {
		money += amount;
	}
	
//	출금 메소드
	public int withdraw(int amount) {
//		잔액과 비교해서 출금 가능한 경우 출근한다.
		if (amount <= money) {
			money -= amount;
			return amount;
		} else {
			System.out.println(accountNo + "(" + name + ") 잔액이 부족합니다.");
			return 0;
		}
	}
	
}
















