package com.revature.strings;

import java.util.Arrays;

public class ReversePalindromes {
	public static void main(String[] args) {
		System.out.println(recursiveReverse("also not a palindrome"));
		System.out.println(recursiveIsAPalindrome("doninemeninterpretninemeninod"));
	}

	public static boolean recursiveIsAPalindrome(String str) {
		int length = str.length();
		// base case
		if (length == 1 || length == 0) {
			return true;
		}
		if (str.charAt(0) == str.charAt(length - 1)) {
			return recursiveIsAPalindrome(str.substring(1, length - 1));
		} else
			return false;
	}

	public static String recursiveReverse(String str) {
		int length = str.length();
		// base case
		if (str.length() == 1) {
			return str;
		}

		return str.charAt(str.length() - 1)
				+ recursiveReverse(str.substring(0, length -1));
	}

	public static String reverse(String str) {
		if (isAPalindrome(str)) {
			return str + " Palindrome";
		}
		int length = str.length();
		char[] reversal = str.toCharArray();
		for (int i = 0; i < length; i++) {
			char temp = str.charAt(i);
			reversal[i] = str.charAt(length - 1 - i);
			reversal[length - i - 1] = temp;
		}
		return String.valueOf(reversal);
	}

	public static boolean isAPalindrome(String str) {
		char[] checker = str.toCharArray();
		int length = str.length();
		boolean pali = true;
		for (int i = 0; i < length; i++) {
			if (checker[i] == checker[length - 1 - i]) {
				continue;
			} else {
				pali = false;
				break;
			}
		}
		return pali;
	}
}
