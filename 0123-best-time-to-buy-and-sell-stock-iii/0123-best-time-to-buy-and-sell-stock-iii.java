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
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][2][5];

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int pro = profit(dp, 0, 0, 4, prices);
        pro = (pro < 0) ? 0 : pro;

        int[][][] dp1 = new int[n][2][3];

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < 2; j++) {
                Arrays.fill(dp1[i][j], -1);
            }
        }


        int pro1 = profit(dp1, 0, 0, 2, prices);
        pro1 = (pro1 <0) ? 0 : pro1;

        

        return Math.max(pro, pro1);
    }
}


// - + - +


// if(needed = 0) return 0;
// if(i == n) return MIN


// f(i, 0, 4) -> Max (f(i+1,0,4) and f(i+1, 1, 3) )

// f(i,0, 4) maximum sum starting at index i if num[i] is negatively added
// f(i, 1,4) maximum sum starting at index i if num[i] is positively added


// 3  5 1 2 3

