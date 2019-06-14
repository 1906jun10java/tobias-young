package com.revature.calculator;

public class Operators {

	public static double addition(double num1, double num2) {
			return num1 + num2;
	}
	
	public static double subtraction(double num1, double num2) {
		return num1 - num2;
	}
	
	public static double multiplication(double num1, double num2) {
		return num1 * num2;
	}
	
	public static double division(double num1, double num2) {
		if(num2 == 0) {
			System.out.println("Cannot Divide by 0.");
			return 0;
		}
		else
			return num1/num2;
	}
}
