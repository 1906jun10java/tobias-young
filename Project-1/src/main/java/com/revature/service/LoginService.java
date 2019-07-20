package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.daoimp.EmployeeDAOImp;

public class LoginService {

	private EmployeeDAOImp edao = new EmployeeDAOImp();

	public Employee Login(String username, String password) {
		List<Employee> eList = null;
		try {
			eList = edao.getEmployeeList();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Employee e = null;
		for (Employee emp : eList) {
			if (username == emp.getUsername()) {
				e = emp;
			}
		}
		if (e.getPassword() == password) {
			return e;
		} else {
			return null;
		}
	}
}
