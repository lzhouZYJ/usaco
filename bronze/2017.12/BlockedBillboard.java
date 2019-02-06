//package bronzeDec2017;

import java.io.*;
import java.util.*;
public class BlockedBillboard {

	public static void main(String[] args) throws IOException {
		
		//read input
		Scanner in = new Scanner(new File("billboard.in"));
		
		boolean[][] boards = new boolean[2001][2001];
		
		//label the boards as true
		for (int i=0; i<2; i++) {
			int x1 = in.nextInt()+1000;
			int y1 = in.nextInt()+1000;
			int x2 = in.nextInt()+1000;
			int y2 = in.nextInt()+1000;
			for (int x = x1; x<x2; x++) {
				for (int y = y1; y<y2; y++) {
					boards[x][y]=true;
				}
			}
		}
		
		//label the truck as false
		int x1 = in.nextInt()+1000;
		int y1 = in.nextInt()+1000;
		int x2 = in.nextInt()+1000;
		int y2 = in.nextInt()+1000;
		for (int x = x1; x<x2; x++) {
			for (int y = y1; y<y2; y++) {
				boards[x][y]=false;
			}
		}
		
		//count the number of true grids
		int result = 0;
		for (boolean row[] : boards) {
			for (boolean grid : row) {
				if (grid==true) {
					result++;
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new FileWriter("billboard.out"));
		out.print(result);
		out.close();
		in.close();
		
	}
	
}
