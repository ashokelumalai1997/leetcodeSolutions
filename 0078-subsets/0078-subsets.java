class Solution {
	public void generateSubsets(int ind, int[] nums, List<Integer> current, List<List<Integer>> global) {
		if(ind == nums.length) {
			List<Integer> temp = new ArrayList<>(current);
			global.add(temp);
			return;
}

current.add(nums[ind]);
generateSubsets(ind + 1, nums, current, global);
current.remove(current.size()-1);
generateSubsets(ind + 1, nums, current, global);
}


	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current  = new ArrayList<>();
		generateSubsets(0, nums, current, result);
        return result;
}
}
