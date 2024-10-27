class Solution {
    private int lcs(int[][] dp, int ind1, int ind2, String s1, String s2) {
        if(ind1 == s1.length()) return 0;
        if(ind2 == s2.length()) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcs(dp, ind1+1, ind2+1, s1, s2);
        }

        int m1 = lcs(dp, ind1 + 1, ind2 +1, s1, s2);
        int m2 = lcs(dp, ind1 + 1, ind2, s1, s2);
        int m3 = lcs(dp, ind1, ind2+1, s1, s2);

        return dp[ind1][ind2] = Math.max(Math.max(m1, m2), m3);

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i ++) {
            Arrays.fill(dp[i], -1);
        }
        return lcs(dp, 0, 0, text1, text2);
    }
}