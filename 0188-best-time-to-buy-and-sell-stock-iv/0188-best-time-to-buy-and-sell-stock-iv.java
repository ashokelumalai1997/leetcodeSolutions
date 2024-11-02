class Solution {
    private int profit(int[][][] dp, int ind, int sign, int needed, int[] prices) {
        if(needed == 0) return 0;

        if(ind == prices.length) return Integer.MIN_VALUE;

        if(dp[ind][sign][needed] != -1) return dp[ind][sign][needed];

        int multiplier = (sign == 0) ? -1 : 1;

        int nextSign = (sign == 1) ? 0 : 1;

        int take = 0;

        int next = profit(dp, ind+1, nextSign, needed-1, prices);

        if(next != Integer.MIN_VALUE) take = prices[ind]*multiplier + next;

        int notTake = profit(dp, ind+1, sign, needed, prices);

        return dp[ind][sign][needed] = Math.max(take, notTake);
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int pro = 0;

        for(int pr = 1; pr <= k; pr++) {
            int[][][] dp = new int[n][2][pr*2+1];

            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < 2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            int res = profit(dp, 0, 0, pr*2, prices);

            res = (res < 0) ? 0 : res;

            pro = Math.max(pro, res);
        }

        return pro;
    }
}