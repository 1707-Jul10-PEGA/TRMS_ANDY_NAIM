package com.test.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.test.bean.formBean;
import com.test.bean.userBean;

public class userStuff {
	CallableStatement cs = null;
	RequestDispatcher rs = null;
	ResultSet rs1 = null;

	public userBean storeUser(String first, String last, Connection conn) {
		userBean user = null;
		try {
			cs = conn.prepareCall("{call LOAD_USER_BEANS(?,?,?,?,?,?,?,?)}");
			cs.setString(1, first);
			cs.setString(2, last);
			// ID
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			// POSITION
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			// BALANCE
			cs.registerOutParameter(5, java.sql.Types.DOUBLE);
			// THE_DEPARTMENT
			cs.registerOutParameter(6, java.sql.Types.VARCHAR);
			// SUPERVISORFIRST
			cs.registerOutParameter(7, java.sql.Types.VARCHAR);
			// SUPERVISORLAST
			cs.registerOutParameter(8, java.sql.Types.VARCHAR);
			cs.execute();

			int id = cs.getInt(3);
			String position = cs.getString(4);
			double balance = cs.getDouble(5);
			String department = cs.getString(6);
			String superFirst = cs.getString(7);
			String superLast = cs.getString(8);

			List<formBean> listForm = new ArrayList<formBean>();

			user = new userBean(id, position, first, last, balance, department, superFirst, superLast, listForm, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;

	}
	
	public List<formBean> storeForms(String first, String last, Connection conn){
		List<formBean> listForm = new ArrayList<formBean>();
		try {
			cs = conn.prepareCall("{call LOAD_FORMS_BEANS(?,?,?,?)}");
			cs.setString(1, first);
			cs.setString(2, last);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.registerOutParameter(4, java.sql.Types.REF_CURSOR);
			cs.execute();
			rs1 = (ResultSet) cs.getObject(1);
			while(rs1.next()){
				
				cs = conn.prepareCall("{call INTERPRET_FORMS(?,?,?,?)}");
				System.out.print(rs1.getString(1) + ", ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		cs = conn.prepareCall("{call LOAD_FORMS_BEANS(?,?,?,?,?,?,?,?)}");
		cs.setString(1, first);
		cs.setString(2, last);
		// ID
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		// POSITION
		cs.registerOutParameter(4, java.sql.Types.VARCHAR);
		// BALANCE
		cs.registerOutParameter(5, java.sql.Types.DOUBLE);
		// THE_DEPARTMENT
		cs.registerOutParameter(6, java.sql.Types.VARCHAR);
		// SUPERVISORFIRST
		cs.registerOutParameter(7, java.sql.Types.VARCHAR);
		// SUPERVISORLAST
		cs.registerOutParameter(8, java.sql.Types.VARCHAR);
		cs.execute();

		int id = cs.getInt(3);
		String position = cs.getString(4);
		double balance = cs.getDouble(5);
		String department = cs.getString(6);
		String superFirst = cs.getString(7);
		String superLast = cs.getString(8);



		
		
		
		
		return listForm;
		
	}
}
