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
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

@WebServlet(urlPatterns= {"/registration"},loadOnStartup=1)
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PayrollServices services;
	@Override
	public void init() throws ServletException {
		services=new PayrollServicesImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String emailId=request.getParameter("emailId");
		String department=request.getParameter("department");
		String designation=request.getParameter("designation");
		String pancard=request.getParameter("pancard");
		int yearlyInvestmentUnder80C=Integer.parseInt(request.getParameter("yearlyInvestmentUnder80C"));
		int basicSalary=Integer.parseInt(request.getParameter("basicSalary"));
		int epf=Integer.parseInt(request.getParameter("epf"));
		int companyPf=Integer.parseInt(request.getParameter("companyPf"));
		int accountNumber=Integer.parseInt(request.getParameter("accountNumber"));
		String bankName=request.getParameter("bankName");
		String ifscCode=request.getParameter("ifscCode");
		
		Associate associate = new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode));
		int associateId=services.acceptAssociateDetails(associate);
		associate = new Associate(associateId, yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode));
		
		HttpSession session = request.getSession();
		session.setAttribute("associate", associate);
		RequestDispatcher dispatcher=request.getRequestDispatcher("registrationSuccessPage.jsp");
		dispatcher.forward(request, response);
	}

}


