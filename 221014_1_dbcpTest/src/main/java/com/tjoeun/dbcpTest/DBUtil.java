package com.tjoeun.dbcpTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

    // mysql에 연결하는 connection을 리턴하는 메소드
    public static Connection getMysqlConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, "root", "8268");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");    
        }
        return conn;
        }
    
    // commonsDBCP를 사용해서 mysql이나 oracle에 연결한 connection을 리턴하는 메소드
    public static Connection getCommonsDBCPConnection() {
    	Connection conn = null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");		
    		// Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle
    		Class.forName("org.apache.commons.dbcp.PoolingDriver"); // commonsDBCP
    		// 데이터베이스 연결 정보가 저장된 파일(*.jocl)의 경로를 지정한다.
    		String url = "jdbc:apache:commons:dbcp:/pool";
    		conn = DriverManager.getConnection(url);
    		
    		System.out.println("연결 성공: " + conn + "<br/>");
    		
    	} catch (ClassNotFoundException e) {
    		System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
    	} catch (SQLException e) {
    		System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");		
    	}
    	return conn;
    }
    
    // tomcatDBCP를 사용해 mysql이나 oracle에 연결할 connection을 리턴하는 메소드
    public static Connection getTomcatDBCPConnection() {
    	Connection conn = null;
    	try {
    		Context initContext = new InitialContext();
    		DataSource dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/TestDB");    	
    		conn = dataSource.getConnection();
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    	return conn;
    }
    
    
    // Connection 객체를 닫는 메소드
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();           
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
    