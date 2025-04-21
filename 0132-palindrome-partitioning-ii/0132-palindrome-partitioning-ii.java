class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        // Fill isPal[i][j]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }

        // dp[i] = min cuts needed for s[0..i]
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0; // no cut needed
            } else {
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}
