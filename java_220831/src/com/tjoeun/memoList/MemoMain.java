package com.tjoeun.memoList;

import java.util.Scanner;

public class MemoMain {

	private static MemoList memoList = new MemoList();
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int menu = 0;

		while (menu != 7) {
			while (true) {
				System.out.println("============================================================================");
				System.out.println(" 1.입력  2.목록보기  3.수정  4.삭제  5.파일로 저장  6.파일에서 읽기  7.종료 ");
				System.out.println("============================================================================");
				System.out.print("원하는 메뉴를 입력하세요: ");
				menu = scanner.nextInt();
				if (menu >= 1 && menu <= 7) {
					break;
				}
				System.out.println("\n메뉴는 1~7 사이로 입력해야 합니다.\n");
			}

			switch (menu) {
			case 1:
				insert();
				break;			
			case 2:
				System.out.println(memoList);
				break;				
			case 3:
				update();
				break;				
			case 4:
				delete();				
				break;		
			case 5:
				fileWrite();
				break;		
			case 6:
				fileRead();
				break;		
				
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void insert() {
		System.out.println("게시판에 저장할 글 입력");
		Scanner scanner = new Scanner(System.in);
		MemoVO memoVO = new MemoVO();
		
		System.out.print("이름: ");
		String name = scanner.nextLine().trim();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine().trim();
		System.out.print("메모: ");
		String memo = scanner.nextLine().trim();
		
		MemoVO vo = new MemoVO(name, password, memo);
		memoList.addMemo(vo);
		System.out.println("입력 완료!");
	}
	
	private static void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 글 번호를 입력하세요: ");
		int idx = scanner.nextInt();
		
		MemoVO original = memoList.selectMemo(idx);
		
		if (original == null) {
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		} else {
			System.out.println("삭제할 글 확인");
			System.out.println(original);
			
			System.out.print("삭제할 글의 비밀번호를 입력하세요: ");
			scanner.nextLine();
			String password = scanner.nextLine().trim();
		
			if (password.equals(original.getPassword())) {
				memoList.deleteMemo(idx);
				System.out.println(idx + "번 글 삭제 완료");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
		}
		
	}
	
	private static void update() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 글 번호를 입력하세요: ");
		int idx = scanner.nextInt();
		
		MemoVO original = memoList.selectMemo(idx);
		
		if (original == null) { 
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		} else {
			System.out.println("수정할 글 확인");
			System.out.println(original);
			System.out.print("수정할 글의 비밀번호를 입력하세요: ");
			scanner.nextLine();	
			String password = scanner.nextLine().trim();
			
			if (password.equals(original.getPassword())) {
				System.out.print("수정할 메모를 입력하세요: ");
				String memo = scanner.nextLine().trim();
				memoList.updateMemo(idx, memo);
				System.out.println(idx + "번 글 수정 완료");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
		}
	}

//	키보드로 텍스트 파일 이름을 입력받아 MemoList 클래스의 memoList ArrayList에 저장된 데이터를 텍스트 파일로 출력하는 메소드를 실행하는 메소드
	private static void fileWrite() {
		Scanner scanner = new Scanner(System.in);
//		텍스트 파일 이름을 입력받는다.
		System.out.print("저장할 텍스트 파일 이름을 입력하세요: ");
		String fileName = scanner.nextLine().trim();
//		MemoList 클래스의 memoList ArrayList에 저장된 데이터를 텍스트 파일로 출력하는 메소드를 호출한다.
		memoList.writeMemo(fileName);

	}
	
//	키보드로 텍스트 파일 이름을 입력받아 텍스트 파일의 데이터를 읽어서 MemoList 클래스의 memoList ArrayList에 저장한다.
	private static void fileRead() {
		Scanner scanner = new Scanner(System.in);
//		텍스트 파일 이름을 입력받는다.
		System.out.print("읽어올 텍스트 파일 이름을 입력하세요: ");
		String fileName = scanner.nextLine().trim();
//		텍스트 파일의 데이터를 읽어 MemoList 클래스의 memoList ArrayList에 저장하는 메소드를 호출한다.
		memoList.readMemo(fileName);
	}
	
}