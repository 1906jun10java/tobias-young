package com.revature.thursday;

public class Thursday {

	public static void main(String[] args) {
		System.out.println(containsSubstring("The dot equals method saved my life", "y life"));
		System.out.println(triangle(10));
	}
	
	public static boolean containsSubstring(String str, String substr) {
		str = str.toLowerCase();
		substr = substr.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j < str.length(); j++) {
				if(str.substring(i,j+1).equals(substr)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static int triangle(int numRows) {
		if (numRows == 1)
			return 1;
		return numRows + triangle(numRows - 1);
	}
}
