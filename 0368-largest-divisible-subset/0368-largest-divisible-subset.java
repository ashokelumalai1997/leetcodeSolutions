class Solution {
	public List<Integer> maxSubset(int ind, int[] nums, List<Integer>[] dp) {
		List<Integer> res = new LinkedList<>();
		if(ind == nums.length) return res;
		if(dp[ind].size() != 0) return dp[ind];
		List<Integer> next = new LinkedList<>();
		for(int i = ind+1; i < nums.length; i++) {
            if(nums[i]%nums[ind] != 0) continue;
			List<Integer> temp = maxSubset(i, nums, dp);
			if(temp.size() > next.size()) next = temp;
}
List<Integer> result = new LinkedList<>();

result.add(nums[ind]);
result.addAll(next);
dp[ind] = result;
return dp[ind];
}
	public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
		int n = nums.length;
		List<Integer> res = new LinkedList<>();
		List<Integer>[] dp = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			dp[i] = new LinkedList<>();
}
		for(int i = 0; i < n; i++) {
			List<Integer> temp = maxSubset(i, nums, dp);
			if(temp.size() > res.size()) res = temp;
}
return res;
}
}
