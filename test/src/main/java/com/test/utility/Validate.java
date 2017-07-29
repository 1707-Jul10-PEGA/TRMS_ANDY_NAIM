package com.test.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.internal.OracleTypes;

public class Validate {
	public static boolean checkUser(String first, String last) {
		boolean st = false;

		try {
			System.out.println("////////////////////////in validate////////////////////////////");
			System.out.println("////////////////////////" + first);
			System.out.println("////////////////////////" + last);
			// Connection conn =
			// ConnectionFactory.getInstance().getConnection();
			Connection conn = DriverManager.getConnection(
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
		System.out.println("//////////////////////////////////" + st);
		return st;

	}
}
