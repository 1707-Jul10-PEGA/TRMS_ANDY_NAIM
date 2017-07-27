package com.ncaw.TRMS.driver;
import java.sql.Connection;
import java.sql.SQLException;

import com.ncaw.TRMS.utility.*;
public class driver 
{
	public static void main(String[]args) 
	{
		System.out.println("hello");
		
		Connection conn = ConnectionFactory.getConnection();
		//try {
		//	conn.isClosed();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace(); 
	try {
			System.out.println(conn.isClosed());
		} catch (SQLException e) 
			{
				e.printStackTrace();
			} 
	}
}


