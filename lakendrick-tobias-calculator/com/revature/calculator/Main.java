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
			break;	
		case 's': ans = Operators.subtraction(in1, in2);
			break;
		case 'm': ans = Operators.multiplication(in1, in2);
			break;
		case 'd': ans = Operators.division(in1, in2);
			break;
		default: System.out.println("unknown error");
		}
		
		System.out.println("the answer is: " + ans);
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
		char in1 = 'z';
		System.out.println("Enter 'a' for Addition \nEnter 's' for Subtraction \nEnter 'm' for Multiplication \nEnter 'd' for Division");
		while(condition) {
			try{in1 = sc2.next().charAt(0);}
			catch(Exception e) {
				System.out.println("Invalid input. 'a' for Addition, 's' for Subtraction, 'm' for Multiplication, 'd' for Division");
				sc2.next();
			}
			switch(in1) {
			case 'a':condition = false;
				break;
			case 's':condition = false; 
				break;
			case 'm':condition = false; 
				break;
			case 'd':condition = false; 
				break;
			//default: condition = true;
			}
		}
		return in1;
	}		
}

