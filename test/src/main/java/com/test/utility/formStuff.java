package com.test.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import com.test.bean.userBean;

public class formStuff {

	public void submitForm(Connection conn, userBean user, int grade, String justification, String date,
			String location, String description, double event) {
		CallableStatement cs = null;
		RequestDispatcher rd = null;
		ResultSet rs1 = null;
		try {
			cs = conn.prepareCall("{call completeForm(?,?,?,?,?,?,?)}");
			cs.setInt(1, 100);
			cs.setInt(2, grade);
			cs.setString(3, justification);
			cs.setString(4, date);
			cs.setString(5, location);
			cs.setString(6, description);
			cs.setDouble(7, event);
			cs.execute();
			//System.out.println(user.getId() + "inSQL");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}