class Solution {
    public int minDifference(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        if(n < 5) return result;
        result = nums[n-1] - nums[3];
        result = Math.min(result, nums[n-2] - nums[2]);
        result = Math.min(result, nums[n-3] - nums[1]);
        result = Math.min(result, nums[n-4] - nums[0]);
        return result;
    }
}