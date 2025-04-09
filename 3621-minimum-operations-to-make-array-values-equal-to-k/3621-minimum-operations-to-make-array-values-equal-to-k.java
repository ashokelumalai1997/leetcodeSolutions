class Solution {
	public int minOperations(int[] nums, int k) {
		Set<Integer> maxs = new HashSet<>();
		for(int num : nums) {
			if(num < k) return -1;
			if(num > k) maxs.add(num);
}
return maxs.size();
}
}
