package com.revature.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

	public static Double firstNum(Scanner sc) {
		boolean condition = true;
		Double num = 0.0;
		System.out.println("Please enter the first number in your calculation.");
		while(condition) {
			try {num = sc.nextDouble(); condition = false;}
			catch(InputMismatchException e) {
				System.out.println("Incorrect input, please try again");
				sc.next();
			}
		}
		return num;
	}
	
	public static char operator(Scanner sc) {
		boolean condition = true;
		char operator = ' ';
		System.out.println("Please enter the operator (+, -, *, or /)");
		while (condition) {
			try {
				operator = sc.next().charAt(0);
				if(operator != '+' && operator != '-' && operator != '*' && operator != '/') {
					System.out.println("Invalid entry. Please enter +, -, *, or /");
					throw new InputMismatchException();
				} else {
					condition = false;
				}
			} catch(InputMismatchException e) {
			
			}
		}
		return operator;
	}
	
	public static Double secondNum(Scanner sc) {
		boolean condition = true;
		Double num = 0.0;
		System.out.println("Please enter the second number in your calculation.");
		while(condition) {
			try {num = sc.nextDouble(); condition = false;}
			catch(InputMismatchException e) {
				System.out.println("Incorrect input, please try again");
				sc.next();
			}
		}
		return num;
	}
}
