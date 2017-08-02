package com.test.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.test.bean.formBean;
import com.test.bean.tester;
import com.test.bean.userBean;
import com.test.utility.Validate;
import com.test.utility.userStuff;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cs = null;
		RequestDispatcher rs = null;
		ResultSet rs1 = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@mydbinstance.cusjmyq1pvmz.us-east-1.rds.amazonaws.com:1521:ORCL",
					"revatureWongs", "databasePoppop13");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");

		if (Validate.checkUser(first, last)) {
			//save user and their forms onto the session here
			userStuff us = new userStuff();
			userBean user = us.storeUser(first, last, conn);
			request.getSession().setAttribute("loggedin",user);
			
			ObjectMapper mapper = new ObjectMapper();
		    System.out.print("Person object " + user + " as JSON = ");
		    String userJSON = mapper.writeValueAsString(user);
		    System.out.println(userJSON);
		    File file = new File("D:/workspace-sts-3.8.4.RELEASE/test/user.txt");
		    mapper.writeValue(file, user);
		    out.println(userJSON);
		    out.println(" ");
		    
		    
			
			rs = request.getRequestDispatcher("userhome.html");
			//rs.forward(request, response);
			rs.include(request, response);
		} else {
			out.println("Username or Password Incorrect");
			rs = request.getRequestDispatcher("index.html");
			rs.include(request, response);
		}

	}

}
