class Solution {
    private int longestPal(int[][] memo, int s, int e, String str) {

        if(s == e) return 1;
        if(e == s+1) return (str.charAt(s) == str.charAt(e) ? 2 : 1);

        if(memo[s][e] != -1) return memo[s][e];
        if(str.charAt(s) == str.charAt(e)) {
            return memo[s][e] = 2 + longestPal(memo, s+1, e-1, str);
        }


        return memo[s][e] = Math.max(longestPal(memo, s+1, e, str) , longestPal(memo, s, e-1, str));


    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] memo = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return longestPal(memo, 0, n-1, s);
    }
}