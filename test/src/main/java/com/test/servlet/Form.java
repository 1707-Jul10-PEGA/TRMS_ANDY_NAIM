package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bean.userBean;
import com.test.utility.Validate;
import com.test.utility.formStuff;
import com.test.utility.userStuff;

/**
 * Servlet implementation class Form
 */
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Form() {
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
		formStuff form = new formStuff();
		System.out.println("Cat");
		//userBean user = (userBean) request.getAttribute("user");
		String grade = request.getParameter("GRADE");
		int trueGrade = Integer.parseInt(grade);
		String justification = request.getParameter("JUSTIFICATION");
		String date = request.getParameter("DATE_OF_EVENT");
		String location = request.getParameter("LOCATION");
		String description = request.getParameter("DESCRIPTION");
		String event = request.getParameter("EVENT_COST");
		double trueCost = Double.parseDouble(event);
		//System.out.println(user.toString());
		System.out.println(grade);
		System.out.println(justification);
		System.out.println(date);
		System.out.println(location);
		System.out.println(description);
		System.out.println(event);
		
		//HttpSession session = request.getSession();
		//userBean person = (userBean)
				System.out.println(request.getSession().getAttribute("loggedin").toString());//session.getAttribute("loggedinuser");
		//System.out.println(person.toString());
		
		form.submitForm(conn, (userBean) request.getSession().getAttribute("loggedin"), trueGrade, justification, date, location, description, trueCost);
		
		// user.getListForm().addAll(us.storeForms(first, last, conn));

		// rs = request.getRequestDispatcher("userView.html");
		rs = request.getRequestDispatcher("userhome.html");
		rs.forward(request, response);

	}

}
