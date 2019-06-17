package com.revature.fizzbuzzadvanced;

import java.util.Scanner;

public class UserInput {
	static int length;
	public static int getMin() {
		boolean condition = true;
		int minimum = 0;
		System.out.println("Please enter starting value (Integer):");
		Scanner sc = new Scanner(System.in);
		while(condition) {
			try {minimum = sc.nextInt(); condition = false;}
			catch(Exception e) {
				System.out.println("Incorrect input. Please enter an (Integer):");
				sc.next();
			}
		}
		return minimum;
	}
	
	public static int getMax() {
		boolean condition = true;
		int maximum = 0;
		System.out.println("Please enter ending value (Integer)");
		Scanner sc2 = new Scanner(System.in);
		while(condition) {
			try {maximum = sc2.nextInt(); condition = false;}
			catch(Exception e) {
				System.out.println("Incorrect input please enter an (Integer):");
				sc2.next();
			}
		}
		return maximum;
	}
	
	public static int[] getMods() {
		boolean condition = true;
		int moduliCount = 0;
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Please enter the number of moduli (Integer):");
		while(condition) {
			try {moduliCount = sc3.nextInt(); condition = false;}
			catch(Exception e) {
				System.out.println("Must be an (Integer) number:");
				sc3.next();
			}
		}
		Scanner sc5 = new Scanner(System.in);
		length = moduliCount;
		int[] numberString = new int[length];
		System.out.println("Enter " + length + " (Integer) values:");
		for(int i = 0; i < length; i++) {
			//while(condition) {
				//try {
			numberString[i] = sc5.nextInt(); condition = false;//}
				//catch(Exception e) {
					//System.out.println("Moduli must be (Integer) values:");
					//sc5.next();
				//}
			}return numberString;
		}
		
	
	public static String[] getWords() {
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Enter a word for each Moduli:");
		String[] words = new String[length];
		for(int i = 0; i < length; i++) {
			words[i] = sc4.next();
		}
		sc4.close();
		return words;
	}
}
