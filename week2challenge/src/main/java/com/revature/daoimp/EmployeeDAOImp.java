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

	public static List<Employee> empList = new ArrayList<>();
	public static ConnFactory cf = ConnFactory.getInstance();
	public static EmployeeDAOImp edao = new EmployeeDAOImp();

	@Override
	public List<Employee> getEmployeeList() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Employee e = null;
		while (rs.next()) {
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),
					rs.getString(6));
			empList.add(e);
		}
		return empList;
	}

	@Override
	public void createEmployee(int empID, String firstname, String lastname, int deptID, double salary, String empEmail)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO EMPLOYEE VALUES(SQ_EMP.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstname);
		ps.setString(2, lastname);
		ps.setInt(3, deptID);
		ps.setDouble(4, salary);
		ps.setString(5, empEmail);
		ps.executeUpdate();

	}

}
