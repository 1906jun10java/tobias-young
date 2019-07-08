package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Department;

public interface DepartmentDAO {

	public abstract void createDepartment(int deptID, String deptName) throws SQLException;

	public abstract List<Department> getDepartmentList() throws SQLException;
}
