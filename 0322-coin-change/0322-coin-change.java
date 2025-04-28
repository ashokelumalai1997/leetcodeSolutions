class Solution {
	public int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount+1];

		for(int[] d : dp) Arrays.fill(d, -1);
        

        int res = f(0, coins, amount, dp);

        if(res != Integer.MAX_VALUE) return res;
		
		return -1;
}

private int f(int ind, int[] nums, int amount, int[][] dp) {
	if(amount == 0) return 0;
	if(ind == nums.length)  return Integer.MAX_VALUE;

    if(dp[ind][amount] != -1) return dp[ind][amount];
	int take = Integer.MAX_VALUE;
	int notTake = Integer.MAX_VALUE;
	
	int currentC = nums[ind];
	int currentA = amount;
	
	for(int i = 1; currentA - currentC*i >= 0; i++ ) {
		int next = f(ind + 1, nums, amount - currentC*i, dp);
		if(next == Integer.MAX_VALUE) continue;
take = Math.min(take, i + next);
}

notTake = f(ind+1, nums, amount, dp);

return dp[ind][amount] = Math.min(take, notTake);
}
}
