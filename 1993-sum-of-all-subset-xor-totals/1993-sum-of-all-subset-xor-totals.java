class Solution {
	public void subset(int ind, int[] nums, int currentXOR, Integer[] totalXOR) {
		if(ind == nums.length) {
			totalXOR[0] += currentXOR;
			return;
}

subset(ind + 1, nums, currentXOR^nums[ind], totalXOR);
subset(ind + 1, nums, currentXOR, totalXOR);
		
}
	public int subsetXORSum(int[]  nums) {
		Integer currentXOR = 0;
		Integer[] totalXOR = new Integer[]{0};
		subset(0, nums, currentXOR, totalXOR);
		return totalXOR[0];
}
}
