class Solution {
	public int rob(int[] nums) {
		int n = nums.length;
		// int[] dp = new int[n];

		// dp[0] = nums[0];

		if(n == 1) return nums[0];

		int secondLast = nums[0];

		int last = Math.max(nums[0], nums[1]);

		
		int current = last;


		for(int i = 2; i < n; i++) {
			current = Math.max(nums[i] + secondLast, last);
            secondLast = last;
            last = current;
}

return current;
}
}
