class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int n = nums.length;
        int currentSum = 0;
        for(int i = 0; i < n; i++) {
            if(currentSum < 0) currentSum = nums[i];
            else currentSum += nums[i];
            res = Math.max(currentSum, res);
        }
        return res;
    }
}