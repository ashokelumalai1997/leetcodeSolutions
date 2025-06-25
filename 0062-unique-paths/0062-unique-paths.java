
class Solution {
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];

		for(int i = 0; i < m; i++) {
			res[i][n - 1] = 1;
}	

		for(int j = 0; j < n; j++) {
			res[m - 1][j] = 1;
}	

for(int i = m - 2; i >= 0; i--) {
	for(int j = n - 2; j >= 0; j--) {
		res[i][j] = res[i + 1][j] + res[i][j + 1];
}
}

return res[0][0];
}
}
