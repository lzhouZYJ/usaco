//package bronzeFeb2018;

import java.util.*;
import java.io.*;

public class Teleportation {
	
	public static void main(String[] args) throws Exception{
		
		Scanner in = new Scanner(new File("teleport.in"));
		//Scanner in = new Scanner(new File("C:\\Users\\Lily\\OneDrive - The Hockaday School\\CS\\Coding\\src\\bronzeFeb2018\\teleport"));
		
		int start = in.nextInt();
		int end = in.nextInt();
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		int notele = Math.abs(start-end);
		
		int atob = Math.abs(start-a)+Math.abs(end-b);
		
		int btoa = Math.abs(start-b)+Math.abs(end-a);
		
		int result = Math.min(Math.min(atob, btoa),notele);
		
		System.out.println(result);
		
		PrintWriter out = new PrintWriter(new FileWriter("teleport.out"));
		out.print(result);
		out.close();
		in.close();
		
	}

}
