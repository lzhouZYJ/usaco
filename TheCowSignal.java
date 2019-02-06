//package bronzeDec2016;

import java.io.*;
import java.util.*;

public class TheCowSignal {
	
	public static void main(String[] args) throws Exception {
			
			Scanner in = new Scanner(new File("cowsignal.in"));
			//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeDec2016\\cowsignal"));
			
			int m = in.nextInt();
			int n = in.nextInt();
			int k = in.nextInt();
			
			//original signal
			char[][] orig = new char[m][n];
			
			for (int i=0; i<m; i++) {
				String row = in.next();
				char[] ch = character(row);
				for (int j=0; j<n; j++) {
					orig[i][j]=ch[j];
				}
			}
			
			/*
			for (char[] cha : orig) {
				for (char c : cha) {
					System.out.print(c);
				}
				System.out.println();
			}
			*/
			
			//new signal
			char[][] changed = new char[m*k][n*k];
			
			//extend the width by k times
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					for (int c=j*k; c<j*k+k; c++) {
						changed[i][c] = orig[i][j];
					}
				}
			}
			
			/*
			for (char[] cha : changed) {
				for (char c : cha) {
					System.out.print(c);
				}
				System.out.println();
			}
			*/
			
			//extend the length by k times
			for (int i=m-1; i>=0; i--) {
				for (int c=i*k; c<i*k+k; c++) {
					changed[c]=changed[i].clone();
				}
			}
			
			//final result
			for (char[] cha : changed) {
				for (char c : cha) {
					System.out.print(c);
				}
				System.out.println();
			}
			
			PrintWriter out = new PrintWriter(new File("cowsignal.out"));
			for (char[] cha : changed) {
				for (char c : cha) {
					out.print(c);
				}
				out.println();
			}
			out.close();
			in.close();
		
			
	}
	
	public static char[] character(String str) {
		int length = str.length();
		char[] result = new char[length];
		for (int i = 0; i<length; i++) {
			result[i]=str.charAt(i);
		}
		return result;
	}

}
