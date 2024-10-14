package com.web_app_5.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web_app_5.model.DAOServiceimpl;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/saveReg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
	HttpSession session = request.getSession(false);
	if(session.getAttribute("email")!=null) {
			String name=request.getParameter("firstname");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			DAOServiceimpl dao=new DAOServiceimpl();
			dao.connectDB();
			dao.createRegistration(name, email, mobile);
			
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
			rs.forward(request, response);
	}
	else {
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request, response);
		
	}
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
	rs.forward(request, response);
}
	
	}

}
