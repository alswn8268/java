package com.tjoeun.bookshop;

import java.util.Date;

public class BookShopMain {

	public static void main(String[] args) {
		BookVO vo = new BookVO();
		BookVO book1 = new BookVO("셜록 홈즈", "아서 코난 도일", "문예춘추사", new Date(2022, 8, 26), 10000);
		BookVO book2 = new BookVO("셜록 홈즈", "아서 코난", "문예춘추사", new Date(2022, 8, 26), 10000);
		BookVO book3 = new BookVO("셜록 홈즈", "명탐정 코난", "문예춘추사", new Date(2022, 8, 26), 10000);
		BookVO book4 = new BookVO("셜록 홈즈", "미래소년 코", "문예춘추사", new Date(2022, 8, 26), 10000);
		BookVO book5 = new BookVO("셜록 홈즈", "남도일", "문예춘추사", new Date(2022, 8, 26), 10000);
		BookVO book6 = new BookVO("셜록 홈즈", "아서 코난 ", "문예춘추사", new Date(2022, 8, 26), 10000);
		
		BookList bookList = new BookList();
		
		bookList.addBook(book1);
		bookList.addBook(book2);
		bookList.addBook(book3);
		bookList.addBook(book4);
		bookList.addBook(book5);
		bookList.addBook(book6);
	
		System.out.println(bookList);		
	}

}
