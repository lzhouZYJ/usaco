//package silverJan2018;

import java.io.*;
import java.util.*;

public class MooTube {
	
	public static ArrayList[] edges;
	public static int numnode;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new FileReader("mootube.in"));
		//BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\USACO\\src\\silverJan2018\\mootube"));
		
		StringTokenizer str = new StringTokenizer(in.readLine());
		numnode = Integer.parseInt(str.nextToken());
		int numq = Integer.parseInt(str.nextToken());
		
		//array of arraylist
		edges = new ArrayList[numnode];
		for(int i=0; i<numnode; i++) edges[i] = new ArrayList<edge>();
		
		for(int i=0; i<numnode-1; i++) {
			str = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(str.nextToken())-1;
			int v2 = Integer.parseInt(str.nextToken())-1;
			int r = Integer.parseInt(str.nextToken());
			edges[v1].add(new edge(v2, r));
			edges[v2].add(new edge(v1, r));
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		for(int i=0; i<numq; i++) {
			str = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			int result = findVids(k, v);
			out.println(result);
			System.out.println(result);
		}
		out.close();
		in.close();
		
		
		
	}
	
	public static int findVids(int k, int v) {
		
		v=v-1;
		
		//tracks if a node has been arrived at
		boolean[] used = new boolean[numnode];
		used[v]=true;
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		
		int res = 0;
		
		while(q.size()>0) {
			int curr = q.poll();
			res++;
			for(edge e : (ArrayList<edge>) edges[curr]) {
				if(e.r>=k && used[e.v]==false) {
					q.offer(e.v);
					used[e.v] = true;
				}
			}
		}
		
		return res-1;	//subtract the original node v
		
		
	}

}

class edge{
	int v;
	int r;
	public edge(int v, int r) {
		this.v = v;
		this.r = r;
	}
}