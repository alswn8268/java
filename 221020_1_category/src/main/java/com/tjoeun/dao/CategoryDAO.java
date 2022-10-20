package com.tjoeun.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.vo.CategoryVO;

public class CategoryDAO {

	private static CategoryDAO instance = new CategoryDAO();
	private CategoryDAO() {
		
	}
	public static CategoryDAO getInstance() {
		return instance;
	}
	
	// CategoryService 클래스에서 호출되는 mapper와 테이블에 저장할 메인 카테고리가 저장된 객체를 넘겨받고 테이블에 메인 카테고리를 저장하는 category.xml 파일의 insert sql 명령을 실행하는 메소드
	public void insert(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO의 insert() 메소드");
		mapper.insert("insert", vo);
	}
	
	// CategoryService 클래스에서 호출되는 mapper를 넘겨받고 테이블에 저장된 전체 카테고리 목록을 얻어오는 category.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<CategoryVO> selectList(SqlSession mapper) {
		System.out.println("CategoryDAO의 selectList() 메소드");
		// selectOne(): ibatis의 queryForObject() 메소드와 같은 기능이 실행된다.
		// selectList():ibatis의 queryForList() 메소드와 같은 기능이 실행된다. 
		return (ArrayList<CategoryVO>) mapper.selectList("selectList");
	}
	
}
