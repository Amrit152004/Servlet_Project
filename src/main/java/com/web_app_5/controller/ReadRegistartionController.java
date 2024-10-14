package com.web_app_5.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web_app_5.model.DAOServiceimpl;

/**
 * Servlet implementation class ReadRegistartionController
 */
@WebServlet("/fetchReg")
public class ReadRegistartionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    public ReadRegistartionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if(session.getAttribute("email")!=null) {
		DAOServiceimpl service =new DAOServiceimpl();
		service.connectDB();
		ResultSet rs = service.listAllReg();
		request.setAttribute("result", rs);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
		rd.forward(request, response);
		}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
