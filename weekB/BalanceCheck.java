package com.revature.friday;

public class BalanceCheck {

	public static boolean BalanceCheckingMethod(String str) {
		
		int measure = str.length();
		boolean is = true;
		
		for (int i = 0; i < measure/2; i++) {
			switch(str.charAt(i)) {
			case '(': if(str.charAt(measure-1-i) == ')') {is = true; break;}
			case'[': if(str.charAt(measure - 1 -i) == ']') {is = true; break;}
			case '{': if(str.charAt(measure - 1 -i) == '}') {is = true; break;}
			default: is = false; break;
			}
		}
		return is;
	}
	
}
