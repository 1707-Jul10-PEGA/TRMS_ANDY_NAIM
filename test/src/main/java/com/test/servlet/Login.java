package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.utility.Validate;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("////////////////////////in login////////////////////////////");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
		System.out.println("////////////////////////" + first);
		System.out.println("////////////////////////" + last);
		
		
			if(Validate.checkUser(first, last)){
				RequestDispatcher rs = request.getRequestDispatcher("userhome.html");
				rs.forward(request, response);
			} else{
				out.println("Username or Password Incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("index.html");
				rs.include(request, response);
			}
		
	}

}
