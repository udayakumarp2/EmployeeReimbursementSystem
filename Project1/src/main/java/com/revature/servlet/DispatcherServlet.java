package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.UserDelegate;

public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 922064885233890820L;

	private ReimbursementDelegate rc = new ReimbursementDelegate();
	private UserDelegate uc = new UserDelegate();
	
	// delegates get requests to their controllers
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
	
		// suggested troubleshooting 
		System.out.println(actualURL);
		
		if(actualURL.startsWith("/Static")) {
			super.doGet(request, response);
			return;
		}
		else if(actualURL.startsWith("/reimbursements")) {
			rc.processGet(request, response);
		}
		else if(actualURL.startsWith("/users/")){
			uc.processGet(request, response);
		}
	}
	
	// delegates post requests to their controllers
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(actualURL.startsWith("/users/")) {
			uc.processPost(request, response);
		}
		else if(actualURL.startsWith("/reimbursements")) {
			rc.processPost(request,response);
		}
	}
}