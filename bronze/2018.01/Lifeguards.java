//package bronzeJan2018;
import java.util.*;
import java.io.*;

public class Lifeguards {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("lifeguards.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeJan2018\\lifeguards"));
		
		//number of cows
		int num = in.nextInt();
		
		//timetable with false being not covered, true being covered
		boolean[] time = new boolean[1000];
		Arrays.fill(time, false);
		
		//array of cows with starting and ending times
		cow[] cows = new cow[num];
		for (int i=0; i<num; i++) {
			cows[i]=new cow(in.nextInt(), in.nextInt());
		}
		
		int maxtime = 0;
		for (int skip=0; skip<num; skip++) {
			//System.out.println("Skip:"+skip);
			for (int n=0; n<num; n++) {
				if (n!=skip) {
					//System.out.println("n:"+n);
					//System.out.println("start:"+cows[n].start);
					//System.out.println("end:"+cows[n].end);
					for (int i=cows[n].start;i<cows[n].end;i++) {
						time[i]=true;
					}
				}
			}
			//counts the number of trues
			int t = 0;
			for (int i=0; i<1000; i++) {
				if (time[i]==true) {
					t++;
				}
			}
			//System.out.println("time:"+t);
			if (t>maxtime) {
				maxtime=t;
				//System.out.println("maxtime:"+maxtime);
			}
			Arrays.fill(time, false);
		}
		
		System.out.println(maxtime);
		
		PrintWriter out = new PrintWriter(new FileWriter("lifeguards.out"));
		out.print(maxtime);
		out.close();
		in.close();
		
	}

}

class cow {
	
	int start;
	int end;
	
	public cow(int s, int e) {
		this.start=s;
		this.end=e;
	}
	
}
