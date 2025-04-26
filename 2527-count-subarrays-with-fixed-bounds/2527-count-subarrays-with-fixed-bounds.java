class Solution {
	public long countSubarrays(int[] nums, int minK, int maxK) {
		int n = nums.length;
		int[] minBound = new int[n];
		int[] maxBound = new int[n];
		int[] leftMax = new int[n];
		int[] leftMin = new int[n];

		int maxInd = -1;
		int minInd = -1;
		int bound = -1;

long res = 0;

		for(int i = 0; i < n; i++) {
			if(nums[i] == maxK) {
				maxInd = i;
}

if(nums[i] == minK) {
				minInd = i;
}

if(nums[i] < minK) {
				bound = i;
}

if(nums[i] > maxK) {
				bound = i;
}

// int bound = Math.min(minInd, maxBound);
if(minInd > bound && maxInd > bound) {
	int min = Math.min(minInd, maxInd);
	int max = Math.min(minInd, maxInd);
	res += (min - bound);
}


}
return res;
}
}

