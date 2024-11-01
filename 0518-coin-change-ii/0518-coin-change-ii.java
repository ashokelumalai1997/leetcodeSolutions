class Solution {
    private int totalOptions(int[][] dp, int coinIndex, int sum, int[] coins) {
        if(sum == 0) return 1;

        if(coinIndex == coins.length) return 0;

        if(dp[coinIndex][sum] != -1) return dp[coinIndex][sum];

        int take = 0;
        if(coins[coinIndex] <= sum) {
            take = totalOptions(dp, coinIndex, sum-coins[coinIndex], coins);
        }

        int notTake = totalOptions(dp, coinIndex+1, sum, coins);

        return dp[coinIndex][sum] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i ++) Arrays.fill(dp[i], -1);
        return totalOptions(dp, 0, amount, coins);
    }
}


                // base case
                //     if(sum needed is zero) return 1
                
                // if(index of coin exceeds boundary) return 0;
                
                // either 
                //     if(current coin is within the sum needed)continue taking the current coin 
                //     or 
                //     move to next coin
                // return sum of ctoniue and move