class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][k];
        for(Integer[] d : dp) {
            Arrays.fill(d, 1);
        }

        // Initialize base cases
        for (int i = 0; i < n; i++) {
            dp[i][nums[i] % k] = 1;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[j] + nums[i]) % k;
                if (dp[j][mod] != null) {
                    dp[i][mod] = Math.max(dp[i][mod] == null ? 1 : dp[i][mod], dp[j][mod] + 1);
                }
            }
            // Update the result with the longest subsequence found ending at index i
            for (int mod = 0; mod < k; mod++) {
                if (dp[i][mod] != null) {
                    res = Math.max(res, dp[i][mod]);
                }
            }
        }

        return res;
    }
}
