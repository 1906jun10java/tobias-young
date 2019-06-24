package com.revature.minimummutations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

	static String fileName = "bank.txt";
	
	public static void addToBank(String gene) {
		try{
			FileWriter fw = new FileWriter(fileName, true);
			fw.write(gene);
			fw.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("Success");
	}
	
	public static String readFromBank(int lineNum) throws IOException {
		FileReader fr = new FileReader(fileName);
		char[] cbuf;
		fr.read(cbuf = new char[8], 8 * (lineNum - 1), 8);
		String str = new String(cbuf);
		fr.close();
		return str;
	}
	
	public static int numberMutations(String startSeq, String endSeq, String fileName) throws IOException {
		boolean c = true;
		int num = 1;
		while(c) {
			try {
				readFromBank(num);
				num++;
			} catch(Exception e) {
				c = false;
			}
		}
		String[] readIn = new String[num];
		int count = 0;
		int diff = 0;
		String midSeq = startSeq;
		for(int i = 0; i < num; i++) {
			readIn[i] = readFromBank(i+1);
			System.out.println(readIn[i]);
		}
		if (startSeq.equals(endSeq)){
			return count;
		}
		for(String str : readIn) {
			
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
