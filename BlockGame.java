//package bronzeDec2016;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BlockGame {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("blocks.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeDec2016\\blocks"));
		
		int cards = in.nextInt();
		
		int[] result = new int[26];
		
		String[][] words = new String[cards][2];
		for (int i=0; i<cards; i++) {
			for (int j=0; j<2; j++) {
				words[i][j] = in.next();
			}
		}
		
		for (String[] row : words) {
			int[] count = new int[26];
			Arrays.fill(count, 0);
			for (String word : row) {
				int[] temp = letter(word);
				for (int n=0; n<26; n++) {
					if (temp[n]>count[n]) {
						count[n]=temp[n];
					}
				}
			}
			for (int n=0; n<26; n++) {
				result[n] += count[n];
			}
		}
		
		
		//prints result
		for (int n : result) {
			System.out.println(n);
		}
		
		PrintWriter out = new PrintWriter(new File("blocks.out"));
		for (int n : result) {
			out.println(n);
		}
		out.close();
		in.close();
		
	}
	
	//returns the array of num of letters in a String
	public static int[] letter(String str) {
		int[] result = new int[26];
		int n = str.length();
		for (int i=0; i<n; i++) {
			char letter = str.charAt(i);
			int num = (int)letter - (int)'a';
			result[num] += 1;
		}
		return result;
	}

}
