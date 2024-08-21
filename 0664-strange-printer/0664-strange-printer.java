class Solution {
    private int getMinTurns(int[][] memo, String s, int start, int end) {
        if(start > end) return 0;
        if(memo[start][end] != -1) return memo[start][end];
        int turns = 1 + getMinTurns(memo, s, start+1, end);
        for(int i = start + 1; i <= end; i++) {
            if(s.charAt(i) == s.charAt(start)) {
                int current = getMinTurns(memo, s, start, i-1) + getMinTurns(memo, s, i+1, end);
                turns = Math.min(turns, current);
            }
        }
        return memo[start][end] = turns;
    }

    private String getTrimmedStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ) {
            sb.append(s.charAt(i));
            int j = i;
            while(i < s.length() && s.charAt(i) == s.charAt(j)) i++;
        }
        return sb.toString();
    }

    public int strangePrinter(String s) {
        String trimmedStr = getTrimmedStr(s);
        int n = trimmedStr.length();
        int[][] memo = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        return getMinTurns(memo, trimmedStr, 0, n-1);
    }
}


/*

abcdabdcb

Worst case - n




*/