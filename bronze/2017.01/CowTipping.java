//package bronzeJan2017;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CowTipping {
	
	public static void main(String[] args) throws Exception {
		

		Scanner in = new Scanner(new File("cowtip.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeJan2017\\cowtip"));
		
		int n = in.nextInt();
		
		int[][] grid = new int[n][n];
		
		//fill in the grid
		for (int i=0; i<n; i++) {
			String row = in.next();
			for (int j=0; j<n; j++) {
				grid[i][j] = Integer.parseInt(row.substring(j,j+1));
			}
		}
		
		/*
		for (int[] i:grid) {
			for (int j:i) {
				System.out.print(j);
			}
			System.out.println();
		}
		*/
		
		int count = 0;
		
		boolean done = false;
		while (!done) {
			int[] last = find(grid);
			if (last[0]!=-1) {
				grid = flip(grid,last);
				count++;
			}
			else {
				done = true;
			}
		}
		
		System.out.println("count:"+count);
		
		PrintWriter out = new PrintWriter(new File("cowtip.out"));
		out.println(count);
		out.close();
		in.close();
		
	}
	
	//finds the last flipped cow of the lowest row
	public static int[] find(int[][] grid) {
		
		int row = grid.length;
		int column = grid[0].length;
		
		for (int i=row-1; i>=0; i--) {
			for (int j=column-1; j>=0; j--) {
				if (grid[i][j]==1) {
					int[] result = new int[] {i, j};
					return result;
				}
			}
		}
		
		//if no 1's are found, return -1, -1
		int[] result = new int[] {-1,-1};
		return result;
		
	}
	
	//int[] corner gives the x and y of the bottom right corner of the rectangle
	public static int[][] flip(int[][] grid, int[] corner){
		
		//coordinates of the bottom right corner of the rectangle
		int x = corner[0];
		int y = corner[1];
		
		for (int i=0; i<=x; i++) {
			for (int j=0; j<=y; j++) {
				if (grid[i][j]==0) {
					grid[i][j]=1;
				}
				else {
					grid[i][j]=0;
				}
			}
		}
		return grid;
		
	}

}
