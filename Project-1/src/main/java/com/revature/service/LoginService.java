package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.daoimp.EmployeeDAOImp;

public class LoginService {

	private EmployeeDAOImp edao = new EmployeeDAOImp();
	private List<Employee> eList = null;

	public Employee Login(String username, String password) {
		
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
	
	public Employee Login(Credentials c) {
		try {
			eList = edao.getEmployeeList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Employee emp : eList) {
			if(c.getUsername().equals(emp.getUsername()) && c.getPassword().equals(emp.getPassword())) {
				return emp;
			}
		}
		return null;
	}
	
	public boolean ManagerStatus(int id) {
		boolean status = false;
		try {
			status = edao.isManager(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
