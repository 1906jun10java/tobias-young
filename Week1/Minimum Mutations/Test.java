package com.revature.minimummutations;

import java.io.IOException;

public class Test {

	public static int numberMutationsTest(String startSeq, String endSeq, String[] fileName) throws IOException {
		boolean c = true;
		int num = 1;
		/*while(c) {
			try {
				readFromBank(num);
				num++;
			} catch(Exception e) {
				c = false;
			}
		}*/
		int count = 0;
		int diff = 0;
		String midSeq = startSeq;
		/*for(int i = 0; i < num; i++) {
			readIn[i] = fileName[i];
			System.out.println(readIn[i]);
		}*/
		if (startSeq.equals(endSeq)){
			return count;
		}
		for(String str : fileName) {
			
			for(int i = 0; i < str.length(); i++) {
				if(midSeq.charAt(i) != str.charAt(i)) {
					diff = diff + 1;
				}
			}
			if (diff == 1) {
				midSeq = str;
				count = count + 1;
				diff = 0;
			}
			else {
				diff = 0;
			}
		}
		if(midSeq.equals(endSeq)) {
			return count;
		} else {
			return -1;
		}
		
	
	}
	
	
}
