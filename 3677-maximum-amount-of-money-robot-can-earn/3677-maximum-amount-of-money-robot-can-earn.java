class Solution {

    private int getMax(int[][][] dp, int[][] coins, int r, int c, int usedPowers) {
        int m = coins.length;
        int n = coins[0].length;

        if(r == m || c == n) {
            
            return -10000000;
        }

        if(r == m-1 && c == n-1) {
            if(coins[r][c] < 0 && usedPowers < 2) {
                return 0;  // Can neutralize if powers left
            }
            return coins[r][c];
        }

        if(dp[r][c][usedPowers] != 1000000000) return dp[r][c][usedPowers];

        int goRight = getMax(dp, coins, r, c+1, usedPowers);
        int goDown = getMax(dp, coins, r+1, c, usedPowers);


        int with = Math.max(goRight, goDown);

        if(with != -10000000) with += coins[r][c];
        int withOut = Integer.MIN_VALUE;

        if(usedPowers < 2 && coins[r][c] < 0) {
            goRight = getMax(dp, coins, r, c+1, usedPowers+1);
            goDown = getMax(dp, coins, r+1, c, usedPowers+1);
            withOut = Math.max(withOut, goDown);
            withOut = Math.max(withOut, goRight);
        }

        // int withOut = Math.max(goRight, goDown);

        return dp[r][c][usedPowers] = Math.max(with, withOut);
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], 1000000000);
            }
        }
        return getMax(dp, coins, 0, 0, 0);
    }
}

