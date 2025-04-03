class Solution {
	public int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int currentSum = 0;
		int n = nums.length;
		
		for(int i = 0; i < n; i++) {
			if(currentSum < 0) currentSum = 0;
			currentSum += nums[i];
			maxSum = Math.max(maxSum, currentSum);
}

return maxSum;
}
}
