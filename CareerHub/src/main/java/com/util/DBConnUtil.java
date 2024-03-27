package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
	
	static Connection con;
	
	public static Connection getDBConn() {
		try {
			con = DriverManager.getConnection(DBPropertyUtil.getConnectionString("careerhubdb"),"root","phoenix");
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

		return con;
	}
	
	public static void main(String[] args) {
		
		getDBConn();
	
	}

}
