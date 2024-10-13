class Solution {
    char[] possibleChars = new char[]{'F', 'W', 'E'};
    
    private boolean isWin(char A, char B) {
        if(A == 'E' && B == 'F') return true;
            else if(A == 'W' && B == 'E') return true;
            else if(A == 'F' && B == 'W') return true;
            return false;
    }
    
    private int getTotalWaysToWin(int[][][] dp, int index,int wins, int ties, char cantTakeChar, char[] aliceChars, char[] bobChars) {
        if(index == aliceChars.length) {
            // return (index - ties - wins) < wins  ? 1 : 0;
            return wins > 0 ? 1 : 0;
        }
        
        int cantTakeIndex = cantTakeChar == 'F' ? 0 : (cantTakeChar == 'W' ? 1 : (cantTakeChar == 'E' ? 2 : 3));

        int winsInd = wins >= 0 ? wins : aliceChars.length + Math.abs(wins);
        // int winsInd = wins + aliceChars.length;
        
        if(dp[index][winsInd][cantTakeIndex] != -1) return dp[index][winsInd][cantTakeIndex];
        
        int res = 0;
        
        for(char c : possibleChars) {
            if(c != cantTakeChar) {
                bobChars[index] = c;
                int cWin = isWin(aliceChars[index], bobChars[index]) == true ? 1 : 0;
                int cTie = aliceChars[index] == bobChars[index] ? 1 : 0;
                if(cTie == 0 && cWin != 1) cWin = -1;
                res += getTotalWaysToWin(dp, index + 1, wins + cWin, ties + cTie, c, aliceChars, bobChars)%1000000007;
                res %= 1000000007;
            }
        }
        return dp[index][winsInd][cantTakeIndex] = res%1000000007;
    }
    
    public int countWinningSequences(String s) {
        int n = s.length();
        char[] bobChars = new char[n];
        int[][][] dp = new int[n][2*n+1][4];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n+1; j++) {
                // for(int k = 0; k < n; k++) {
                Arrays.fill(dp[i][j], -1);
                // }
            }
        
        }
        return getTotalWaysToWin(dp, 0, 0, 0, 'A', s.toCharArray(), bobChars);    
        
    }
}