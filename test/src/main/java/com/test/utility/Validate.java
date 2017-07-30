package com.test.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
	public static boolean checkUser(String first, String last) {
		boolean st = false;
		Connection conn = null;

		try {
			// ConnectionFactory.getInstance().getConnection();
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@mydbinstance.cusjmyq1pvmz.us-east-1.rds.amazonaws.com:1521:ORCL",
					"revatureWongs", "databasePoppop13");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE FIRSTNAME=? AND LASTNAME=?");

			ps.setString(1, first);
			ps.setString(2, last);
			ResultSet rs = ps.executeQuery();

			st = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return st;

	}
}
