package silverDec2017;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework {
	
	public static void main(String[] args) throws Exception {
		
		//Scanner in = new Scanner(new File("homework.in"));
		Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\silverDec2017\\homework"));
		
		int n = in.nextInt();
		
		int[] scores = new int[n];
		for (int i=0; i<n; i++) {
			scores[i]=in.nextInt();
		}
		
		double maxScore = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		double sum = 0;
		int min = Integer.MAX_VALUE;
		double maxAvg = 0;
		for(int i=n-2; i>=1; i--) {
			sum += scores[i];
			min = Math.min(min, scores[i]);
			double avg = (sum-min)/(n-i-1);
			if(maxAvg<avg) {
				result.clear();
				maxAvg = avg;
			}
			if(maxAvg==avg) {
				result.add(i);
			}
		}
		
		for(int i=0; i<result.size();i++) {
			System.out.println(result.get(i));
		}
		
		PrintWriter out = new PrintWriter(new File("homework.out"));
		for(int i=0; i<result.size();i++) {
			out.println(result.get(i));
		}
		out.close();
		in.close();
		
		
	}

}
