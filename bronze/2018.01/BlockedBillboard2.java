package bronzeJan2018;

import java.util.*;
import java.io.*;

public class BlockedBillboard2 {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeJan2018\\billboard"));
		//Scanner in = new Scanner(new File("billboard.in"));
		
		int lmx1 = in.nextInt()+1000;
		int lmy1 = in.nextInt()+1000;
		int lmx2 = in.nextInt()+1000;
		int lmy2 = in.nextInt()+1000;
		
		int foodx1 = in.nextInt()+1000;
		int foody1 = in.nextInt()+1000;
		int foodx2 = in.nextInt()+1000;
		int foody2 = in.nextInt()+1000;
		
		//2D array and fill it with false
		boolean[][] seen = new boolean[2001][2001];
		for (int n = 0; n<seen.length; n++) {
			Arrays.fill(seen[n], false);
		}
		
		//set the lawn mower billboard to true
		for (int i = lmx1; i<lmx2; i++) {
			for (int j = lmy1; j<lmy2; j++) {
				seen[i][j]=true;
			}
		}
		
		//set the food billboard to false
		for (int i = foodx1; i<foodx2; i++) {
			for (int j = foody1; j<foody2; j++) {
				seen[i][j]=false;
			}
		}
		
		//now the trues are where the lawn mower billboard is still visible
		
		int maxwidth = 0;
		for (int i = lmx1; i<lmx2; i++) {
			int width = 0;
			for (int j = lmy1; j<lmy2; j++) {
				if (seen[i][j]==true) {
					width++;
				}
			}
			//System.out.println("width:"+width);
			if (width>maxwidth) {
				maxwidth=width;
			}
		}
		
		//System.out.println("maxwidth:"+maxwidth);
		
		int maxlength = 0;
		for (int j = lmy1; j<lmy2; j++) {
			int length = 0;
			for (int i = lmx1; i<lmx2; i++) {
				if (seen[i][j]==true) {
					length++;
				}
			}
			//System.out.println("length:"+length);
			if (length>maxlength) {
				maxlength=length;
			}
		} 
		
		//System.out.println("maxlength:"+maxlength);
		
		int result = (maxlength)*(maxwidth);
		
		System.out.println(result);
		
		PrintWriter out = new PrintWriter(new FileWriter("billboard.out"));
		out.print(result);
		out.close();
		in.close();
		
	}
	
}
