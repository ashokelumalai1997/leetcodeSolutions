class Solution {
	public int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];
		
		for(int i = 1; i <= amount; i++) {
			dp[n-1][i] = Integer.MAX_VALUE;
}



for(int i = n-1; i >= 0; i-- ) {
	for(int j = 1; j <= amount; j++) {

		int next = Integer.MAX_VALUE;

		if(i != n-1) {
			next = dp[i+1][j];
}
		if(coins[i] > j || dp[i][j-coins[i]] == Integer.MAX_VALUE) {
			dp[i][j] = next;
			continue;
}
		dp[i][j] = Math.min(next
, 1 + dp[i][j-coins[i]]);
}
}

return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
}
}