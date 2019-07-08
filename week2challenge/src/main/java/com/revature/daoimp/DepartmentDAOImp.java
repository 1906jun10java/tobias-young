package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Department;
import com.revature.connections.ConnFactory;
import com.revature.dao.DepartmentDAO;

public class DepartmentDAOImp implements DepartmentDAO {

	public static List<Department> deptList = new ArrayList<>();
	public static ConnFactory cf = ConnFactory.getInstance();
	public static DepartmentDAOImp ddao = new DepartmentDAOImp();

	public List<Department> getDepartmentList() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM DEPARTMENT";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Department d = null;
		while (rs.next()) {
			d = new Department(rs.getInt(1), rs.getString(2));
			deptList.add(d);
		}
		return deptList;
	}

	@Override
	public void createDepartment(int deptID, String deptName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO EMPLOYEE VALUES(SQ_DEPT.NEXTVAL, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, deptName);
		ps.executeUpdate();

	}
	
	public void avgDeptSalary() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT DEPARTMENT_NAME, AVG(SALARY) FROM DEPARTMENT FULL JOIN EMPLOYEE ON DEPARTMENT.DEPARTMENT_ID = EMPLOYEE.DEPARTMENT_ID group by DEPARTMENT_NAME";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("The average salary for employees in the " + rs.getString(1) +" department is "+ rs.getDouble(2));
		}
	}
}
