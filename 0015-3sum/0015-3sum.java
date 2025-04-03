class Solution {
	List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();
		
		int n = nums.length;
		for(int i = 0; i < n; i++) {
            			while(i > 0 && i < n && nums[i] == nums[i-1]) i++;
			int j = i+1;
            int k = n-1;
            while(j < k) {
					int val = -1*( nums[j] + nums[k]);
					if(nums[i] == val) {
						List<Integer> entry = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
						result.add(entry);
						j++;
						while(j < n && (nums[j] == nums[j-1]) ) j++;
} else if(nums[i] > val) {
	k--;
} else {
	j++;
}
        }
}

return result;
}
}
