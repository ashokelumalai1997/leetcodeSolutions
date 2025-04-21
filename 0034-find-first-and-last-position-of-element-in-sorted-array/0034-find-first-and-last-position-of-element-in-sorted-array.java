class Solution {
	public int[] searchRange(int[] nums, int target) {
		int n = nums.length;
		
		int firstInd = findFirstInd(nums, target);
		int lastInd = findLastInd(nums, target);

		return new int[]{firstInd, lastInd};
		
}

private int findLastInd(int[] nums, int target) {
	int n = nums.length;
	int left = 0;
	int right = n-1;
	int ind = -1;
	while(left <= right) {
		int mid = left + (right - left)/2;
		if(nums[mid] <= target) {
			if(nums[mid] == target) ind = mid;
			left  = mid + 1;
} else {
			right = mid - 1;
}
}

return ind;
}

private int findFirstInd(int[] nums, int target) {
	int n = nums.length;
	int left = 0;
	int right = n-1;
	int ind = -1;
	while(left <= right) {
		int mid = left + (right - left)/2;
		
		if(nums[mid] >= target) {
			if(nums[mid] == target) ind = mid;
			right = mid - 1;
} else {
	left  = mid + 1;
}
}

return ind;
}
}
