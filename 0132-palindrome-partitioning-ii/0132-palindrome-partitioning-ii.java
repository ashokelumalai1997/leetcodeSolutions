class Solution {

    private boolean isPal(int start, int end, String s, int[][] palMemo) {
        if(palMemo[start][end] != -1) return palMemo[start][end] == 1;
        if(start >= end) return true;

        boolean res = s.charAt(start) == s.charAt(end) && 
                                isPal(start+1, end-1, s, palMemo);

        palMemo[start][end] = res ? 1 : 0;

        return palMemo[start][end] == 1;
    }
    private int cutOrContinue(int ind, int palStart, String s, int[][] memo, int[][] palMemo) {
        if(ind == s.length()) {
            if(isPal(palStart, ind-1, s, palMemo)) return 0;
            return Integer.MAX_VALUE;
        }

        if(memo[ind][palStart] != -1) return memo[ind][palStart];

        int cut = Integer.MAX_VALUE;

        if(isPal(palStart, ind, s, palMemo)) {
            cut = cutOrContinue(ind+1, ind+1, s, memo, palMemo);
            if(cut != Integer.MAX_VALUE) cut++;
        }

        int cont = cutOrContinue(ind+1, palStart, s, memo, palMemo);
        return memo[ind][palStart] = Math.min(cut, cont);
    }
    public int minCut(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        int[][] palMemo = new int[n+1][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
            Arrays.fill(palMemo[i], -1);
        }
        return cutOrContinue(0, 0, s, memo, palMemo);
    }
        
}


