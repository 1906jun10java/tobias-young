package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimp.ReimbursementDAOImp;
import com.revature.service.MyReimbursementsService;

@WebServlet("/employeeReimburse")
public class EmployeeReimbursementsServlet extends HttpServlet {
	ObjectMapper om = new ObjectMapper();
	ReimbursementDAO rdao = new ReimbursementDAOImp();
	MyReimbursementsService myReim = new MyReimbursementsService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String jsonString = "";
		HttpSession session = req.getSession();
		int employeeId = (int) session.getAttribute("employeeId");
		jsonString = myReim.getManagedEmployeeReimbursements(employeeId);
		resp.getWriter().write(jsonString);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req,resp);
	}
}
