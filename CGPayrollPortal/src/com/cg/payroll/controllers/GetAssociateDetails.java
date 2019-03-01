package com.cg.payroll.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.payroll.beans.Associate;

@WebServlet("/getAssociate")
public class GetAssociateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			Associate associate = (Associate)session.getAttribute("associate");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("getAssociateSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("indexPage.jsp");
		}
	}
}





//Associate getAssociateDetails(int associateId)