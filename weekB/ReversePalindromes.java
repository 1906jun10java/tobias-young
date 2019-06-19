package com.revature.strings;


public class ReversePalindromes {
	public static void main(String[] args) {
		System.out.println(reverse("letsdisplaythisbetter"));
		System.out.println(isAPalindrome("oozyratinasanitaryzoo"));
	}
	
	
	public static String reverse(String str) {
		if(isAPalindrome(str)) {
			return str;
		}
		int length = str.length();
		char[] reversal = str.toCharArray();
		for(int i = 0; i < length; i++) {
			char temp = str.charAt(i);
			reversal[i] = str.charAt(length- 1 - i);
			reversal[length - i - 1] = temp;	
		}
		return String.valueOf(reversal);
	}
	
	public static boolean isAPalindrome(String str) {
		char[] checker = str.toCharArray();
		int length = str.length();
		boolean pali = true;
		for (int i = 0; i < length; i++) {
			if(checker[i] == checker[length - 1 - i]) {
				continue;
			} else {
				pali = false;
				break;
			}
		}
		return pali;
	}
}
