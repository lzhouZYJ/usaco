//package silverDec2017;

import java.io.*;
import java.util.*;

public class MilkMeasurement {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new FileReader("measurement.in"));
		//BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\USACO\\src\\silverDec2017\\measurement"));
		
		StringTokenizer line = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(line.nextToken());
		
		TreeMap<Integer, Integer> tm2 = new TreeMap<Integer, Integer>();
		TreeMap<Integer, cow> tm1 = new TreeMap<Integer, cow>();
		
		int id2 = 1; //the shortened IDs for cows
		
		//organizing input
		for(int i=0; i<n; i++) {
			line = new StringTokenizer(in.readLine());
			int day = Integer.parseInt(line.nextToken());
			int id = Integer.parseInt(line.nextToken());
			int delta = Integer.parseInt(line.nextToken());
			
			//tm2 - associates given ID with new shortened ID (id2)
			if(!tm2.containsKey(id)) {
				tm2.put(id, id2);
				id = id2;	//updates id to the new shortened id
			}
			else {
				id = tm2.get(id);	//updates id to the new shortened id
			}
			
			cow temp = new cow(id, delta);
			//tm1 - associates each day with a cow log
			tm1.put(day, temp);
			
			id2++;
		}
		
		//milk - index=id2; element=amount of milk
		int[] milk = new int[id2+1];	//id2 now represents total number of cows concerned with
		
		//tmmilk - amount of milk with # of cows at that amount
		TreeMap<Integer, Integer> tmmilk = new TreeMap<Integer, Integer>();
		tmmilk.put(0, id2);	//rn all cows produce 0 
		
		int max = 0;
		int res = 0;
		int prev, cur;
		
		int index = tm1.firstKey();
		boolean reachEnd = false;
		while(!reachEnd) {
			//System.out.println("index:"+index);
			cow thiscow = tm1.get(index);
			prev = milk[thiscow.cowId];
			cur = milk[thiscow.cowId]+thiscow.delta;
			milk[thiscow.cowId] = cur;
			
			/*
			for(int a:milk) {
				System.out.println(a);
			}
			*/
			
			//remove old value
			int oldnum = tmmilk.get(prev);
			if(oldnum>1) tmmilk.put(prev, oldnum-1);
			else tmmilk.remove(prev);
			
			//place new value
			if(tmmilk.containsKey(cur)) {
				tmmilk.put(cur, tmmilk.get(cur)+1);
			}
			else tmmilk.put(cur, 1);
			
			int newmax = tmmilk.lastKey();//new max amount
			
			//not best before; now unique/tie best
			if(prev<max&&cur>=max) {
				res++;
			}
			//tie for best before; now unique best
			if(prev==max&&oldnum>1&&cur>max) {
				res++;
			}
			//tie/unique for best before; now not best
			if(prev==max&&cur<newmax) {
				res++;
			}
			//unique best before; now tie best
			if(prev==max&&cur==newmax&&tmmilk.get(cur)>1) {
				res++;
			}	
			
			max=newmax;

			if(tm1.higherKey(index)==null) reachEnd = true;
			else index=tm1.higherKey(index);
		}
		
		System.out.println(res);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		out.println(res);
		out.close();
		in.close();
		
	}

}

//saves the cow with ID and delta on a certain day
class cow implements Comparable<cow>{
	
	public int cowId;
	public int delta;
	
	public cow(int c, int a) {
		cowId = c;
		delta = a;
	}
	
	public void changeID(int newID) {
		cowId = newID;
	}
	
	public int compareTo(cow other) {
		return delta-other.delta;
	}
	
}
