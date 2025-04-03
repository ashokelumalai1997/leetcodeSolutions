class Solution {
	public long maximumTripletValue(int[] nums) {
		int n = nums.length;
		int[] rightMax = new int[n];
		int[] leftMax = new int[n];

		leftMax[0] = nums[0];
		rightMax[n-1] = nums[n-1];
		
		for(int i = 1; i < n; i++) {
			leftMax[i] = Math.max(nums[i], leftMax[i-1]);
			rightMax[n-1-i] = Math.max(nums[n-1-i], rightMax[n-i]);
}

long maxTriplet = 0;

for(int i = 1; i < n-1; i++) {
	maxTriplet = Math.max(maxTriplet, (long)rightMax[i+1]*(leftMax[i-1] - nums[i]));
}

return maxTriplet;
}
}
