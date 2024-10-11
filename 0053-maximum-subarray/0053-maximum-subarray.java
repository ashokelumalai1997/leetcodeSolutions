class Solution {
    public int maxSubArray(int[] nums) {
        int sum = -1;
        int n = nums.length;
        int result = nums[0];
        for(int i = 0; i < n; i++) {
            if(sum < 0) sum = 0;
            sum += nums[i];
            result = Math.max(sum, result);
        }
        return result;
    }
}