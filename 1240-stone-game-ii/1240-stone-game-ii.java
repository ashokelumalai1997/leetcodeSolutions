class Solution {
    private int[] maxAliceCanGet(int[][][][] dp, int[] piles, int ind, boolean aliceTurn, int M) {
        if(ind >= piles.length) return new int[]{0, 0};
        if(dp[ind][M][aliceTurn ? 0 : 1][0] != -1) return dp[ind][M][aliceTurn ? 0 : 1];
        int indLimit = ind + 2*M;
        int aliceScore = 0;
        int bobScore = 0;
        int currentScore = 0;
        for(int i = ind; i < indLimit && i < piles.length; i++) {
            currentScore += piles[i];
            int[] futureScore = maxAliceCanGet(dp, piles, i+1, !aliceTurn, Math.max(M, i - ind + 1));
            if(aliceTurn) {
                // aliceScore = Math.max(currentScore + futureScore[0], aliceScore);
                // bobScore = futureScore[1];
                if(currentScore + futureScore[0] > aliceScore) {
                    bobScore = futureScore[1];
                    aliceScore = currentScore + futureScore[0];
                }
            } else {
                if(currentScore + futureScore[1] > bobScore) {
                    aliceScore = futureScore[0];
                    bobScore = currentScore + futureScore[1];
                }
                
            }
        }
        return dp[ind][M][aliceTurn ? 0 : 1] = new int[]{aliceScore, bobScore};
    }
    public int stoneGameII(int[] piles) {
        int[][][][] dp = new int[piles.length][2*piles.length + 1][2][2];
        for(int i = 0; i < piles.length; i++) {
            for(int j = 0; j < 2*piles.length + 1; j++) {
                Arrays.fill(dp[i][j][0], -1);
                Arrays.fill(dp[i][j][1], -1);
            }
        }
        return maxAliceCanGet(dp, piles, 0, true, 1)[0];
    }
}