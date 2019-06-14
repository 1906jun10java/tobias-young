package com.revature.calculator;

import java.util.Scanner;

import com.revature.calculator.Operators;

public class Main {
	public static void main(String[] arg) {
		double in1;
		double in2;
		double ans = 0;
		char op;
		
		in1 = firstInput();
		op = operatorChoice();
		in2 = secondInput();
		switch(op) {
		case 'a': ans = Operators.addition(in1, in2);
		case 's': ans = Operators.subtraction(in1, in2);
		case 'm': ans = Operators.multiplication(in1, in2);
		case 'd': ans = Operators.division(in1, in2);
		default: System.out.println("unknown error");
		
		System.out.println(ans);
		}
	}


	public static double firstInput() {
		Scanner sc = new Scanner(System.in);
		boolean condition = true;
		double in1 = 0;
		System.out.println("Please enter first value:");
		while(condition) {
			try { in1 = sc.nextDouble(); condition = false;}
			catch(Exception e) {
				System.out.println("Please enter a numeric value.");
				sc.next();
			}
		}
		sc.close();
		return in1;
	}
	
	public static double secondInput() {
		Scanner sc1 = new Scanner(System.in);
		boolean condition = true;
		double in1 = 0;
		System.out.println("Please enter second value:");
		while(condition) {
			try { in1 = sc1.nextDouble(); condition = false;}
			catch(Exception e) {
				System.out.println("Please enter a numeric value.");
				sc1.next();
			}
		}
		sc1.close();
		return in1;
	}
	
	public static char operatorChoice() {
		Scanner sc2 = new Scanner(System.in);
		boolean condition = true;
		String in1 = "z";
		System.out.println("Enter 'a' for Addition");
		System.out.println("Enter 's' for Subtraction");
		System.out.println("Enter 'm' for Multiplication");
		System.out.println("Enter 'd' for Division");
		while(condition) {
			in1 = sc2.next();
			switch(in1.charAt(0)) {
			case 'a':break;
			case 's':break;
			case 'm':break;
			case 'd':break;
			default: continue;
			}
		}
		sc2.close();
		return in1.charAt(0);
	}		
}

