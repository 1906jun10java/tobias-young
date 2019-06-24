package com.revature.minimummutations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

	public static String getStart(Scanner sc) {
		String in = new String();
		boolean condition = true;
		System.out.println("Please enter the starting gene sequence");
		while (condition) {
			try {
				in = sc.next();
				condition = false;
				if (in.length() != 8) {
					throw new InputMismatchException("length does not equal 8");
				}
			} catch (InputMismatchException e) {
				System.out.println("The length of a gene string must be 8");
				sc.next();
			}
			in = in.toLowerCase();
			for (int i = 0; i < in.length(); i++) {
				if (in.charAt(i) != 'a' && in.charAt(i) != 'c' && in.charAt(i) != 'g' && in.charAt(i) != 't') {
					System.out.println("The only valid characters for a gene string are A, G, T, or C");
					sc.next();
					condition = true;
					break;
				}
			}
		}
		return in.toUpperCase();
	}

	public static String getEnd(Scanner sc) {
		String in = new String();
		boolean condition = true;
		System.out.println("Please enter the end gene sequence");
		while (condition) {
			try {
				in = sc.next(); condition = false;
				if (in.length() != 8) {
					throw new InputMismatchException("length does not equal 8");
				}
			} catch (InputMismatchException e) {
				System.out.println("The length of a gene string must be 8");
				sc.next();
			}
			in = in.toLowerCase();
			for (int i = 0; i < in.length(); i++) {
				if (in.charAt(i) != 'a' && in.charAt(i) != 'c' && in.charAt(i) != 'g' && in.charAt(i) != 't') {
					System.out.println("The only valid characters for a gene string are A, G, T, or C");
					sc.next();
					condition = true;
					break;
				}
			}
		}
		return in.toUpperCase();
	}
}
