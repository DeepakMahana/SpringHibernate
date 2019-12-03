package com.deepak.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJDBC {
	
	public static void main(String[] args) {
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/student_tracker?useSSL=false";
		String user = "deepak";
		String password = "deepak";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Successfull");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
