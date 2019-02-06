package competitiveProgramming;
//UVa 11450 Wedding Shopping
//Top-down DP

import java.util.Arrays;

public class UVa11450_td_dp {
	
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
	
	//money<=200; g<=20
	public static int[][] memo = new int[201][21];
	
	public static int purchase(int money, int g) {
		if(money<0) return -1000000;
		if(g==C) return M-money;
		if(memo[money][g]!=-1) return memo[money][g];
		int ans = -1000000;
		for(int i=1; i<=price[g][0]; i++) {
			ans = Math.max(ans, purchase(money-price[g][i], g+1));
		}
		return ans;
	}
	
	public static int purchase(int money) {
		return purchase(money, 0);
	}
		
	public static void main(String[] args) {
		
		for(int r=0; r<memo.length; r++) {
			Arrays.fill(memo[r], -1);
		}
		
		int result = purchase(9);
		if(result>0) System.out.println(result);
		else System.out.println("no result");
		
	}

}
