
class Solution {
	public int singleNonDuplicate(int[] nums) {
		int n = nums.length;
		int l = 0;
		int r = n-1;
		
		while(l <= r) {
if(l == r) return nums[l];
	
			int m = l + (r - l) / 2;
			
			if(nums[m+1] == nums[m]) {
				if((m + 2)%2 == 0) {
					l = m + 2;
} else {
	r = m - 1;
}
} else {
	if((m + 1)%2 == 0) {
					l = m + 1;
} else {
	r = m;
}
}
			
}

return 0;
}
}
