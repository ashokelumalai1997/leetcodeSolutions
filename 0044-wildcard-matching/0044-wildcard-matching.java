class Solution {
    public boolean isMatch(String s, String p) {
        String pr = removeDup(p);
        int[][] dp = new int[pr.length()][s.length()];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return canMatch(0, 0, s, pr, dp);
    }

    private String removeDup(String p) {
        StringBuilder sb = new StringBuilder();

        for(char ch : p.toCharArray()) {
            if(ch != '*' || sb.length() == 0 || sb.charAt(sb.length() - 1) != '*') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private boolean canMatch(int sInd, int pInd, String s, String p, int[][] dp) {
        if(sInd == s.length() && pInd == p.length()) {
            return true;
        }
        if(pInd == p.length()) {
            return false;
        }
        if(sInd == s.length()) {
            if(pInd + 1 == p.length() && p.charAt(pInd) == '*') {
                return true;
            }
            return false;
        }
        if(dp[pInd][sInd] != -1) {
            return dp[pInd][sInd] == 1 ? true : false;
        }
        if(s.charAt(sInd) == p.charAt(pInd) || p.charAt(pInd) == '?') {
            dp[pInd][sInd] = canMatch(sInd+1, pInd+1, s, p, dp) ? 1 : 0;
        }
        if(p.charAt(pInd) == '*') {
            boolean skip = canMatch(sInd, pInd + 1, s, p, dp);
            boolean dontSkip = canMatch(sInd + 1, pInd, s, p, dp);
            dp[pInd][sInd] =  (skip || dontSkip) ? 1 : 0;
        }
        return dp[pInd][sInd] == 1;
    }
}