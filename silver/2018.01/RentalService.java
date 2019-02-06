package silverJan2018;

import java.io.*;
import java.util.*;

public class RentalService {
	
	public static void main(String[] args) throws Exception {

		//BufferedReader in = new BufferedReader(new FileReader("rental.in"));
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\USACO\\src\\silverJan2018\\rental"));
		
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken());//N cows
		int M = Integer.parseInt(str.nextToken());//M stores for milk
		int R = Integer.parseInt(str.nextToken());//R farmers for cow
		
		//amount of milk each cow produces in increasing order
		int[] milkProduced = new int[N];
		for(int i=0; i<N; i++) {
			milkProduced[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(milkProduced);
		
		//shops with the amount of milk they want and their prices in increasing order
		shop[] shops = new shop[M];
		for(int i=0; i<M; i++) {
			str = new StringTokenizer(in.readLine());
			shops[i] = new shop(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
		}
		Arrays.sort(shops);
		
		//each index represents the number of cows used for milk
		long[] profit = new long[N+1];
		
		//adding amount of profits gained from milk
		int s = M-1;	//index of shop
		for(int i=1; i<=N; i++) {	//i = num of cows used for milk
			profit[i] = profit[i-1];
			while(s>=0) {
				int used = Math.min(milkProduced[N-i], shops[s].amount);
				profit[i] += used*shops[s].price;
				milkProduced[N-i] -= used;
				shops[s].amount -= used;
				if(shops[s].amount==0) s--;
				if(milkProduced[N-i]==0) break;
			}
		}
		
		//amount of rent offered by farmers in increasing order
		int[] rent = new int[R];
		for(int i=0; i<R; i++) {
			rent[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(rent);
			
		//adding amount of profits gained from rental
		int index = N-1;
		int index2 = R-1;
		int alreadyRented = 0;
		while(index>=0 && index2 >=0) {
			alreadyRented += rent[index2];
			profit[index] += alreadyRented;
			index--;
			index2--;
		}
		
		/*
		for(long num:profit) {
			System.out.println(num);
		}
		*/
		
		long result = 0;
		for(long num:profit) {
			result = Math.max(result, num);
		}
		System.out.println("result:"+result);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		out.println(result);
		out.close();
		in.close();	
		
	}
	
	//sorts in decreasing order - binary
	public static void sort(int[] l) {
		Arrays.sort(l);
		for(int i = 0; i < l.length-1-i; i++) {
			l[i] ^= l[l.length-1-i];
			l[l.length-1-i] ^= l[i];
			l[i] ^= l[l.length-1-i];
		}
	}

}

class shop implements Comparable<shop>{
	
	public int amount;
	public int price;
	
	public shop(int a, int p) {
		amount = a;
		price = p;
	}
	
	public int compareTo(shop other) {
		return price - other.price;
	}
	
}
