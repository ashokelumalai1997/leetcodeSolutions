class Solution {
	public int minCut(String s) {
		int n = s.length();
		boolean[][] isPal = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			isPal[i][i] = true;
}

for(int i = 0; i < n - 1; i++) {
	if(s.charAt(i) == s.charAt(i+1)) {
		isPal[i][i+1]  = true;
}
}



for(int i = 2; i < n; i++) {
	for(int j = 0; j + i < n; j++) {
		if(s.charAt(j) == s.charAt(i+j)) {
			isPal[j][i+j] = isPal[j+1][i+j-1];
}
}
}

int[][] dp = new int[n][n];

for(int[] d : dp) {
	Arrays.fill(d, -1);
}

return getPart(dp, 0, 0, s, isPal) - 1;
}



private int getPart(int[][] dp, int start, int ind, String s, boolean[][] isPal) {
	if(start == s.length()) return 0;

	if(ind == s.length()) {
		return Integer.MAX_VALUE;
    }

    if(dp[start][ind] != -1) return dp[start][ind];

    int cont = getPart(dp, start, ind+1, s, isPal);
    int brea = Integer.MAX_VALUE;
    if(isPal[start][ind]) {
	    int temp = getPart(dp, ind+1, ind+1, s, isPal);
	    if(temp != Integer.MAX_VALUE)
	    brea = 1 + temp;
    }

    return dp[start][ind] = Math.min(cont, brea);
}
}
