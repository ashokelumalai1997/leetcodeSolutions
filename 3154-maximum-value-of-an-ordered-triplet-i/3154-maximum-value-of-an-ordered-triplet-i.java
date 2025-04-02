// class Solution {
//     public long maximumTripletValue(int[] nums) {
        
//     }
// }

class Solution {
	public long maximumTripletValue(int[] nums) {
		int n = nums.length;
		long maxi = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				for(int k = j+1; k < n; k++) {
					maxi = Math.max(maxi, nums[k]*(long)(nums[i] - nums[j]));
}
}
}

return maxi >= 0 ? maxi : 0;
}
}
