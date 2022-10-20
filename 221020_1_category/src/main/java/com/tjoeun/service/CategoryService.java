package com.tjoeun.service;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.dao.CategoryDAO;
import com.tjoeun.mybatis.MySession;
import com.tjoeun.vo.CategoryList;
import com.tjoeun.vo.CategoryVO;

public class CategoryService {

	private static CategoryService instance = new CategoryService();
	private CategoryService() {
		
	}
	public static CategoryService getInstance() {
		return instance;
	}
	
	// insert.jsp에서 호출되는 테이블에 저장할 메인 카테고리 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후 CategoryDAO 클래스의 메인 카테고리를 저장하는 insert sql 명령을 실행하는 메소드를 호출하는 메소드
	public void insert(CategoryVO vo) {
		System.out.println("CategoryService의 insert() 메소드");
		// mapper를 얻어온다.
		SqlSession mapper = MySession.getSession();
		// System.out.println("연결 성공: " + mapper);
		
		// CategoryDAO 클래스의 insert sql 명령을 실행하는 메소드를 호출한다.
		CategoryDAO.getInstance().insert(mapper, vo);
		
		// 실행한 sql 명령이 테이블을 변경하는 insert, delete, update sql 명령일 경우 작업 결과를 테이블에 반영시키기 위해 작업이 완료되면 반드시 commit() 메소드를 실행해야 한다.
		// 테이블이 변경되지 않는 select sql 명령은 commit() 메소드를 실행하지 않아도 상관 없다.
		mapper.commit(); // 선택
		// mapper를 사용한 데이터베이스 작업이 완료되면 반드시 mapper를 닫아야 한다.
		mapper.close(); // 필수
	}
	
	// list.jsp에서 호출되는 mapper를 얻어온 후 CategoryDAO 클래스 테이블에 저장된 전체 카테고리 목록을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public CategoryList selectList() {
		System.out.println("CategoryService의 selectList() 메소드");
		SqlSession mapper = MySession.getSession();
		
		// 전체 카테고리 목록을 저장해서 리턴시킬 객체를 선언한다.
		CategoryList categoryList = new CategoryList();
		// 테이블에서 얻어온 전체 카테고리 목록을 CategoryList 클래스의 ArrayList에 저장한다.
		categoryList.setList(CategoryDAO.getInstance().selectList(mapper));
		mapper.commit();
		// System.out.println(categoryList);
		mapper.close();
		return categoryList;
	}
	
}
