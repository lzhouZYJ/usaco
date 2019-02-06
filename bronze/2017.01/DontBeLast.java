//package bronzeJan2017;

import java.io.*;
import java.util.*;

public class DontBeLast {
	
	public static void main(String[] args) throws Exception{
		
		Scanner in = new Scanner(new File("notlast.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeJan2017\\notlast"));
		
		//total number of logs
		int logs = in.nextInt();
		
		//array of cow names
		String[] cows = new String[]
				{"Bessie","Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
		
		//array of amount of milk for each cow
		int[] milk = new int[7];
		Arrays.fill(milk, 0);
		
		//calculates total amount of milk for each cow
		for (int i=0; i<logs; i++) {
			String name = in.next();
			int amount = in.nextInt();
			for (int n=0; n<7; n++) {
				if (name.equals(cows[n])) {
					milk[n] += amount;
				}
			}
		}
		
		/*
		for (int n:milk) {
			System.out.println(n);
		}
		*/
		
		//finding minimum amount and setting them to zero
		int min = milk[0];
		for (int i=0; i<7; i++) {
			if (milk[i]<min) {
				min=milk[i];
			}
		}
		for (int i=0; i<7; i++) {
			if (milk[i]==min) {
				milk[i]=0;
			}
		}
		
		//finding minimum other than 0
		int max = 0;
		for (int i=0; i<7; i++) {
			if (milk[i]>max) {
				max=milk[i];
			}
		}
		int min2 = max;
		for (int i=0; i<7; i++) {
			if (milk[i]!=0 && milk[i]<min2) {
				min2=milk[i];
			}
		}
		
		//finding what cows have the second min
		ArrayList<String> result = new ArrayList<String>();
		for (int i=0; i<7; i++) {
			if (milk[i]==min2) {
				result.add(cows[i]);
			}
		}
		
		//if there are multiple cows with a tie
		if (result.size()!=1) {
			for (int i=result.size()-1; i>=0; i--) {
				result.remove(i);
				//System.out.println(result.size());
			}
			result.add("Tie");
		}
		
		for (String n : result) {
			System.out.println(n);
		}
		
		PrintWriter out = new PrintWriter(new File("notlast.out"));
		for (String n : result) {
			out.println(n);
		}
		out.close();
		in.close();
		
	}

}
