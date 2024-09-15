class Solution {
    private long solve(long[][] memo, int aInd, int bInd, int[] a, int[] b) {
        if (aInd == a.length) {
            return 0;
        }
        if (bInd == b.length) {
            return Long.MIN_VALUE;
        }
        if (memo[aInd][bInd] != Long.MIN_VALUE) {
            return memo[aInd][bInd];
        }
        long take = Long.MIN_VALUE;
        long afterTake = solve(memo, aInd + 1, bInd + 1, a, b);
        if(afterTake != Long.MIN_VALUE) take = afterTake + (long)a[aInd]*b[bInd];
        long nTake = solve(memo, aInd, bInd + 1, a, b);
        memo[aInd][bInd] = Math.max(take, nTake);
        return memo[aInd][bInd];
    }

    public long maxScore(int[] a, int[] b) {
        long[][] memo = new long[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                memo[i][j] = Long.MIN_VALUE;
            }
        }
        long cur = 0;
        return solve(memo, 0, 0, a, b);
    }
}