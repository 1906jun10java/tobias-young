package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.connections.ConnFactory;
import com.revature.dao.EmployeeDAO;

public class EmployeeDAOImp implements EmployeeDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Employee getEmployeeInfo(int emp_id) throws SQLException {
		Employee e = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, emp_id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			e = new Employee(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(5));
		}
		return e;
	}

	@Override
	public void updateEmployeeInfo(int emp_id, String name, int manager_id, String username, String password)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE EMPLOYEE SET EMP_NAME = ?,EMP_MANAGER = ?,USERNAME = ?,PASSWRD = ? WHERE EMP_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, manager_id);
		ps.setString(3, username);
		ps.setString(4, password);
		ps.setInt(5, emp_id);
		ps.executeUpdate();
	}

	@Override
	public void createEmployee(int manager_id, String name, String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO EMPLOYEE VALUES(SQ_EMPLOYEE_ID.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, manager_id);
		ps.setString(3, username);
		ps.setString(4, password);
		ps.executeUpdate();
	}
	
	public boolean isManager(int emp_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_MANAGER = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, emp_id);
		ResultSet rs = ps.executeQuery();
		return rs.first();
	}

	
	
	public List<Employee> getEmployeeList() throws SQLException {
		List<Employee> empList = new ArrayList<>();
		Employee e = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			e = new Employee(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(5));
			empList.add(e);
		}
		return empList;
	}


}
