package com.tjoeun.DBTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionTest2 {

	public static void main(String[] args) {

		Connection conn = DBUtil.getMySQLConnection();
		System.out.println("연결성공: " + conn);
		DBUtil.close(conn);
	}

}
