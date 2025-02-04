class Solution {
    private int skipOrGo(int[][] dp, int i1, int i2, String text1, String text2) {
        if(i1 == text1.length() || i2 == text2.length()) {
            return 0;
        }

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(text1.charAt(i1) == text2.charAt(i2)) {
            return 1 + skipOrGo(dp, i1+1, i2+1, text1, text2);
        }

        int op1 = skipOrGo(dp, i1+1, i2, text1, text2);
        int op2 = skipOrGo(dp, i1, i2+1, text1, text2);

        return dp[i1][i2] = Math.max(op1, op2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];

        for(int i = 0; i < n1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return skipOrGo(dp, 0, 0, text1, text2);
    }
}