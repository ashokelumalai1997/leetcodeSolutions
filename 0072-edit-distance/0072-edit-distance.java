class Solution {
    private int getMinOp(int[][] dp, int i1, int i2, String word1, String word2) {
        if(i1 == word1.length()) {
            return word2.length() - i2;
        }

        if(i2 == word2.length()) {
            return word1.length() - i1;
        }

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(word1.charAt(i1) == word2.charAt(i2)) {
            return getMinOp(dp, i1+1, i2+1, word1, word2);
        }

        int op1 = 1 + getMinOp(dp, i1, i2+1, word1, word2);
        int op2 = 1 + getMinOp(dp, i1+1, i2, word1, word2);
        int op3 = 1 + getMinOp(dp, i1 + 1, i2+1, word1, word2);

        return dp[i1][i2] = Math.min(op1, Math.min(op2, op3));
    }
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1][n2];
        for(int i = 0 ; i < n1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getMinOp(dp, 0, 0, word1, word2);
    }
}