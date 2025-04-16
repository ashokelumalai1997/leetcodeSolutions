// class Solution {
//     public long countGood(int[] nums, int k) {
        
//     }
// }


class Solution {
	public long countGood(int[] nums, int k) {
				int n = nums.length;
		long totalSubArrays = 0;
		int totalPairs = 0;
		int right = 0;
		int left = 0;

		Map<Integer, Integer> freq = new HashMap<>();
		
		while(right < n) {
			
			freq.put(nums[right]
, freq.getOrDefault(nums[right], 0) + 1);
			totalPairs += (freq.get(nums[right]) - 1);
while(left < right && totalPairs >= k) {
totalSubArrays += (n-right);
totalPairs -= (freq.get(nums[left]) - 1);
			freq.put(nums[left]
, freq.get(nums[left]) - 1);
			left++;

}
			// if(totalPairs >= k) totalSubArrays += (n-left+1);
			right++;
}
return totalSubArrays;
}
}

