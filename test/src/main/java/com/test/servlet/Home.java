package com.test.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.bean.userBean;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
	    System.out.print("Person object " + (userBean) request.getSession().getAttribute("loggedin") + " as JSON = ");
	    String userJSON = mapper.writeValueAsString((userBean) request.getSession().getAttribute("loggedin"));
	    System.out.println(userJSON);
	    response.getWriter().write(userJSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    //File file = new File("D:/workspace-sts-3.8.4.RELEASE/test/user.json");
	    //mapper.writeValue(file, (userBean) request.getSession().getAttribute("loggedin"));
		
		ObjectMapper om = new ObjectMapper();
		System.out.println(request.getParameter("person"));
		userBean person = om.readValue(request.getParameter("person"), userBean.class);
		System.out.println(person);
		
	}

}
