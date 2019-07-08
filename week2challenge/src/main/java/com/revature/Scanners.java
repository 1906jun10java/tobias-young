package com.revature;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.beans.Employee;
import com.revature.daoimp.DepartmentDAOImp;
import com.revature.daoimp.EmployeeDAOImp;

public class Scanners {

	public static Scanner sc = new Scanner(System.in);

	public static void method(Scanner sc) {
		System.out.println("What would you like to do?");
		System.out.println("1. See Average Salaries \n2.Add a new Employee");
		int choice = 0;
		boolean con = true;
		while (con) {
			try {
				choice = sc.nextInt();
				con = false;
			} catch (InputMismatchException e) {
				System.out.println("Uh oh! That's not right, better luck next time!");
			}
			switch (choice) {
			case 1:
				try {
					DepartmentDAOImp.ddao.avgDeptSalary();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					Employee e = getEmployeeInfo(sc);
					EmployeeDAOImp.edao.createEmployee(0, e.getFirstName(), e.getLastName(), e.getDeptID(),
							e.getSalary(), e.getEmail());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Not a good choice! Oops!");
			}

		}
	}

	public static Employee getEmployeeInfo(Scanner sc) {
		int choice = 0;
		double amount = 0.0;
		boolean con = true;
		sc.nextLine();
		System.out.println("Please enter the new employee's first name");
		String firstname = sc.nextLine();
		System.out.println("Please enter the new employee's last name");
		String lastname = sc.nextLine();
		System.out.println(
				"Enter the employee's Department ID: \n1.Cobbling \n2.Servent to the Bear Monarchy \n3.Bear Research");
		while (con) {
			try {
				choice = sc.nextInt();
				con = false;
			} catch (InputMismatchException e) {
				System.out.println("Not valid, avoiding potential errors.");
			}
		}
		con = true;
		System.out.println("Please enter the employee's starting salary");
		while (con) {
			try {
				amount = sc.nextDouble();
				con = false;
			} catch (InputMismatchException e) {
				System.out.println("No valid input detected");
			}
		}
		Employee e = new Employee(0, firstname, lastname, choice, amount,
				firstname.toLowerCase() + "@ursinemonarch.com");
		return e;
	}
}
