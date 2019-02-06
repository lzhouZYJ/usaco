package bronzeDec2017;

import java.io.*;
import java.util.*;

public class BovineShuffle{
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner (new File("shuffle.in"));
		//Scanner in = new Scanner (new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\shuffle"));
		int numCows = in.nextInt();
		
		//creating the order array
		int[] order = new int[numCows];
		for (int i=0; i<numCows; i++) {
			order[i]=in.nextInt()-1;
		}
		
		//reads in IDs into an array
		int[] cows = new int[numCows];
		for (int i=0; i<numCows; i++) {
			cows[i]=in.nextInt();
		}
		
		//reverse shuffles
		int[] temp = new int[numCows];
		
		for (int n = 1; n<=3; n++) {
			
			for (int i = 0; i<numCows; i++) {
				temp[i]=cows[order[i]];
			}
			cows=temp.clone();
			
		}
		
		//formatting output
		PrintWriter out = new PrintWriter(new FileWriter("shuffle.out"));
		for (int res : cows) {
			out.println(res);
		}
		out.close();
		in.close();
	}
	

}
