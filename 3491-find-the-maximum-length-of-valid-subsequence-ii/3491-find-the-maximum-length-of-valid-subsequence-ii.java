class Solution {
    public int maximumLength(int[] nums, int k) {
        int n=nums.length;
        int ans=1;
        int[][] dp = new int[n][k];
        for(int[] d : dp) {
            Arrays.fill(d, 1);
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                int x=(nums[i]+nums[j])%k;
                dp[i][x]=dp[j][x]+1;
                ans=Math.max(ans,dp[i][x]);
            }
        }
        return ans;
    }
}