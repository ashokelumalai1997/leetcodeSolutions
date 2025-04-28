class Solution {
	public long countSubarrays(int[] nums, long k) {
		int l = 0;
		int r = 0;
		long sum = 0;
		long res = 0;
		int n = nums.length;
		
		while(r < n) {
			sum += nums[r];
			while(l < r && sum * (r - l + 1) >= k) {
				sum -= nums[l];
				l++;
}
if(sum*(r - l + 1) < k) res += (r - l + 1);
r++;
}

return res;
}
}
