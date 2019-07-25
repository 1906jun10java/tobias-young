package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.service.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 */
	private static final long serialVersionUID = -7683535433031041472L;
	//private EmployeeDAOImp edao = new EmployeeDAOImp();
	private LoginService login;
	private ObjectMapper om = new ObjectMapper(); // used for converting Java objects to JSON

	public LoginServlet() {
		login = new LoginService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Credentials creds = new Credentials(req.getParameter("username"), req.getParameter("password"));
		Employee e = login.Login(creds);
		if (e != null) {
			session.setAttribute("employeeId", e.getEmp_id());
			session.setAttribute("username", e.getUsername());
			session.setAttribute("name", e.getEmp_name());
			session.setAttribute("managerID", e.getManager_id());
			session.setAttribute("managerStatus", login.ManagerStatus(e.getEmp_id()));
			//session.setAttribute("problem", null);
			
			Cookie managerStatus = new Cookie("sessionCookie", om.writeValueAsString(session.getAttribute("managerStatus")));
			resp.addCookie(managerStatus);
			
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
