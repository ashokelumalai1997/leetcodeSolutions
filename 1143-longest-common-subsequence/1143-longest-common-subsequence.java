class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for(int i = 0; i < n1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getCommonLength(0,0,text1, text2, dp);
    }

    private int getCommonLength(int i1, int i2, String text1, String text2, int[][] dp) {
        if(i1 == text1.length() || i2 == text2.length()) return 0;
        if(dp[i1][i2] != -1) return dp[i1][i2];
        if(text1.charAt(i1) == text2.charAt(i2)) return dp[i1][i2] = 1 + getCommonLength(i1+1, i2+1, text1, text2, dp);
        int count1 = getCommonLength(i1+1, i2, text1, text2, dp);
        int count2 = getCommonLength(i1, i2+1, text1, text2, dp);

        return dp[i1][i2] = Math.max(count1, count2);
    }
}