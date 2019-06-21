package com.revature.friday;

import java.util.Arrays;

public class BalancedBrackets {

	public static void main(String[] args) {
		
		int num = UserInputs.getInt();
		String[] strings = new String[num];
		boolean[] isIt = new boolean[num];
		for(int i = 0; i < num; i++) {
			strings[i] = UserInputs.getBrackets();
		}
		for(int i = 0; i < strings.length; i++) {
			isIt[i] = BalanceCheck.BalanceCheckingMethod(strings[i]);
		}
		System.out.println(Arrays.toString(isIt));
		
	}
}
