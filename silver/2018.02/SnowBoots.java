package silverFeb2018;

import java.io.*;
import java.util.StringTokenizer;

public class SnowBoots {
	
	public static void main(String[] args) throws Exception {
		
		//BufferedReader in = new BufferedReader(new FileReader("snowboots.in"));
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\USACO\\src\\silverFeb2018\\snowboots"));
		
		StringTokenizer str = new StringTokenizer(in.readLine());
		int length = Integer.parseInt(str.nextToken());
		int numboots = Integer.parseInt(str.nextToken());
		
		//saves tile snow depth in array
		str = new StringTokenizer(in.readLine());
		int[] tiles = new int[length];
		for(int i=0; i<length; i++) {
			tiles[i] = Integer.parseInt(str.nextToken());
		}
		
		//saves boots info in array
		boot[] boots = new boot[numboots];
		for(int i=0; i<numboots; i++) {
			str = new StringTokenizer(in.readLine());
			boots[i] = new boot(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
		}
		
		int currloc = 0;
		int shoenumber = 0;
		int result = 0;
		
		while(currloc < length-1) {
			int maxstep = boots[shoenumber].step;
			int maxdept = boots[shoenumber].depth;
			boolean hasStepped = false;
			int i = Math.min(maxstep, length-1-currloc);
			System.out.println("initial i:" + i);
			while(!hasStepped && i>=1 && currloc+i<length) {
				if(maxdept>=tiles[currloc+i]) {
					currloc = currloc+i;
					System.out.println("currloc:"+currloc);
					System.out.println("i:"+i);
					hasStepped=true;
				}
				else {
					i--;
				}
			}
			if(hasStepped==false) {
				shoenumber++;
				result++;
				System.out.println("result:"+result);
			}
		}
		
		System.out.println("final result:"+result);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		out.println(result);
		out.close();
		in.close();
		
	}

}

class boot{
	int depth;
	int step;
	public boot(int d, int s) {
		depth = d;
		step = s;
	}
}
