package competitiveProgramming;
//UVa 11450 Wedding Shopping
//bottom-up dp

public class UVa11450_bu_dp {
	
	//rows-each garment; columns-leftover money
	public static boolean[][] memo = new boolean[20][201];
	
	//M-budget; C-# of garments; K-# of models for each garment
	public static int M = 20;
	public static int C = 3;
	public static int K;	
		
	//each row represents the prices of the models for each garment
	//the first element of each row is K - # of models for each garment
	public static int[][] price = {
			{3,6,4,8},
			{2,5,10},
			{4,1,5,3,5},
	};
	
	public static void purchase(int money, int g) {
		for(int i=1; i<=price[g][0]; i++) {
			//System.out.println(money-price[g][i]);
			if(money-price[g][i]>=0) memo[g][money-price[g][i]]=true;
			if(g<C-1) purchase(money-price[g][i], g+1);
		}
	}
	
	public static void purchase(int money) {
		purchase(money, 0);
	}
	
	public static void main(String[] args) {
		
		purchase(9);
		
		/*
		for(int n=0; n<20; n++) {
			System.out.print(n+"\t");
		}
		for(boolean[] row:memo) {
			for(boolean b:row) {
				System.out.print(b+"\t");
			}
			System.out.println();
			
		}
		*/
		
		boolean found = false;
		int i=0;
		while(!found && i<201) {
			if(memo[price.length-1][i]==true){
				System.out.println(M-i);
				found=true;
			}
			i++;
		}
		if(!found) {
			System.out.println("no result");
		}
		
	}

}
