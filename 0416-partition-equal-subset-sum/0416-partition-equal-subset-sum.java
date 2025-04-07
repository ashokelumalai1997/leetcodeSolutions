class Solution {
	public boolean canPartition(int[] nums) {
		int n = nums.length;
		int total = 0;
		for(int num : nums) total += num;

		if(total % 2 != 0) return false;

		boolean[][] dp = new boolean[n][1 + total];

		dp[n-1][nums[n-1]] = true;
		
		for(int i = n-2; i >= 0; i--) {
			for(int j = total/2; j >= 0; j--) {
				dp[i][j] = false;
				if(j - nums[i] >= 0) {
					dp[i][j] = dp[i+1][j - nums[i]];
}

				dp[i][j] = dp[i][j]
|| dp[i+1][j]; 
}
}

return dp[0][total/2];
}
}
