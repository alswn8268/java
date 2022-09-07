package com.tjoeun.memoList;

import java.util.Scanner;

public class MemoDBMain {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int menu = 0;

		while (menu != 5) {
			while (true) {
				System.out.println("===========================================");
				System.out.println(" 1.입력  2.목록보기  3.수정  4.삭제  5.종료 ");
				System.out.println("===========================================");
				System.out.print("원하는 메뉴를 입력하세요: ");
				menu = scanner.nextInt();
				if (menu >= 1 && menu <= 5) {
					break;
				}
				System.out.println("\n메뉴는 1~5 사이로 입력해야 합니다.\n");
			}

			switch (menu) {
			case 1:
//				MemoService 클래스의 테이블에 저장할 데이터를 입력받아 DAO 클래스로 넘겨주는 메소드를 호출한다.
				MemoService.insert();
				break;			
			case 2:
				MemoService.select();
				break;				
			case 3:
				MemoService.update();
				break;				
			case 4:
				MemoService.delete();
				break;					
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	
}