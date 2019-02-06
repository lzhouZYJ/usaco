//package bronzeDec2016;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class SquarePasture {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("square.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeDec2016\\square"));
		
		//first rectangle
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		
		//second rectangle
		int a1 = in.nextInt();
		int b1 = in.nextInt();
		int a2 = in.nextInt();
		int b2 = in.nextInt();
		
		int width = 0;
		int length = 0;
		
		if (x1<a1) { 		//if first rec is to the left of the second
			width = Math.max(x2-x1, a2-x1);
		}
		else if (x1>a1) {				//if first rec is to the right of the second
			width = Math.max(x2-a1, a2-a1);
		}
		else if (x1==a1) {				// if both recs start with same left x value
			width = Math.max(x2-x1, a2-a1);
		}
		
		if (y2<b2) {
			length = Math.max(b2-b1, b2-y1);
		}
		else if (y2>b2) {
			length = Math.max(y2-y1, y2-b1);
		}
		else if (y2==b2) {
			length = Math.max(y2-y1, b2-b1);
		}
		
		int result = (int) Math.pow(Math.max(length, width), 2);
		
		System.out.println(result);
		
		PrintWriter out = new PrintWriter(new File("square.out"));
		out.print(result);
		out.close();
		in.close();
		
	}

}
