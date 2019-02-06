//package silverDec2017;

import java.io.*;
import java.util.*;

public class BovineShuffle {
		
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new FileReader("shuffle.in"));
		//BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\USACO\\src\\silverDec2017\\shuffle"));
		
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer str = new StringTokenizer(in.readLine());
		int[] shuffle = new int[n];
		int[] after = new int[n];
		for(int i=0; i<n; i++) {
			shuffle[i] = Integer.parseInt(str.nextToken())-1;
			after[shuffle[i]]++;
		}
		
		int res = n;
		
		ArrayList<Integer> empty = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			if(after[i]==0) {
				empty.add(i);
				res--;
			}
		}
		
		while(!empty.isEmpty()) {
			int i = empty.remove(0);
			if(--after[shuffle[i]]==0) {
				empty.add(shuffle[i]);
				res--;
			}
		}
		
		System.out.println(res);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		out.println(res);
		out.close();
		in.close();
		
		
	}

}
