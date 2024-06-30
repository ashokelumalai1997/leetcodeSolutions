class Solution {
    public int maximumLength(int[] nums, int k) {
        /*
        index
        2*k
        dp[index][sum] = dp[prevIndex][sum] + 1
        */
        for(int i = 0; i < nums.length; i ++) {
            nums[i]%=k;
        }
        int n = nums.length;
        int[][] dp = new int[n][2*k];
        for(int[] d : dp) {
            Arrays.fill(d, 1);
        }
        int ans = 0;
        for(int i = 1; i < nums.length; i++) {
            // int maxPrevLen = 0;
            for(int j = 0; j < i; j++) {
                int sum = nums[i] + nums[j];
                // maxPrevLen = Math.max(maxPrevLen, dp[j][sum]);
                dp[i][sum] = dp[j][sum] + 1;
                ans = Math.max(ans, dp[i][sum]);
            }
            
        }
        return ans;
    }
}