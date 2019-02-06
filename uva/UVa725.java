package competitiveProgramming;
//UVa 725 Division
//CP3 Sec 3.2.1

import java.util.Arrays;

public class UVa725 {
	
	public static void main(String[] args) {
		
		int abcde;
		int fghij;
		boolean[] used = new boolean[10];
		boolean okay = true;
		
		for(int n=2; n<=79; n++) {
			for(fghij=1234; fghij<=98765/n; fghij++) {
				okay=true;
				Arrays.fill(used, false);
				abcde=fghij*n;
				int temp1=abcde;
				int temp2=fghij;
				for(int i=0; i<5; i++) {
					int num2 = temp2%10;
					int num1 = temp1%10;
					if(used[num2]==true) {
						okay=false;
						break;
					}
					if(used[num1]==true) {
						okay=false;
						break;
					}
					used[num2]=true;
					used[num1]=true;
					temp2=temp2/10;
					temp1=temp1/10;
				}
				if(okay) {
					System.out.println(abcde+"\t"+fghij+"\t"+n);
				}
				
			}
		}
		
	}

}
