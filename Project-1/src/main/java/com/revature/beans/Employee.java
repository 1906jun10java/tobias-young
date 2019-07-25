package com.revature.beans;

public class Employee {

	public Employee() {
		super();
	}

	public Employee(int emp_id, int manager_id, String emp_name, String username, String password) {
		super();
		this.emp_id = emp_id;
		this.manager_id = manager_id;
		this.emp_name = emp_name;
		this.username = username;
		this.password = password;
	}

	private Integer emp_id;
	private Integer manager_id;
	private String emp_name;
	private String username;
	private String password;

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", manager_id=" + manager_id + ", emp_name=" + emp_name + ", username="
				+ username + ", password=" + password + "]";
	}
}
