class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int n = nums.length;
        int overallSum = sum;
        for(int i = 1; i < n; i ++) {
            if(nums[i] > nums[i-1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            overallSum = Math.max(overallSum, sum);
        }

        return overallSum;
    }
}