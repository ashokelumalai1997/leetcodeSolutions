class Solution {
    
    public long maximumTotalCost(int[] nums) {
        long[] dp = new long[2];
        for(int i = nums.length - 1; i >= 0; i --) {
            long[] currentDp = new long[2];
            for(int j = 0; j < 2; j++ ) {
                long startingNew = dp[0] + nums[i];
                long addingToExisting = dp[j == 0? 1 : 0] + nums[i]*(j == 0 ? -1 : 1);
                currentDp[j] = Math.max(startingNew, addingToExisting);
            }
            dp[0] = currentDp[0];
            dp[1] = currentDp[1];
        }
        return dp[1];
    }

}