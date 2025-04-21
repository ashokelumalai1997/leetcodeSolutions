class Solution {
	public int minCut(String s) {
		int n = s.length();

		boolean[][] isPal = new boolean[n][n];

		for(int i = 0; i < n; i++) {
			isPal[i][i] = true;
			if(i+1 < n && s.charAt(i) == s.charAt(i+1)) isPal[i][i+1] = true;
}
		
		for(int i = 2; i < n; i++) {
			for(int j = 0; j + i < n; j++) {
				if(s.charAt(j) == s.charAt(j + i)) {
					isPal[j][j + i] = isPal[j+1][j+i-1];
}
}
}

int[][] dp = new int[n][n];

// for(int[] d : dp) {
// 	Arrays.fill(d, Integer.MAX_VALUE);
// }

// dp[i][j] = if(j to i is pal) min(1 + dp[i+1][i+1], dp[i+1][j])
			// else dp[i+1][j]

for(int i = 0; i < n; i++) {
	if(isPal[i][n-1])
	dp[n-1][i] = 1;
else 
	dp[n-1][i] = Integer.MAX_VALUE;
}

for(int i = n-2; i >= 0; i--) {
	for(int j = 0; j < n; j++) {
		if(isPal[j][i] && dp[i+1][i+1] != Integer.MAX_VALUE) {
			dp[i][j] = Math.min(1 + dp[i+1][i+1], dp[i+1][j]);
			
} else {
	dp[i][j] = dp[i+1][j];
}
		
}
}

return dp[0][0]-1;
}
}
