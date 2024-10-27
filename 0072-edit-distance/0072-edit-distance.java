class Solution {
    private int editDistance(int[][] dp, int ind1, int ind2, String word1, String word2) {
        if(ind1 == word1.length() && ind2 == word2.length()) return 0;

        if(ind1 == word1.length()) return word2.length() - ind2;
        if(ind2 == word2.length()) return word1.length() - ind1;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(word1.charAt(ind1) == word2.charAt(ind2)) 
            return editDistance(dp, ind1+1, ind2+1, word1, word2);
        
        int replace = 1 + editDistance(dp, ind1+1, ind2+1, word1, word2);
        int delete = 1 + editDistance(dp, ind1+1, ind2, word1, word2);
        int insert = 1 + editDistance(dp, ind1, ind2+1, word1, word2);

        return dp[ind1][ind2] = Math.min(replace, Math.min(delete, insert));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        // if(word1.length() < word2.length()) return editDistance(0, 0, word2, word1);
        return editDistance(dp, 0, 0, word1, word2);
    }
}