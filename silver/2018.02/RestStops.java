//package silverFeb2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class RestStops {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new FileReader("reststops.in"));
		//BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\USACO\\src\\silverFeb2018\\reststops"));
		
		StringTokenizer str = new StringTokenizer(in.readLine());
		int length = Integer.parseInt(str.nextToken());
		int numrest = Integer.parseInt(str.nextToken());
		int rF = Integer.parseInt(str.nextToken());
		int rB = Integer.parseInt(str.nextToken());
		
		int diff = rF-rB;
		
		ArrayList<reststop> list = new ArrayList<reststop>();
		
		for(int i=0; i<numrest; i++) {
			str = new StringTokenizer(in.readLine());
			int loc = Integer.parseInt(str.nextToken());
			int tasty = Integer.parseInt(str.nextToken());
			list.add(new reststop(loc, tasty));
		}
		
		//sort based on tastiness decreasing order
		Collections.sort(list);
		
		int index = 0;
		long delta = list.get(0).loc;
		long result = delta * diff * list.get(0).tasty;
		long currloc = list.get(0).loc;
		long prevloc = currloc;
		while(index<list.size()-1) {
			if(currloc>list.get(index+1).loc) {
				list.remove(index+1);
			}
			else {
				index++;
				prevloc = currloc;
				currloc = list.get(index).loc;
				delta = currloc-prevloc;
				result += delta*diff*list.get(index).tasty;
			}
		}
		
		System.out.println("result:"+result);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		out.println(result);
		out.close();
		in.close();
		
	}

}

class reststop implements Comparable<reststop>{
	
	int loc;
	int tasty;
	
	public reststop(int l, int t) {
		loc = l;
		tasty = t;
	}
	
	public int compareTo(reststop other) {
		return other.tasty-tasty;
	}
	
}
