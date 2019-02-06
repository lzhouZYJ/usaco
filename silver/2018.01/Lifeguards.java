//package silverJan2018;

import java.io.*;
import java.util.*;

public class Lifeguards {

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new FileReader("lifeguards.in"));
		//BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\USACO\\src\\silverJan2018\\lifeguards"));
		
		//keeps track of the index of the cows currently on duty
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		//total num of cows
		int n = Integer.parseInt(in.readLine());
		
		//list of all the start/end times with the respective cow
		state[] list = new state[2*n];		
		for(int i=0; i<n; i++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			list[i*2] = new state(start, i);
			list[i*2+1] = new state(end, i);
		}
		Arrays.sort(list);
		
		int totalTime = 0;//total amount of time time the cows can cover
		int lastTime = 0;//the last point in time considered
		int[] alone = new int[n]; //records the time each cow is on duty alone
		
		for(int i=0; i<2*n; i++) {
			state current = list[i];
			if(!set.isEmpty()) {
				totalTime += (current.time-lastTime);
			}
			if(set.size()==1) {
				alone[set.first()] += (current.time-lastTime);
			}
			if(set.contains(current.index)) {
				set.remove(current.index);
			}
			else {
				set.add(current.index);
			}
			lastTime = current.time;
		}
		
		int result = 0;
		/*
		for(int t:alone) {
			System.out.print(t+"\t");
		}
		*/
		for(int t:alone) {
			result = Math.max(result, totalTime-t);
		}
		System.out.println(result);
		//System.out.println("total time:"+totalTime);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		out.println(result);
		out.close();
		in.close();
		
	}
	
}

class state implements Comparable<state>{
	
	public int time;
	public int index;
	
	public state(int t, int i) {
		time=t;
		index=i;
	}
	
	public int compareTo(state other) {
		return time-other.time;
	}
	
}
