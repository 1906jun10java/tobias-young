package com.revature.fizzbuzzadvanced;

import com.revature.fizzbuzzadvanced.UserInput;
public class Main {

	public static void main(String[] args) {
		FizzBuzz runner = new FizzBuzz();
		//runner.fizzBuzzBasic();
		int minimum = UserInput.getMin();
		int maximum = UserInput.getMax();
		int[] nums = UserInput.getMods();
		String[] terms = UserInput.getWords();
		runner.fizzBuzzAdvanced(maximum, minimum, nums, terms);
	}
}
