package com.botree.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class StdUtil {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "Bsipl@123");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
