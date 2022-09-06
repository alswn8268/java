package com.tjoeun.DBTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionTest {

	public static void main(String[] args) {
		
//		JDBC(Java DataBase Connection): 자바를 이용해서 데이터베이스에 연결하는 기술
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null;	// 데이터베이스와 연결한다.
		Statement stmt = null;	// 정적 쿼리를 실행한다. => 쿼리에 변수가 사용되지 않는 경우 => 간단한 쿼리
		PreparedStatement pstmt = null;	// 동적 쿼리를 실행한다. => 쿼리에 변수가 사용되는 경우 => 복잡한 쿼리
		ResultSet rs = null;	// select 쿼리의 실행 결과를 저장한다.
		
//		MySQL 드라이버 클래스를 읽어온다.
		try {
			Class.forName("com.mysql.jdbc.Driver");	// mysql 5.x 사용자
//			Class.forName("com.mysql.cj.jdbc.Driver");	// mysql 8.x 사용자
//			MySQL에 연결한다.
//			DriverManager 클래스의 getConnection(url, user, password) 메소드로 데이터베이스에 연결한다.
//			url에 사용할 MySQL이 설치된 경로와 데이터베이스 이름을 적는다.
//			localhost는 접속할 MySQL이 설치된 컴퓨터가 현재 사용중인 컴퓨터입을 의미하며 localhost 대신 127.0.0.1을 사용해도 된다.
//			3306은 MySQL이 컴퓨터와 통신할 때 사용하는 포트 번호를 의미한다. => 오라클은 1521을 사용한다.
			String url = "jdbc:mysql://localhost:3306/javaam";	// mysql 5.x 사용자
//			String url = "jdbc:mysql://localhost:3306/javaam?serverTimezone=UTC";	// mysql 8.x 사용자
			conn = DriverManager.getConnection(url, "root", "8268");
			
//			변경되는 부분을 코딩한다.
			System.out.println("연결성공: " + conn);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
		} finally {
//			데이터베이스 작업이 완료되면 사용한 모든 객체를 닫는다.
			if (conn != null) {	try { conn.close(); } catch (SQLException e) { e.printStackTrace();	} }
			if (stmt != null) {	try { stmt.close(); } catch (SQLException e) { e.printStackTrace();	} }
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (rs != null) { try { rs.close();	} catch (SQLException e) { e.printStackTrace();	} }
		}
		
	}
	
}
