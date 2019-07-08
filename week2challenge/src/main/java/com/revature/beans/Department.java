package com.revature.beans;

public class Department {

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int deptID, String deptName) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
	}
	private int deptID;
	private String deptName;
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", deptName=" + deptName + "]";
	}
}
