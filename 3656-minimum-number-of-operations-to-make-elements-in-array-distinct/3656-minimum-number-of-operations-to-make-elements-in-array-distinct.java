class Solution {
	public int minimumOperations(int[] nums) {
		int n = nums.length;
		int right = n-1;
        Set<Integer> st = new HashSet<>();
		while(right >= 0 && !st.contains(nums[right])) {
            st.add(nums[right]);
			right--;
}
if(right == -1) return 0;
return ((right+1)/3) + (((right + 1)%3 == 0) ? 0 : 1);
}
}
