//package bronzeFeb2018;

import java.util.*;
import java.io.*;

public class TamingTheHerd {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("taming.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeFeb2018\\taming"));
		
		//total number of days
		int days = in.nextInt();
		
		String result="";
		
		//whether there's a breakout
		boolean[] breakout = new boolean[days];
		
		//original logs
		int[] original = new int[days];
		for (int i=0; i<days; i++) {
			original[i]=in.nextInt();
		}
		
		//new complete log with no missing data
		int[] log = original.clone();
		
		//fill out the new log
		for (int n=0; n<days; n++) {
			if (log[n]==0) {
				breakout[n]=true;
			}
			else if (log[n]!=-1) {
				if (n-log[n]>=0) {
					breakout[n-log[n]]=true;
				}
				for (int j=1; j<=log[n]; j++) {
					if (n>=j) {
						log[n-j]=log[n]-j;
					}
				}
			}
		}
		
		for (int a:log) {
			System.out.print(a+" ");
		}
		System.out.println();
		for (boolean a:breakout) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		//check for inconsistencies
		boolean inconsistent = false;
		if (log[0]>0) {
			inconsistent = true;
		}
		for (int n=0; n<days; n++) {
			if (original[n]!=-1&&log[n]!=original[n]) {
				inconsistent = true;
			}
		}
		
		System.out.println("inconsistent:"+inconsistent);
		
		if (inconsistent==false) {
			//look for min
			int min = 0;
			log[0]=0; //first day always has breakout
			breakout[0]=true; //first day is always true
			for (boolean a:breakout) {
				if (a==true) {
					min++;
				}
				
			}
			System.out.println();
			
			for (int a:log) {
				System.out.print(a+" ");
			}
			
			System.out.println();
			System.out.println("min:"+min);
			
			//look for max
			int max = 0;
			log[0]=0;
			breakout[0]=true;
			for (int n=0; n<days; n++) {
				if (log[n]==-1) {
					log[n]=0;
					breakout[n]=true;
				}
			}
			
			for (boolean a:breakout) {
				if (a==true) {
					max++;
				}
				System.out.print(a+" ");
			}
			System.out.println();
			
			for (int a:log) {
				System.out.print(a+" ");
			}
			System.out.println();
			System.out.println("max:"+max);
			
			result=min+" "+max;
		}
		else {
			result="-1";
		}
		
		System.out.println("result:"+result);
		
		PrintWriter out = new PrintWriter(new FileWriter("taming.out"));
		out.print(result);
		out.close();
		in.close();
		
	}

}
