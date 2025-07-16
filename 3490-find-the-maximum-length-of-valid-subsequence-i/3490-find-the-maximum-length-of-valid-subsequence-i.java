class Solution {
	public int maximumLength(int[] nums) {
		int n = nums.length;

		int allZeros = 0;
		int allOnes = 0;
		int endWithZeros = 0;
		int endWithOnes = 0;
		
		for(int i = 0; i < n; i++) {
			if(nums[i]%2 == 0) {
				allZeros++;
				endWithZeros = (endWithOnes + 1);
} else {
	allOnes++;
	endWithOnes = (endWithZeros + 1);
}
}

return Math.max(Math.max(endWithZeros, endWithOnes), Math.max(allOnes, allZeros));
}
}
