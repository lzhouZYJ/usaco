package bronzeDec2017;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class MilkMeasurement {

	public static void main (String[] args) throws Exception{
		
		//array of 3 cows with name and amount of milk produced
		cow[] cows = new cow[3];
		cows[0]=new cow("Bessie",7);
		cows[1]=new cow("Elsie",7);
		cows[2]=new cow("Mildred",7);
		
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\measurement"));
		Scanner in = new Scanner(new File("measurement.in"));
		
		//the number of days the measurement is made
		int numDays = in.nextInt();
		
		//array with all the measurements
		day[] measurements = new day[numDays];
		for (int i = 0; i<numDays; i++) {
			int d = in.nextInt();
			String s = in.next();
			int c = in.nextInt();
			measurements[i] = new day(d, s, c);
		}
		
		//sorts the measurements array in chronological order
		Arrays.sort(measurements);
		
		//result variable
		int result = 0;
		
		//sets up array for winning board
		boolean[] win = new boolean[3];
		Arrays.fill(win, true);
		
		for (int i = 0; i<numDays; i++) {
				
				/*
				System.out.println(i+1);
				*/
			
			for (int j = 0; j<3; j++) {
				if (measurements[i].name.equals(cows[j].name)) {
					cows[j].milk += measurements[i].change;
				}
			}
			
				/*
				System.out.println("M:"+cows[2].milk);
				System.out.println("E:"+cows[1].milk);
				System.out.println("B:"+cows[0].milk);
				*/
			
			//finds out who wins
			int max = 0;
			for (int n=0; n<3; n++) {
				if (cows[n].milk>max) {
					max=cows[n].milk;
				}
			}
			
			//determines who wins
			boolean[] temp = new boolean[3];
			for (int n=0; n<3; n++) {
				if (cows[n].milk==max) {
					temp[n]=true;
				}
				else {
					temp[n]=false;
				}
			}
			
			//compares winnings in temp with the old winnings
			if (!eq(temp, win)) {
				result++;
			}
			
				/*
				for (int n=0; n<3; n++) {
					System.out.println("temp[n]:"+temp[n]+" win[n]:"+win[n]);
					if (temp[n]!=win[n]) {
						result++;
					}
					System.out.println("result:"+result);
				}
				*/
			
			win=Arrays.copyOf(temp, 3);
			
				/*
				for (int a=0; a<3; a++) {
					System.out.println(win[a]);
				}
				*/
		
		}
			
		//System.out.print(result);
		
		//formatting output
			PrintWriter out = new PrintWriter(new FileWriter("measurement.out"));
			out.print(result);
			out.close();
			in.close();
		
	}
	
	public static boolean eq(boolean[] a, boolean[] b) {
		int length = a.length;
		for (int n = 0; n<length; n++) {
			if (a[n]!=b[n]) {
				return false;
			}
		}
		return true;
	}
	
}

class day implements Comparable<day>{
	
	public int date;
	public String name;
	public int change;
	
	public day(int d, String n, int c) {
		this.date=d;
		this.name=n;
		this.change=c;
	}
	
	public int compareTo(day other) {
		return this.date-other.date;
	}
	
}

class cow{
	
	public String name;
	public int milk;
	
	public cow(String n, int m) {
		this.name = n;
		this.milk = m;
	}
	
}
