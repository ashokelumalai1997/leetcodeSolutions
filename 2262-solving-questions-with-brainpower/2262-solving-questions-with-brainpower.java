
class Solution {
	public long getScore(int index, int[][] questions, long[] dp) {
		if(index >= questions.length) return 0;
		
		if(dp[index] != -1) return dp[index];
		
		long pick = questions[index][0] + getScore(index + 1+ questions[index][1], questions, dp);
		long notPick = getScore(index + 1, questions, dp);
		return dp[index] =  Math.max(pick, notPick);
}
	public long mostPoints(int[][] questions) {
		int n = questions.length;
		long[] dp = new long[n];
		Arrays.fill(dp, -1);
		return getScore(0, questions, dp);
}
}
