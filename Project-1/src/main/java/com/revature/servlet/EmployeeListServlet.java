package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.EmployeeService;

@WebServlet("/employeeList")
public class EmployeeListServlet extends HttpServlet {

	EmployeeService empServ = new EmployeeService();
	ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String jsonString = om.writeValueAsString(empServ.employeeListString());
		resp.getWriter().write(jsonString);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req,resp);
	}
}
