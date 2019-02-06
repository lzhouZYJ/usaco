package silverFeb2018;

import java.io.*;
import java.util.*;

public class Teleportation {
	
	public static void main(String[] args) throws Exception {
		
		//BufferedReader in = new BufferedReader(new FileReader("teleport.in"));
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\USACO\\src\\silverFeb2018\\teleport"));
		String str = in.readLine();
		int n = Integer.parseInt(str);
		
		ArrayList<event> list = new ArrayList<event>();
		
		//without teleportation
		long cur = 0;
		
		for(int i=0; i<n; i++) {
			StringTokenizer row = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(row.nextToken());
			int b = Integer.parseInt(row.nextToken());
			
			cur += Math.abs(a-b);
			
			int delta = Math.abs(a-b)-Math.abs(a);
			
			//only would use teleportation is delta > 0
			if(delta>0) {
				
				//starting from b-delta, slope is -1
				list.add(new event(b-delta, -1));
				
				//starting from b, slope is 1 (needs to cancel out the -1)
				list.add(new event(b, 2));
				
				//starting from b+delta, slope is 0 (needs to cancel out the +1)
				list.add(new event(b+delta, -1));
				
			}			
			
		}
		
		long min = cur;
		
		if(list.size()!=0) {
			//sort based on y values - y values are second positions of teleport
			Collections.sort(list);
			
			list = clean(list);
			
			long delta = list.get(0).delta;
			
			//go through the list
			for(int i=1; i<list.size(); i++) {
				int yDist = list.get(i).y-list.get(i-1).y;
				cur += yDist * delta;
				min = Math.min(cur, min);
				delta += list.get(i).delta;		//add onto previous delta
			}
		}
		
		System.out.println(min);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		out.println(min);
		out.close();
		in.close();
		
		
	}
	
	//combine slopes with same y values
	public static ArrayList<event> clean(ArrayList<event> list){
		
		ArrayList<event> result = new ArrayList<event>();
		int i = 0;
		int index = 0;
		
		while(i<list.size() && index<list.size()) {
			int sum = 0;
			while(i<list.size() && list.get(index).y == list.get(i).y) {
				sum += list.get(i).delta;
				i++;
			}
			result.add(new event(list.get(index).y, sum));
			index=i;
		}
		
		return result;
		
	}

}

class event implements Comparable<event> {
	
	int y;
	int delta;
	
	public event(int a, int b) {
		y=a;
		delta=b;
	}
	
	public int compareTo(event other) {
		return y - other.y;
	}
	
}