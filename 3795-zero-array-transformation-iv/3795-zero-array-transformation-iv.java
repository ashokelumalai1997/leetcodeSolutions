class Solution {
    static class ZeroArray{
	private static int dp(int[][] cache, 
            int target, int numInd, int ind, int[][] queries) {
		if(target == 0) return ind;
		if(target < 0 || ind == queries.length) return Integer.MAX_VALUE;
        if(cache[target][ind] != -1) return cache[target][ind];
        int pick = Integer.MAX_VALUE;
		if(numInd >= queries[ind][0] && numInd <= queries[ind][1]) {
            pick  = dp(cache, target - queries[ind][2], numInd, ind+1, queries);
        }
		int npick  = dp(cache, target, numInd, ind+1, queries);
		return cache[target][ind] = Math.min(pick, npick);
    }
	public static int getMaxK(int[] nums, int[][] queries) {
		int maxK = 0;
		int n = nums.length;
		for(int i = 0; i < n; i++) {
            int[][] cache = new int[nums[i]+1][queries.length];
            for(int[] d : cache) Arrays.fill(d, -1);
			maxK = Math.max(maxK, dp( cache, nums[i], i, 0, queries));
        }
        return maxK == Integer.MAX_VALUE ? -1 : maxK;
    }
}

    public int minZeroArray(int[] nums, int[][] queries) {
        return ZeroArray.getMaxK(nums, queries);
    }
}

