//package USAOpen2018;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TeamTicTacToe {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("tttt.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\USAOpen2018\\tttt"));
		
		//the board
		char[][] board = new char[3][3];
		for (int i=0; i<3; i++) {
			String row = in.next().toLowerCase();
			for (int j=0; j<3; j++) {
				board[i][j] = row.charAt(j);
			}
		}
		
		int ind = 0;//individual wins
		int team = 0;//team wins
		
		boolean[] wins = new boolean[26];
		Arrays.fill(wins, false);
		
		int[][] teamwins = new int[8][2];
		for (int i=0; i<8; i++) {
			Arrays.fill(teamwins[i], -1);
		}
		int index = 0;
		
		//check for horizontal/vertical individual/team wins
		for (int i=0; i<3; i++) {
			//horizontal
			if (board[i][1]==board[i][2] && board[i][2]==board[i][0]) {
				int letter = board[i][1]-'a';
				if (wins[letter]==false) {
					ind++;
					wins[letter]=true;
				}
			}
			else if (board[i][1]==board[i][2] || board[i][1]==board[i][0] || board[i][2]==board[i][0]){
				int a = board[i][1]-'a';
				int b;
				if (board[i][2]!=board[i][1]) {b=board[i][2]-'a';}
				else {b=board[i][0]-'a';}
				int[] t = new int[] {a,b};
				Arrays.sort(t);
				teamwins[index]=t;
				index++;
			}
			//vertical
			if (board[1][i]==board[2][i] && board[2][i]==board[0][i]) {
				int letter = board[1][i]-'a';
				if (wins[letter]==false) {
					ind++;
					wins[letter]=true;
				}
			}
			else if (board[1][i]==board[2][i] || board[1][i]==board[0][i] || board[2][i]==board[0][i]) {
				int a = board[1][i]-'a';
				int b;
				if (board[1][i]!=board[2][i]) {b=board[2][i]-'a';}
				else {b=board[0][i]-'a';}
				int[] t = new int[] {a,b};
				Arrays.sort(t);
				teamwins[index]=t;
				index++;
			}
		}
		
		//check for diagonal individual/team wins
		if (board[0][0]==board[1][1] && board[1][1]==board[2][2]) {
			int letter = board[0][0]-'a';
			if (wins[letter]==false) {
				ind++;
				wins[letter]=true;
			}
		}
		else if (board[0][0]==board[1][1] || board[1][1]==board[2][2] || board[0][0]==board[2][2]) {
			int a = board[0][0]-'a';
			int b;
			if (board[0][0]!=board[1][1]) {b=board[1][1]-'a';}
			else {b=board[2][2]-'a';}
			int[] t = new int[] {a,b};
			Arrays.sort(t);
			teamwins[index]=t;
			index++;
		}
		if (board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
			int letter = board[0][2]-'a';
			if (wins[letter]==false) {
				ind++;
				wins[letter]=true;
			}
		}
		else if (board[0][2]==board[1][1] || board[1][1]==board[2][0] || board[0][2]==board[2][0]){
			int a = board[0][2]-'a';
			int b;
			if (board[0][2]!=board[1][1]) {b=board[1][1]-'a';}
			else {b=board[2][0]-'a';}
			int[] t = new int[] {a,b};
			Arrays.sort(t);
			teamwins[index]=t;
			index++;
		}
		
		/*
		for (int[] each : teamwins) {
			for (int e : each) {
				System.out.print(e+" ");
			}
			System.out.println();
		}
		*/
		
		//sorts out the number of team wins
		for (int i=0; i<8; i++) {
			int[] group = teamwins[i];
			for (int j=0; j<8; j++) {
				if (j!=i) {
					if (teamwins[j][0]==group[0]&&teamwins[j][1]==group[1]) {
						teamwins[j]=new int[] {-1,-1};
						//System.out.println("T");
					}
				}
			}
		}
		
		for (int[] each : teamwins) {
			for (int e : each) {
				System.out.print(e+" ");
			}
			System.out.println();
		}
		
		for (int i=0; i<8; i++) {
			if (teamwins[i][0]!=-1) {
				team++;
			}
		}
		
		System.out.println("Individual:"+ind);
		System.out.println("Team:"+team);
		
		PrintWriter out = new PrintWriter(new File("tttt.out"));
		out.println(ind);
		out.println(team);
		out.close();
		in.close();
		
	}

}
