class Solution {

    private int costOfPass(int[][][] dp, int ind, int[] days, int[] costs, int last30, int last7) {
        if(ind == days.length) return 0;


        if(dp[ind+1][last30+1][last7+1] != -1) return dp[ind+1][last30+1][last7+1];

        int dayPass = costs[0] + costOfPass(dp, ind+1, days, costs, last30, last7);
        int sevenDayPass = 0;
        if(last7 >= 0 && days[last7] + 6 >= days[ind]) {
            sevenDayPass = costOfPass(dp, ind+1, days, costs, last30, last7);
        } else {
            sevenDayPass = costs[1] + costOfPass(dp, ind+1, days, costs, last30, ind);
        }

        int thirtyDayPass = 0;

        if(last30 >= 0 && days[last30] + 29 >= days[ind]) {
            thirtyDayPass = costOfPass(dp, ind+1, days, costs, last30, last7);
        } else {
            thirtyDayPass = costs[2] + costOfPass(dp, ind+1, days, costs, ind, last7);
        }

        return dp[ind+1][last30+1][last7+1] = Math.min(dayPass, Math.min(sevenDayPass, thirtyDayPass));

    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[][][] dp = new int[n+1][n+1][n+1];


        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return costOfPass(dp, 0, days, costs, -1, -1);
    }
}