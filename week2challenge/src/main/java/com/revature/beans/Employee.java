package com.revature.beans;

public class Employee {

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeID, String firstName, String lastName, int deptID, double salary, String email) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptID = deptID;
		this.salary = salary;
		this.email = email;
	}

	private int employeeID;
	private String firstName;
	private String lastName;
	private int deptID;
	private double salary;
	private String email;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", deptID=" + deptID + ", salary=" + salary + ", email=" + email + "]";
	}
}
