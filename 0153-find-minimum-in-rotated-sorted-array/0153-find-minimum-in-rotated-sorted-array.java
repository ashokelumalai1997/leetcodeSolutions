class Solution {
	public int findMin(int[] nums) {
		int n = nums.length;
		int l = 0;
		int r = n-1;
		while(l <= r) {
			int m = l + (r - l)/2;
			if(nums[l] <= nums[r]) return nums[l];

			if(nums[m] < nums[r]) {
				if(nums[m-1] > nums[m]) return nums[m];
				r = m - 1;
} else {
	l = m + 1;
}
}

return -1;
}
}
