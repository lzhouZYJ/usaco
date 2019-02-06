//package bronzeJan2017;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class HoofPaperScissors {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("hps.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeJan2017\\hps"));
		
		//total number of games
		int games = in.nextInt();
		
		int wins = 0; //number of wins by first rule
		int wins2 = 0; //number of wins by second rule
		for (int i=0; i<games; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			//first rule: 1<2<3<1
			if (a-b==1 || a-b==-2) {
				wins++;
			}
			//second rule: 1>2>3>1
			if (a-b==-1 || a-b == 2) {
				wins2++;
			}
		}
		
		System.out.println("result:" + Math.max(wins, wins2));
		
		PrintWriter out = new PrintWriter(new File("hps.out"));
		out.println(Math.max(wins, wins2));
		out.close();
		in.close();
		
	}

}
