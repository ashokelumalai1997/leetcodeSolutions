class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n+1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return LIS(0, -1, nums, dp);
    }

    public int LIS(int current, int lastTakenInd, int[] nums, int[][] dp) {
        if(current == nums.length) {
            return 0;
        }

        if(dp[current][lastTakenInd+1] != -1) return dp[current][lastTakenInd+1];

        int taken = 0;
        if(lastTakenInd == -1 || nums[lastTakenInd] < nums[current]) {
            taken = 1 + LIS(current + 1, current, nums, dp);
        }
        int notTaken = LIS(current+1, lastTakenInd, nums, dp);

        return dp[current][lastTakenInd+1] = Math.max(taken, notTaken);
    }
}