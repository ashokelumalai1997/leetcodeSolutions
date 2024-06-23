class Solution {
    
    public long maximumTotalCost(int[] nums) {
        long[][] dp = new long[nums.length + 1][2];
        for(int i = nums.length - 1; i >= 0; i --) {
            for(int j = 0; j < 2; j++ ) {
                long startingNew = dp[i + 1][0] + nums[i];
                long addingToExisting = dp[i + 1][j == 0? 1 : 0] + nums[i]*(j == 0 ? -1 : 1);
                dp[i][j] = Math.max(startingNew, addingToExisting);
            }
        }
        return dp[0][1];
    }

}