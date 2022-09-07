package com.tjoeun.memoList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoVO {

//	클래스의 필드 이름은 테이블에서 정의한 필드 이름, html의 form 태그 요소의 name 속성에 정의한 이름과 반드시 같은 이름으로 만든다.
	private int idx; 
	private String name; 
	private String password;
	private String memo; 
	private Date writeDate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
//		오늘 입력된 메모는 시간만 표시하고, 어제 이전에 입력된 메모는 날짜만 표시한다.
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH시 mm분 ss초");	// 오늘
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일(E)"); // 어제 이전
		
//		메모가 작성된 날짜가 오늘인가 판단한다.
		Date date = new Date();
		boolean tf = writeDate.getDate() == date.getDate() && writeDate.getMonth() == date.getMonth() && writeDate.getYear() == date.getYear();
		return String.format("%d.  %s(%s)님이 %s에 남긴 글\n %s\n", idx, name, password, tf ? sdf1.format(writeDate) : sdf2.format(writeDate), memo);
	}	
	
	
	
}
