package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.service.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7683535433031041472L;
	private LoginService login;
	// private ObjectMapper om; // used for converting Java objects to JSON

	public LoginServlet() {
		login = new LoginService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee emp = null;
		HttpSession session = req.getSession();
		emp = login.Login(req.getParameter("username"), req.getParameter("password"));
		if(emp != null) {
			session.setAttribute("emp_ID", emp.getEmp_id());
			session.setAttribute("name", emp.getEmp_name());
			resp.sendRedirect("menu");
		} else {
			session.setAttribute("problem", "invalid credentials");
			resp.sendRedirect("login");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}

}
