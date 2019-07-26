package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	public abstract Employee getEmployeeInfo(int emp_id) throws SQLException;

	public abstract void updateEmployeeInfo(int emp_id, String name, int manager_id, String username, String password) throws SQLException;

	public abstract void createEmployee(int manager_id, String name, String username, String password) throws SQLException;
	
	public abstract boolean isManager(int emp_id) throws SQLException;
	
	public abstract List<Employee> getEmployeeList() throws SQLException;
}
