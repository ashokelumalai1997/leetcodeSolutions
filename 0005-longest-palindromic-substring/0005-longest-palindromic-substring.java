class Solution {
    private boolean isPal(int start, int end, String s, int[][] memo) {
        if(start >= end) return true;

        if(memo[start][end] != -1) return memo[start][end] == 1;

        boolean res = s.charAt(start) == s.charAt(end) 
                            && isPal(start+1, end-1, s, memo);
        
        memo[start][end] = res ? 1: 0;

        return memo[start][end] == 1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();

        int[][] memo = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        for(int i = n-1; i >= 0; i --) {
            for(int j = 0; j < n; j++) {
                if(j+i < n && isPal(j, j+i, s, memo)) {
                    return s.substring(j, j+i+1);
                }
            }
        }
        return null;
    }
}