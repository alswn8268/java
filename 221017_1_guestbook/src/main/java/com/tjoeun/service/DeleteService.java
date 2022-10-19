package com.tjoeun.service;

import java.sql.SQLException;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.tjoeun.dao.GuestbookDAO;
import com.tjoeun.ibatis.MyAppSqlConfig;
import com.tjoeun.vo.GuestBookList;
import com.tjoeun.vo.GuestbookVO;

public class DeleteService {
	private static DeleteService instance = new DeleteService();
	private DeleteService() {
		
	}
	public static DeleteService getInstance() {
		return instance;
	}

	// deleteOK.jsp에서 호출되는 삭제할 글번호를 넘겨받고 mapper를 얻어온 후 GuestbookDAO 클래스의 글 1건을 삭제하는 delete SQL 명령을 실행하는 메소드를 호출하는 메소드
	public void delete(int idx) {
		System.out.println("DeleteService의 delete() 메소드 실행");
		
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		try {
			GuestbookDAO.getInstance().delete(mapper, idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}
