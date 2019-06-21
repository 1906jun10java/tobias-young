package com.revature.friday;

import java.util.Scanner;

public class UserInputs {

	public static int getInt() {
		Scanner sc = new Scanner(System.in);
		int in1 = 0;
		boolean condition = true;
		System.out.println("Please enter the number of bracket strings:");
		while(condition) {
			try {in1 = sc.nextInt(); condition = false;}
			catch(Exception e) {
				System.out.println("Please enter an integer");
				sc.next();
			}
		}
		return in1;
	}

	public static String getBrackets() {
		boolean condition = true;
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Please enter your bracket combinations: ");
		String brackets = sc2.next();
		while(condition) {
			for(int i = 0; i < brackets.length(); i++) {
				if(brackets.charAt(i) != '('&&brackets.charAt(i) != ')' &&brackets.charAt(i) != '['&&brackets.charAt(i) != ']' && brackets.charAt(i) != '{' && brackets.charAt(i) != '}') {
					System.out.println("The string must contain only (, ), {, }, [, ]");
					sc2.next();
				}else {
					condition = false;
				}
			}
		}
		//sc2.close();
		return brackets;
	}
}