class Solution {
    private int getMaxSubs(int[][] dp, int sInd, int tInd, String s, String t) {
        // if reached end of index of pattern, return 1
        if(tInd == t.length()) return 1;

        // if reached end of string return 0
        if(sInd == s.length()) return 0;

        if(dp[sInd][tInd] != -1) return dp[sInd][tInd];

        // match and move if char matches
        int matchAndMove = 0;
        if(s.charAt(sInd) == t.charAt(tInd)) {
            matchAndMove = getMaxSubs(dp, sInd+1, tInd+1, s, t);
        }
        // skip and move

        int skipAndMove = getMaxSubs(dp, sInd+1, tInd, s, t);

        // return sum of match and move and skip and move
        return dp[sInd][tInd] = matchAndMove + skipAndMove;

    }
    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen][tlen];
        for(int i = 0; i < slen; i++) Arrays.fill(dp[i], -1);
        return getMaxSubs(dp, 0, 0, s, t);
    }
}

// r   a   b   b   b   i   t





// r   a   b   b   i   t


// abbc

// abc


// f(sInd, pInd)

// f(0,0) - 2