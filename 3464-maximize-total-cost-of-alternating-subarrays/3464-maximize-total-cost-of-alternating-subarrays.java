class Solution {
    private long calculateMaxCost(int index, int multiplier, int[] nums, long[][] memo) {
        if(index == nums.length) return 0;
        if(memo[index][multiplier == -1 ? 0 : 1] != -1) return memo[index][multiplier == -1 ? 0 : 1];
        long startingNew = nums[index] + calculateMaxCost(index + 1, -1, nums, memo);
        long addingToExisting = nums[index]*multiplier + calculateMaxCost(index + 1, multiplier*-1, nums, memo);
        return memo[index][multiplier == -1 ? 0 : 1] = Math.max(startingNew, addingToExisting);
    }
    public long maximumTotalCost(int[] nums) {
        // long result = 0;
        // long[][] memo = new long[nums.length][2];
        // for(long[] m : memo) {
        //     Arrays.fill(m, -1);
        // }
        // result = calculateMaxCost(0, 1, nums, memo);
        // return result;

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