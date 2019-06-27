package com.revature.calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double ans = 0.0;
		Scanner sc = new Scanner(System.in);
		Double num1 = UserInput.firstNum(sc);
		char operator = UserInput.operator(sc);
		Double num2 = UserInput.secondNum(sc);
		
		switch(operator) {
		case '+': ans = Operations.add(num1, num2); break;
		case '-': ans = Operations.subtract(num1, num2); break;
		case '*': ans = Operations.multiply(num1, num2); break;
		case '/': ans = Operations.divide(num1,  num2); break;
		default: System.out.println("No valid operation found. How did you get here?"); break;
		}
		
		System.out.println(num1 + " " + operator + " " + num2 + " = " + ans);
		sc.close();
	}
}
