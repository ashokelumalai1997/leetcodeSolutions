class Solution {
    public int getMinSquareCount(int n, int[] dp) {
	    if(n == 0) return 0;
	    if(n < 0) return Integer.MAX_VALUE;
	    if(dp[n] != -1) return dp[n];
	    int sum = Integer.MAX_VALUE;
	    for(int i = 1; i*i <= n; i++) {
            int next = getMinSquareCount(n-i*i, dp);
            if(next != Integer.MAX_VALUE) {
                sum = Math.min(next+1, sum);
            }
		    
        }
        return dp[n] = sum;
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return getMinSquareCount(n, dp);
    }
}