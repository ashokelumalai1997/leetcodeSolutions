class Solution {
    public int countSquares(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];
        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int current = mat[i][j];
                int up = i-1 >= 0 ? dp[i-1][j] : 0;
                int left = j-1 >= 0 ? dp[i][j-1] : 0;
                int upLeft = i-1 >= 0 && j-1 >= 0 ? dp[i-1][j-1] : 0;
                dp[i][j] = current == 0 ? 0 : current + Math.min(up, Math.min(left, upLeft));
                res += dp[i][j];
            }
        }
        return res;
    }
}