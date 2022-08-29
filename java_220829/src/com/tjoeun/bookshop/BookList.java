package com.tjoeun.bookshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class BookList {

//	도서 정보를 기억할 ArrayList를 만든다.
	private ArrayList<BookVO> bookList = new ArrayList<>();
	
//	생성자를 선언하지 않았으므로 자바 컴파일러가 아무런 일도 하지 않는 기본 생성자를 만들어 준다.
	
	public ArrayList<BookVO> getBooklist() {
		return bookList;
	}
	public void setBooklist(ArrayList<BookVO> booklist) {
		this.bookList = booklist;
	}
	
	public String toString() {
		
		String str = "";
		str += "===============================================================\n";
		str += "    도서명       저자       출판사      출판일        가격  \n";
		str += "===============================================================\n";
		int sum = 0;
		
//		for (int i = 0; i < bookList.size(); i++) {
//			str += bookList.get(i) + "\n";				
//			sum += bookList.get(i).getPrice();
//		}
		for (BookVO obj : bookList) {
			str += obj + "\n";
			sum += obj.getPrice();
		}
		
		
		DecimalFormat df = new DecimalFormat("￦#,##0");
		
		str += "===============================================================\n";
		str += "합계 금액: " + df.format(sum) + "\n";
		str += "===============================================================\n";		
		return str;	
	}
	
//	BookList 클래스의 bookList ArrayList에 인수로 넘겨받은 도서 정보를 저장하는 메소드
	public void addBook(BookVO book) {
		bookList.add(book);
	}

}