
class Solution {
    private int LIS(int[][] dp, int ind, int lastTakenInd, int[] nums) {
        if(ind == nums.length) return 0;


        if(dp[ind][lastTakenInd+1] != -1) return dp[ind][lastTakenInd+1];
        int taken = 0;
        int notTaken = 0;
        if(lastTakenInd == -1 || nums[lastTakenInd] < nums[ind]) {
            taken = 1 + LIS(dp, ind+1, ind, nums);
        }

        notTaken = LIS(dp, ind+1, lastTakenInd, nums);

        return dp[ind][lastTakenInd+1] = Math.max(taken, notTaken);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return LIS(dp, 0, -1, nums);
    }
}