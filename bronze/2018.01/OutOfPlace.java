//package bronzeJan2018;

import java.util.*;
import java.io.*;

public class OutOfPlace {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("outofplace.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeJan2018\\outofplace"));
		
		//total number of cows
		int num = in.nextInt();
		
		//array of the line
		int[] line = new int[num];
		for (int i=0; i<num; i++) {
			line[i]=in.nextInt();
		}
		
		//look for bessie
		int bessie = -1;
		if (line[0]>line[1]) {
			bessie=0;
			//System.out.println("1true");
		}
		else if (line[num-1]<line[num-2]) {
			bessie=num-1;
			//System.out.println("2true");
		}
		else {
			for (int i=1; i<num-1; i++) {
				if (line[i-1]>line[i]&&line[i]<line[i+1] &&line[i+1]>=line[i-1]) {
					bessie=i;
					System.out.println("3true");
					break;
				}
				else if (line[i-1]<line[i]&&line[i]>line[i+1] &&line[i+1]>=line[i-1]) {
					bessie=i;
					System.out.println("4true");
					break;
				}
			}
		}
		
		System.out.println("bessie:"+bessie);
		
		int result = 0;
		
		if (bessie!=-1) {
		
			//bessie's height
			int bheight = line[bessie];
			
			//look for bessie's supposed index
			int index = 0;
			if (bheight<line[0]) {
				index=0;
			}
			else if (bheight>line[num-1]) {
				index=num-1;
			}
			else {
				for (int i=1; i<num; i++) {
					if (i!=bessie&&line[i-1]<=bheight&&line[i]>=bheight) {
						index = i;
						break;
					}
				}
			}
			
			System.out.println("index:"+index);
			
			//look for repetitive heights before/after Bessie
			int repeats = 0;
			if (bessie>index) {
				for (int i=bessie; i>index; i--) {
					if (line[i-1]==line[i]) {
						repeats++;
					}
				}
				if (line[index]==bheight) {
					repeats++;
				}
			}
			
			else if (bessie<index) {
				if (index!=num-1) {
					index = index-1;//because moving bessie backwards will cause all indices to shift forward
				}
				for (int i=bessie; i<index; i++) {
					if (line[i]==line[i+1]) {
						repeats++;
					}
				}
				if (line[index]==bheight) {
					repeats++;
				}
				
			}
			
			System.out.println("repeats:"+repeats);
			
			result = Math.abs(bessie-index)-repeats;
		
		}
		else {
			result=0;
		}
		
		//System.out.println("bessie:"+bessie);
		//System.out.println("index:"+index);
		
		System.out.println("result:"+result);
		
		PrintWriter out = new PrintWriter(new FileWriter("outofplace.out"));
		out.print(result);
		out.close();
		in.close();
	}
	
}
