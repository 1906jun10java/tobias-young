package com.revature.fizzbuzzadvanced;

import java.util.Arrays;

public class FizzBuzz {

	public void fizzBuzzBasic() {
		for(int i=1; i <= 100; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			}
			else if(i % 3 == 0) {
				System.out.println("Fizz");
			}
			else if(i % 5 == 0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}
	
	public void fizzBuzzAdvanced(int m, int n, int[] numbers, String[] terms) {
		boolean[] booleans= new boolean[numbers.length];
		String combo = new String();
		int count = 0;
		Arrays.fill(booleans, false);
		for(int i = n; i <= m; i++) {
			for(int i2 = 0; i2 < numbers.length; i2++) {
				if(i % numbers[i2] == 0) {
					booleans[i2] = true;
				}
			}
			for(int value = 0; value < booleans.length; value++) {
				if (booleans[value]) {
					combo = combo + terms[value];
					count ++;
				}
			}
			if (count != 0) {System.out.println(combo); count = 0;}
			else {System.out.println(i);}
			Arrays.fill(booleans, false);
			combo = "";
		}
	}
}