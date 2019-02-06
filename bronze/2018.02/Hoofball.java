package bronzeFeb2018;

import java.util.*;
import java.io.*;

public class Hoofball {
	
	public static void main(String[] args) throws Exception {
		
		//Scanner in = new Scanner(new File("hoofball.in"));
		Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeFeb2018\\hoofball"));
		
		//number of cows
		int cows = in.nextInt();
		
		//array of positions
		int[] positions = new int[cows];
		for (int i=0; i<cows; i++) {
			positions[i]=in.nextInt();
		}
		Arrays.sort(positions);
		
		/*
		for (int n :positions) {
			System.out.println(n);
		}
		*/
		
		//whether the cow will pass the ball to the right
		boolean[] right = new boolean[cows];
		
		
		
		System.out.println("result:"+result);
		
		PrintWriter out = new PrintWriter(new File("hoofball.out"));
		out.print(result);
		out.close();
		in.close();
		
	}

}
